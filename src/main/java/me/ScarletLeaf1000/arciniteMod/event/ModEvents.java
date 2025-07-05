package me.ScarletLeaf1000.arciniteMod.event;


import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.item.ModItems;
import me.ScarletLeaf1000.arciniteMod.item.custom.HammerItem;
import me.ScarletLeaf1000.arciniteMod.item.custom.ModArmorItem;
import me.ScarletLeaf1000.arciniteMod.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = ArciniteMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();


    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRegister(RegisterBrewingRecipesEvent e){
        PotionBrewing.Builder builder = e.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.ARCINITE_ESSENCE.get(), ModPotions.FRENZIED_POTION);
        builder.addMix(ModPotions.FRENZIED_POTION, Items.GLOWSTONE_DUST, ModPotions.FRENZIED_STRONG_POTION);
        builder.addMix(ModPotions.FRENZIED_POTION, Items.REDSTONE, ModPotions.FRENZIED_LONG_POTION);
    }
}

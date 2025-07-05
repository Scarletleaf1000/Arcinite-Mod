package me.ScarletLeaf1000.arciniteMod.item;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Display;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArciniteMod.MOD_ID);

    public static final Supplier<CreativeModeTab> ARCINITE_MOD_TAB = CREATIVE_MODE_TAB.register("arcinite_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ARCINITE_ESSENCE.get()))
                    .title(Component.translatable("creativetab.sanctarcinite.arcinite_items"))
                    .withSearchBar()
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ARCINITE_ESSENCE);
                        output.accept(ModItems.ARCINITE_INGOT);
                        output.accept(ModItems.ARCINITE_FLAME);
                        output.accept(ModItems.CONSTAL_SMITHING_TEMPLATE);

                        output.accept(ModItems.ARCINITE_CHISEL);
                        output.accept(ModItems.ARCINITE_SWORD);
                        output.accept(ModItems.ARCINITE_PICKAXE);
                        output.accept(ModItems.ARCINITE_AXE);
                        output.accept(ModItems.ARCINITE_SHOVEL);
                        output.accept(ModItems.ARCINITE_HOE);
                        output.accept(ModItems.ARCINITE_HAMMER);
                        output.accept(ModItems.ARCINITE_BOW);

                        output.accept(ModItems.ARCINITE_HELMET);
                        output.accept(ModItems.ARCINITE_CHESTPLATE);
                        output.accept(ModItems.ARCINITE_LEGGINGS);
                        output.accept(ModItems.ARCINITE_BOOTS);

                        output.accept(ModBlocks.ARCINITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_ARCINITE_ORE);
                        output.accept(ModBlocks.ARCINITE_BLOCK);

                        output.accept(ModBlocks.ARCINITE_REFINERY);
                        output.accept(ModBlocks.ARCINITE_LAMP);

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}


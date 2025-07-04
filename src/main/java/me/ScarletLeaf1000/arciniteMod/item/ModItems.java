package me.ScarletLeaf1000.arciniteMod.item;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.item.custom.ChiselItem;
import me.ScarletLeaf1000.arciniteMod.item.custom.FuelItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ArciniteMod.MOD_ID);

    public static final DeferredItem<Item> ARCINITE_ESSENCE = ITEMS.register("arcinite_essence",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_essence.tooltip"));

                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> ARCINITE_INGOT = ITEMS.register("arcinite_ingot",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_ingot.tooltip"));

                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> ARCINITE_CHISEL = ITEMS.register("arcinite_chisel",
            () -> new ChiselItem(new Item.Properties()
                    .durability(512)));
    public static final DeferredItem<Item> ARCINITE_FLAME = ITEMS.register("arcinite_flame",
            () -> new FuelItem(new Item.Properties(), 6400) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_flame.tooltip"));

                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}

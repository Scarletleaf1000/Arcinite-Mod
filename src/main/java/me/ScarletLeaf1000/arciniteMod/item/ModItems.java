package me.ScarletLeaf1000.arciniteMod.item;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.item.custom.HammerItem;
import me.ScarletLeaf1000.arciniteMod.item.custom.ChiselItem;
import me.ScarletLeaf1000.arciniteMod.item.custom.FuelItem;
import me.ScarletLeaf1000.arciniteMod.item.custom.ModArmorItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
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
    public static final DeferredItem<Item> CONSTAL_SMITHING_TEMPLATE = ITEMS.register("constal_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(ArciniteMod.MOD_ID, "constal")));

    public static final DeferredItem<Item> ARCINITE_CHISEL = ITEMS.register("arcinite_chisel",
            () -> new ChiselItem(new Item.Properties()
                    .durability(512)));
    public static final DeferredItem<SwordItem> ARCINITE_SWORD = ITEMS.register("arcinite_sword",
            () -> new SwordItem(ModToolTiers.ARCINITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ARCINITE, 3, -2.3f))));
    public static final DeferredItem<PickaxeItem> ARCINITE_PICKAXE = ITEMS.register("arcinite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ARCINITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ARCINITE, 1, -2.6f))));
    public static final DeferredItem<AxeItem> ARCINITE_AXE = ITEMS.register("arcinite_axe",
            () -> new AxeItem(ModToolTiers.ARCINITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ARCINITE, 5.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> ARCINITE_SHOVEL = ITEMS.register("arcinite_shovel",
            () -> new ShovelItem(ModToolTiers.ARCINITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ARCINITE, 1.5F, -2.8f))));
    public static final DeferredItem<HoeItem> ARCINITE_HOE = ITEMS.register("arcinite_hoe",
            () -> new HoeItem(ModToolTiers.ARCINITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ARCINITE, 1, 0.2f))));
    public static final DeferredItem<HammerItem> ARCINITE_HAMMER = ITEMS.register("arcinite_hammer",
            () -> new HammerItem(ModToolTiers.ARCINITE_HAMMER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ARCINITE_HAMMER, 7, -3.1f))));
    public static final DeferredItem<Item> ARCINITE_BOW = ITEMS.register("arcinite_bow",
            () -> new BowItem(new Item.Properties()
                    .durability(1100)) {
                @Override
                public int getDefaultProjectileRange() {
                    return 50;
                }

                @Override
                protected void shootProjectile(
                        LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target
                ) {
                    projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
                }

                /**
                 * Gets the velocity of the arrow entity from the bow's charge
                 */
                public static float getPowerForTime(int charge) {
                    float f = (float)charge / 20.0F;
                    f = (f * f + f * 2.0F) / 3.0F;
                    if (f > 1.0F) {
                        f = 1.0F;
                    }

                    return f * 2.5F;
                }
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_bow.tooltip"));

                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<ArmorItem> ARCINITE_HELMET = ITEMS.register("arcinite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ARCINITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(35)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_armor.tooltip"));
                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> ARCINITE_CHESTPLATE = ITEMS.register("arcinite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ARCINITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(35)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_armor.tooltip"));
                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> ARCINITE_LEGGINGS = ITEMS.register("arcinite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ARCINITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(35)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_armor.tooltip"));
                    }else{
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> ARCINITE_BOOTS = ITEMS.register("arcinite_boots",
            () -> new ModArmorItem(ModArmorMaterials.ARCINITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(35)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_armor.tooltip"));
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

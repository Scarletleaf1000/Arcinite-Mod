package me.ScarletLeaf1000.arciniteMod.item;

import me.ScarletLeaf1000.arciniteMod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ARCINITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ARCINITE_TOOL,
            1700, 10.5F, 3.5F, 19, () -> Ingredient.of(ModItems.ARCINITE_INGOT));
    public static final Tier ARCINITE_HAMMER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ARCINITE_TOOL,
            1200, 4.5F, 3.5F, 19, () -> Ingredient.of(ModItems.ARCINITE_INGOT));
}

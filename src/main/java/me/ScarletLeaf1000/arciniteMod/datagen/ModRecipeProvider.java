package me.ScarletLeaf1000.arciniteMod.datagen;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.block.ModBlocks;
import me.ScarletLeaf1000.arciniteMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> ARCINITE_SMELTABLES = List.of(ModBlocks.ARCINITE_ORE, ModBlocks.DEEPSLATE_ARCINITE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ARCINITE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.ARCINITE_INGOT.get())
                .unlockedBy("has_arcinite", has(ModItems.ARCINITE_INGOT)).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ARCINITE_INGOT.get(), 9)
                .requires(ModBlocks.ARCINITE_BLOCK)
                .unlockedBy("has_arcinite", has(ModItems.ARCINITE_INGOT)).save(recipeOutput);

        oreSmelting(recipeOutput, ARCINITE_SMELTABLES, RecipeCategory.MISC, ModItems.ARCINITE_ESSENCE, 4f, 200, "arcinite_ore");
        oreBlasting(recipeOutput, ARCINITE_SMELTABLES, RecipeCategory.MISC, ModItems.ARCINITE_ESSENCE, 4f, 100, "arcinite_ore");

        trimSmithing(recipeOutput, ModItems.CONSTAL_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(ArciniteMod.MOD_ID, "constal"));
    }
}

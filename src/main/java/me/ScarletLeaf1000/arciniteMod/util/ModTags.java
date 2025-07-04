package me.ScarletLeaf1000.arciniteMod.util;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ARCINITE_TOOL = createTag("needs_arcinite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ARCINITE_TOOL = createTag("incorrect_for_arcinite_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ArciniteMod.MOD_ID, name));
        }
    }
}

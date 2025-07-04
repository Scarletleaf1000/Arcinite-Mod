package me.ScarletLeaf1000.arciniteMod.datagen;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ArciniteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.SWORDS)
                .add(ModItems.ARCINITE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.ARCINITE_PICKAXE.get())
                .add(ModItems.ARCINITE_HAMMER.get());
        tag(ItemTags.AXES)
                .add(ModItems.ARCINITE_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.ARCINITE_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.ARCINITE_HOE.get());
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARCINITE_HELMET.get())
                .add(ModItems.ARCINITE_CHESTPLATE.get())
                .add(ModItems.ARCINITE_LEGGINGS.get())
                .add(ModItems.ARCINITE_BOOTS.get());
        this.tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.ARCINITE_HELMET.get())
                .add(ModItems.ARCINITE_CHESTPLATE.get())
                .add(ModItems.ARCINITE_LEGGINGS.get())
                .add(ModItems.ARCINITE_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ARCINITE_INGOT.get());
        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.CONSTAL_SMITHING_TEMPLATE.get());
    }
}

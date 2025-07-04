package me.ScarletLeaf1000.arciniteMod.datagen;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ArciniteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ARCINITE_ESSENCE.get());
        basicItem(ModItems.ARCINITE_INGOT.get());
        basicItem(ModItems.ARCINITE_FLAME.get());
        basicItem(ModItems.ARCINITE_CHISEL.get());
    }
}

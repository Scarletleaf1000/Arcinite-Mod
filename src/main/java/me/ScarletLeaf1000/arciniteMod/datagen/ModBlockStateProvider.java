package me.ScarletLeaf1000.arciniteMod.datagen;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.block.ModBlocks;
import me.ScarletLeaf1000.arciniteMod.block.custom.ArciniteLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ArciniteMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ARCINITE_BLOCK);
        blockWithItem(ModBlocks.ARCINITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ARCINITE_ORE);
        blockWithItem(ModBlocks.ARCINITE_REFINERY);

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.ARCINITE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(ArciniteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("arcinite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(ArciniteMod.MOD_ID, "block/" + "arcinite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("arcinite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(ArciniteMod.MOD_ID, "block/" + "arcinite_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.ARCINITE_LAMP.get(), models().cubeAll("arcinite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(ArciniteMod.MOD_ID, "block/" + "arcinite_lamp_on")));
    }


    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

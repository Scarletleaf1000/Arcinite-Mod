package me.ScarletLeaf1000.arciniteMod.block;


import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.block.custom.ArciniteLampBlock;
import me.ScarletLeaf1000.arciniteMod.block.custom.ArciniteRefineryBlock;
import me.ScarletLeaf1000.arciniteMod.block.custom.PedestalBlock;
import me.ScarletLeaf1000.arciniteMod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(ArciniteMod.MOD_ID);

    public static final DeferredBlock<Block> ARCINITE_BLOCK = registerBlock("arcinite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .strength(10f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ARCINITE_ORE = registerBlock("arcinite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(10f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_ARCINITE_ORE = registerBlock("deepslate_arcinite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .strength(11.5f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ARCINITE_LAMP = registerBlock("arcinite_lamp",
            () -> new ArciniteLampBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.GLASS)
                    .strength(1.5f)
                    .lightLevel(state -> state.getValue(ArciniteLampBlock.CLICKED) ? 15 : 0)));

    public static final DeferredBlock<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of()
                .sound(SoundType.STONE)
                    .strength(3f)
                    .noOcclusion()));
    public static final DeferredBlock<Block> ARCINITE_REFINERY = registerBlock("arcinite_refinery",
            () -> new ArciniteRefineryBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

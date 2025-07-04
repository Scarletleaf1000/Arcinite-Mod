package me.ScarletLeaf1000.arciniteMod.block.custom;

import me.ScarletLeaf1000.arciniteMod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class ArciniteRefineryBlock extends Block {
    public ArciniteRefineryBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.getItem() == ModItems.ARCINITE_ESSENCE.get()){
            if (!level.isClientSide){
                level.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS);
                ItemEntity ient = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.ARCINITE_INGOT.get(), 1));
                level.addFreshEntity(ient);
                stack.setCount(stack.getCount() -1);
            }
        }else{
            level.playSound(null, pos, SoundEvents.ANVIL_HIT, SoundSource.BLOCKS);
        }

        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.arcinite_refinery.tooltip"));

        }else{
            tooltipComponents.add(Component.translatable("tooltip.sanctarcinite.needs_shift.tooltip"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

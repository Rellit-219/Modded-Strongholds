package com.moddedstrongholds.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class EmptyLanternBlock extends LanternBlock {
	
	public EmptyLanternBlock(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		
		if (!world.isRemote()) {
			
			if (player.getHeldItem(hand).getItem() == Items.TORCH) {
				
				player.getHeldItem(hand).shrink(1);
				world.setBlockState(pos, Blocks.LANTERN.getDefaultState().with(HANGING, state.get(HANGING)));
				
				return ActionResultType.SUCCESS;
				
			}
			
			if (player.getHeldItem(hand).getItem() == Items.field_234737_dp_) {
				
				player.getHeldItem(hand).shrink(1);
				world.setBlockState(pos, Blocks.field_235366_md_.getDefaultState().with(HANGING, state.get(HANGING)));
				
				return ActionResultType.SUCCESS;
				
			}
			
		}
		
		return ActionResultType.PASS;
		
	}
	
}
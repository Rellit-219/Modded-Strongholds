package com.moddedstrongholds.registry;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.moddedstrongholds.ModdedStrongholds;
import com.moddedstrongholds.block.MSBlocks;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.template.AlwaysTrueRuleTest;
import net.minecraft.world.gen.feature.template.RandomBlockStateMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleEntry;
import net.minecraft.world.gen.feature.template.RuleStructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessor;

public class ModdedStrongholdPieceRegistry {
	
	public static StructureProcessor BRICK_RANDOMIZATION = null;
	public static StructureProcessor LANTERN_RANDOMIZATION = null;
	public static StructureProcessor PORTAL_FRAME_RANDOMIZATION = null;
	public static StructureProcessor LAVA_RANDOMIZATION = null;
	
	public static final ArrayList<RuleEntry> BRICK_RANDOMIZATION_LIST = new ArrayList<RuleEntry>();
	public static final ArrayList<RuleEntry> LANTERN_RANDOMIZATION_LIST = new ArrayList<RuleEntry>();
	
	public static ArrayList<Pair<JigsawPiece, Integer>> PORTAL_ROOMS = new ArrayList<Pair<JigsawPiece, Integer>>();
	
	public static ArrayList<Pair<JigsawPiece, Integer>> LANTERNS = new ArrayList<Pair<JigsawPiece, Integer>>();
	
	public static void initialize() {
		
		initializeProcessors();
		initializePortalRooms();
		initializeLanternChains();
		
	}
	
	public static void initializeProcessors() {
		
		BRICK_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.STONE_BRICKS.getDefaultState(), 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.INFESTED_STONE_BRICKS.getDefaultState()));
		BRICK_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.STONE_BRICKS.getDefaultState(), 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.INFESTED_CRACKED_STONE_BRICKS.getDefaultState()));
		BRICK_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.STONE_BRICKS.getDefaultState(), 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.INFESTED_MOSSY_STONE_BRICKS.getDefaultState()));
		BRICK_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.STONE_BRICKS.getDefaultState(), 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.getDefaultState()));
		BRICK_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.STONE_BRICKS.getDefaultState(), 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.getDefaultState()));
		
		BRICK_RANDOMIZATION = new RuleStructureProcessor(BRICK_RANDOMIZATION_LIST);
		
		LANTERN_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.LANTERN.getDefaultState().with(BlockStateProperties.HANGING, true), 0.4F), AlwaysTrueRuleTest.INSTANCE, MSBlocks.EMPTY_LANTERN.get().getDefaultState().with(BlockStateProperties.HANGING, true)));
		LANTERN_RANDOMIZATION_LIST.add(new RuleEntry(new RandomBlockStateMatchRuleTest(Blocks.LANTERN.getDefaultState().with(BlockStateProperties.HANGING, false), 0.4F), AlwaysTrueRuleTest.INSTANCE, MSBlocks.EMPTY_LANTERN.get().getDefaultState().with(BlockStateProperties.HANGING, false)));
		
		LANTERN_RANDOMIZATION = new RuleStructureProcessor(LANTERN_RANDOMIZATION_LIST);
		
	}
	
	public static void initializePortalRooms() {
		
		PORTAL_ROOMS.add(Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":modded_stronghold/normal/portal_rooms/portal_room_hub_1", ImmutableList.of(BRICK_RANDOMIZATION, LANTERN_RANDOMIZATION)), 1));
		
		JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(ModdedStrongholds.MODID, "modded_stronghold/portal_rooms"), new ResourceLocation("empty"), PORTAL_ROOMS, JigsawPattern.PlacementBehaviour.RIGID));
		JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(ModdedStrongholds.MODID, "hallways"), new ResourceLocation("empty"), PORTAL_ROOMS, JigsawPattern.PlacementBehaviour.RIGID));
		
	}
	
	public static void initializeLanternChains() {
		
		//LANTERNS.add(Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_still_side_1", ImmutableList.of(BRICK_RANDOMIZATION)), 1));
		
	}
}
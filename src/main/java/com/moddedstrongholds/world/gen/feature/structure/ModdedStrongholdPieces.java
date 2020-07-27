package com.moddedstrongholds.world.gen.feature.structure;

import com.google.common.collect.ImmutableList;
import com.moddedstrongholds.ModdedStrongholds;
import com.mojang.datafixers.util.Pair;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.AlwaysTrueRuleTest;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RandomBlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleEntry;
import net.minecraft.world.gen.feature.template.RuleStructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.TemplateManager;

@SuppressWarnings("deprecation")
public class ModdedStrongholdPieces {
	
	public static void startStructure(ChunkGenerator chunkGeneratorIn, TemplateManager templateManagerIn, BlockPos posIn, List<StructurePiece> structurePieces, SharedSeedRandom p_215139_4_) {
		
		JigsawManager.func_236823_a_(new ResourceLocation(ModdedStrongholds.MODID, "moonshiner_hut/huts"), 3, ModdedStrongholdPieces.Piece::new, chunkGeneratorIn, templateManagerIn, posIn, structurePieces, p_215139_4_, true, true);
		
	}
	
	static {
		
		ImmutableList<StructureProcessor> normalDetails = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE_WALL, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_WALL.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBWEB, 0.6F), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.BARRIER), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()))));
		JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(ModdedStrongholds.MODID, "moonshiner_hut/huts"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/hut_1", normalDetails), 1)), JigsawPattern.PlacementBehaviour.RIGID));
		JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(ModdedStrongholds.MODID, "moonshiner_hut/ladders"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_ladder_1", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_ladder_2", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_ladder_3", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_ladder_4", normalDetails), 1)), JigsawPattern.PlacementBehaviour.RIGID));
		JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(ModdedStrongholds.MODID, "moonshiner_hut/basement_still_sides"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_still_side_1", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_still_side_2", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_still_side_3", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_still_side_4", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_still_side_1", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_still_side_2", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_still_side_3", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_still_side_4", normalDetails), 1)), JigsawPattern.PlacementBehaviour.RIGID));
		JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(ModdedStrongholds.MODID, "moonshiner_hut/basement_barrel_sides"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_barrel_side_1", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_barrel_side_2", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_barrel_side_3", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_barrel_side_4", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_barrel_side_1", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_barrel_side_2", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_barrel_side_3", normalDetails), 1), Pair.of(new SingleJigsawPiece(ModdedStrongholds.MODID + ":moonshiner_hut/basement_hidden_barrel_side_4", normalDetails), 1)), JigsawPattern.PlacementBehaviour.RIGID));
		
	}
	
	public static class Piece extends AbstractVillagePiece {
		
		public Piece(TemplateManager templateManagerIn, JigsawPiece jigsawPieceIn, BlockPos posIn, int p_i50560_4_, Rotation rotationIn, MutableBoundingBox boundsIn) {
			super(MSStructurePieceType.MODDED_STRONGHOLD, templateManagerIn, jigsawPieceIn, posIn, p_i50560_4_, rotationIn, boundsIn);
			
		}
		
		public Piece(TemplateManager templateManagerIn, CompoundNBT nbt) {
			super(templateManagerIn, nbt, MSStructurePieceType.MODDED_STRONGHOLD);
			
		}
		
	}
	
}
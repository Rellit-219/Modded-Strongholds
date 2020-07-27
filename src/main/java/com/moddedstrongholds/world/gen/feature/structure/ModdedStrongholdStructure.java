package com.moddedstrongholds.world.gen.feature.structure;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class ModdedStrongholdStructure extends Structure<NoFeatureConfig> {
	
	public ModdedStrongholdStructure(Codec<NoFeatureConfig> p_i51491_1_) {
		super(p_i51491_1_);
		
	}
	
	public String getName() {
		
		return "stronghold";
		
	}
	
	public GenerationStage.Decoration func_236396_f_() {
		
		return GenerationStage.Decoration.STRONGHOLDS;
				
	}
	
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		
		return ModdedStrongholdStructure.Start::new;
		
	}
	
	public static class Start extends StructureStart<NoFeatureConfig> {
		
		public Start(Structure<NoFeatureConfig> p_i225815_1_, int p_i225815_2_, int p_i225815_3_, MutableBoundingBox p_i225815_4_, int p_i225815_5_, long p_i225815_6_) {
			
			super(p_i225815_1_, p_i225815_2_, p_i225815_3_, p_i225815_4_, p_i225815_5_, p_i225815_6_);
			
		}
		
		public void func_230364_a_(ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome p_230364_5_, NoFeatureConfig p_230364_6_) {
			
			BlockPos blockpos = new BlockPos(chunkX * 16, 90, chunkZ * 16);
			ModdedStrongholdPieces.startStructure(generator, templateManager, blockpos, this.components, this.rand);
			this.recalculateStructureSize();
			
		}
		
	}
	
}
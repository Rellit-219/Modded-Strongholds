package com.moddedstrongholds;

import com.moddedstrongholds.block.MSBlocks;
import com.moddedstrongholds.registry.MSRegistryHandler;
import com.moddedstrongholds.world.gen.feature.structure.MSStructure;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("moddedstrongholds")
public class ModdedStrongholds {
	
	public static final String MODID = "moddedstrongholds";
	
	//public static final ItemGroup MULTIEXPANSION_ITEMGROUP = new MEItemGroup();
	
	public ModdedStrongholds() {
		
		//MinecraftForge.EVENT_BUS.register(new MEEventHandler());
		
		MSRegistryHandler.registerDeferred(FMLJavaModLoadingContext.get().getModEventBus());
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
		//DeferredWorkQueue.runLater(() -> {
			
            //GlobalEntityTypeAttributes.put(MEEntities.TINY_GHAST.get(), TinyGhastEntity.setAttributes().func_233813_a_());
            
        //});
		
		StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> MODDED_STRONGHOLD = MSStructure.MODDED_STRONGHOLD.get().func_236391_a_(NoFeatureConfig.field_236559_b_);
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			
			biome.features.get(GenerationStage.Decoration.STRONGHOLDS).remove(Structure.field_236375_k_);
			biome.func_235063_a_(MODDED_STRONGHOLD);
			
		}
		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		
		RenderTypeLookup.setRenderLayer(MSBlocks.EMPTY_LANTERN.get(), RenderType.getCutoutMipped());
		
		//RenderingRegistry.registerEntityRenderingHandler(MEEntities.TINY_GHAST.get(), new TinyGhastRenderer.RenderFactory());
		
	}
	
}
package com.moddedstrongholds;

import com.moddedstrongholds.block.MSBlocks;
import com.moddedstrongholds.registry.MSRegistryHandler;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.biome.Biome;
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
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			
			if (biome.getCategory() == Biome.Category.NETHER) {
				
				//biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, MEBlocks.RUBY_ORE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 10, 20, 128))));
				
			}
		
		}
		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		
		RenderTypeLookup.setRenderLayer(MSBlocks.EMPTY_LANTERN.get(), RenderType.getCutoutMipped());
		
		//RenderingRegistry.registerEntityRenderingHandler(MEEntities.TINY_GHAST.get(), new TinyGhastRenderer.RenderFactory());
		
	}
	
}
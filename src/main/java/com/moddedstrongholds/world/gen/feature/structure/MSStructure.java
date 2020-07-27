package com.moddedstrongholds.world.gen.feature.structure;

import com.google.common.base.Supplier;
import com.moddedstrongholds.ModdedStrongholds;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MSStructure {
	
	public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, ModdedStrongholds.MODID);
	
	public static final RegistryObject<Structure<NoFeatureConfig>> MODDED_STRONGHOLD = register("modded_stronghold", () -> new ModdedStrongholdStructure(NoFeatureConfig.field_236558_a_));
	
	private static <FC extends IFeatureConfig, S extends Structure<FC>> RegistryObject<S> register(String name, Supplier<S> sup) {
		
		Structure.field_236365_a_.put(sup.get().getStructureName(), sup.get());
		return STRUCTURE_FEATURES.register(name, sup);
		
    }
	
}
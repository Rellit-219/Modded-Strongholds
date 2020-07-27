package com.moddedstrongholds.block;

import java.util.Set;

import com.google.common.base.Supplier;
import com.moddedstrongholds.ModdedStrongholds;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MSBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModdedStrongholds.MODID);
	public static final Set<RegistryObject<Block>> PURE_BLOCKS = new java.util.HashSet<>();
	
	public static final RegistryObject<Block> EMPTY_LANTERN = register("empty_lantern", () -> new EmptyLanternBlock(AbstractBlock.Properties.create(Material.IRON).func_235861_h_().hardnessAndResistance(3.5F).sound(SoundType.LANTERN)));
	
	private static RegistryObject<Block> register(String name, Supplier<? extends Block> sup, boolean hasItem) {
		
		RegistryObject<Block> registryObject = BLOCKS.register(name, sup);
		
		if (!hasItem) {
			
			PURE_BLOCKS.add(registryObject);
		
		}
		
		return registryObject;
		
	}
	
	private static RegistryObject<Block> register(String name, Supplier<? extends Block> sup) {
		
		return register(name, sup, true);
		
	}
	
	public static boolean shouldRegisterItemBlock(Block block) {
		
		for (RegistryObject<Block> pureBlock : PURE_BLOCKS) {
			
			if (pureBlock.get() == block) {
				
				return false;
				
			}
		}
		
		return true;
		
	}
	
}
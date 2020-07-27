package com.moddedstrongholds.registry;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import com.moddedstrongholds.ModdedStrongholds;
import com.moddedstrongholds.block.MSBlocks;
import com.moddedstrongholds.world.gen.feature.structure.MSStructure;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ModdedStrongholds.MODID)
@Mod.EventBusSubscriber(modid = ModdedStrongholds.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class MSRegistryHandler {
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		
		final IForgeRegistry<Item> registry = event.getRegistry();
		AtomicInteger blockItemCount = new AtomicInteger();
		
		MSBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).filter(MSBlocks::shouldRegisterItemBlock).forEach(block -> {
			
			final Item.Properties properties = new Item.Properties().group(ItemGroup.DECORATIONS);
			final BlockItem blockItem = new BlockItem(block, properties);
			
			blockItem.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
			registry.register(blockItem);
			blockItemCount.getAndIncrement();
			
		});
		
	}

	public static void registerDeferred(IEventBus iEventBus) {
		
		MSBlocks.BLOCKS.register(iEventBus);
		MSStructure.STRUCTURE_FEATURES.register(iEventBus);
		
	}
	
}
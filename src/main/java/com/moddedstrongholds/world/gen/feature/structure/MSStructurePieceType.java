package com.moddedstrongholds.world.gen.feature.structure;

import com.moddedstrongholds.ModdedStrongholds;

import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class MSStructurePieceType {
	
	public static final IStructurePieceType MODDED_STRONGHOLD = IStructurePieceType.register(ModdedStrongholdPieces.Piece::new, ModdedStrongholds.MODID + "ModdedStrongholdPieces");
	
}
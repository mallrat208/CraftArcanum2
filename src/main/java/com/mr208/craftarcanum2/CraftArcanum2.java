package com.mr208.craftarcanum2;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CraftArcanum2.MODID, name = CraftArcanum2.NAME, version = CraftArcanum2.VERSION, dependencies = CraftArcanum2.DEPENDENCIES)
public class CraftArcanum2 {

	final static String MODID = "craftarcanum2";
	final static String NAME = "Craft Arcanum 2";
	final static String VERSION = "";
	final static String DEPENDENCIES = "after:Thaumcraft";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

	}
}

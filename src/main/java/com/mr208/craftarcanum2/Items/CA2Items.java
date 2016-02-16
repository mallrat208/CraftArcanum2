package com.mr208.craftarcanum2.Items;

import net.minecraft.item.Item;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mr208.craftarcanum2.CraftArcanum2;

@GameRegistry.ObjectHolder(CraftArcanum2.MODID)
public class CA2Items
{
	public static Item ItemVoxSonitus;

	public static void preInit(FMLPreInitializationEvent event)
	{
		ItemVoxSonitus = new ItemVoxSonitus("voxsonitus",event);
		GameRegistry.registerItem(ItemVoxSonitus);
	}
}

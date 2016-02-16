package com.mr208.craftarcanum2.Items;

import net.minecraft.item.Item;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.mr208.craftarcanum2.CraftArcanum2;

public class ItemCA2 extends Item
{
	public ItemCA2(String itemName, FMLPreInitializationEvent event)
	{
		super();
		setUnlocalizedName(CraftArcanum2.MODID + "." + itemName);
		setRegistryName(itemName);
		setCreativeTab(CraftArcanum2.creativeTab);
	}



}



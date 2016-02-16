package com.mr208.craftarcanum2.Client;

import net.minecraft.client.resources.model.ModelResourceLocation;

import net.minecraftforge.client.model.ModelLoader;

import com.mr208.craftarcanum2.Items.CA2Items;

public class ItemResources
{
	public static void registerItems()
	{
		ModelLoader.setCustomModelResourceLocation(CA2Items.ItemVoxSonitus,0,new ModelResourceLocation(CA2Items.ItemVoxSonitus.getRegistryName()));
	}
}

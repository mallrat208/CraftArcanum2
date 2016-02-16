package com.mr208.craftarcanum2.Proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.mr208.craftarcanum2.Items.CA2Items;

public class CommonProxy implements IProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		CA2Items.preInit(event);
	}

	public void init(FMLInitializationEvent event)
	{

	}

	public void postInit(FMLPostInitializationEvent event)
	{

	}

}

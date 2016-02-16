package com.mr208.craftarcanum2.Proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.mr208.craftarcanum2.Client.ItemResources;

public class ClientProxy extends  CommonProxy
{

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		ItemResources.registerItems();
	}

}

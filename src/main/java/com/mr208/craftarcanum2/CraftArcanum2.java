package com.mr208.craftarcanum2;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.mr208.craftarcanum2.Items.CA2Items;
import com.mr208.craftarcanum2.Proxy.IProxy;

@Mod(modid = CraftArcanum2.MODID, name = CraftArcanum2.NAME, version = CraftArcanum2.VERSION, dependencies = CraftArcanum2.DEPENDENCIES)
public class CraftArcanum2
{

	public final static String MODID = "craftarcanum2";
	public final static String NAME = "Craft Arcanum 2";
	public final static String VERSION = "";
	public final static String DEPENDENCIES = "after:Thaumcraft";
	public final static String COMMONPROXY = "com.mr208.craftarcanum2.Proxy.CommonProxy";
	public final static String CLIENTPROXY = "com.mr208.craftarcanum2.Proxy.ClientProxy";

	@Instance(MODID)
	public static CraftArcanum2 instance;

	@SidedProxy(clientSide = CLIENTPROXY, serverSide = COMMONPROXY, modId = MODID)
	public static IProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

		this.proxy.preInit(event);

	}

	public static CreativeTabs creativeTab = new CreativeTabs(MODID)
	{
		@Override
		public Item getTabIconItem()
		{
			return CA2Items.ItemVoxSonitus;
		}
	};
}

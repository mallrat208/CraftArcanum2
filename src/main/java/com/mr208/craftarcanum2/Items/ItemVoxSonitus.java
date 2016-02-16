package com.mr208.craftarcanum2.Items;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVoxSonitus extends ItemCA2
{
	public ItemVoxSonitus(String unlocalizedName,FMLPreInitializationEvent event)
	{
		super(unlocalizedName,event);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		NBTTagCompound nbtTagCompound = stack.getTagCompound();
		if(nbtTagCompound==null)
		{
			nbtTagCompound = new NBTTagCompound();
			stack.setTagCompound(nbtTagCompound);
		}

		if(!world.isRemote && player.isSneaking())
		{
			TileEntity tile;
			tile = world.getTileEntity(pos);
			if(tile != null && tile instanceof TileEntityNote)
			{
				int instrument = 0;
				Material material = world.getBlockState(pos.add(0,-1,0)).getBlock().getMaterial();

				if (material.equals(Material.rock)) instrument = 1;
				if (material.equals(Material.sand)) instrument = 2;
				if (material.equals(Material.glass)) instrument = 3;
				if (material.equals(Material.wood)) instrument = 4;

				nbtTagCompound.setByte("note", ((TileEntityNote) tile).note);
				nbtTagCompound.setInteger("instrument",instrument);

			}

			return true;
		}

		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		NBTTagCompound nbtTagCompound = stack.getTagCompound();
		if(nbtTagCompound == null) return stack;
		int note = 0;
		int instrument = 0;
		note = nbtTagCompound.getByte("note");
		instrument = nbtTagCompound.getInteger("instrument");

		NoteBlockEvent.Play event = new NoteBlockEvent.Play(world, player.getPosition(), null, note, instrument);
		if(MinecraftForge.EVENT_BUS.post(event)) return stack;


		instrument = event.instrument.ordinal();
		note = event.getVanillaNoteId();

		float f = (float) Math.pow(2.0D, (double) (note - 12)/ 12.0D);
		String sound = "harp";
		if(instrument ==1 ) sound = "bd";
		if(instrument ==2 ) sound = "snare";
		if(instrument ==3 ) sound = "hat";
		if(instrument ==4 ) sound = "bassattack";

		world.playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D,"note." + sound, 3.0F, f);
		world.spawnParticle(EnumParticleTypes.NOTE, player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, (double) note / 24.0D, 0.0D, 0.0D );

		return stack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("Unchecked")
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("item.craftarcanum2.voxsonitus.desc"));
		NBTTagCompound nbtTagCompound = stack.getTagCompound();
		if(nbtTagCompound != null)
		{
			list.add(EnumChatFormatting.BOLD + StatCollector.translateToLocal("item.craftarcanum2.voxsonitus.instrument")+": " + EnumChatFormatting.RESET + nbtTagCompound.getInteger("instrument"));
			list.add(EnumChatFormatting.BOLD + StatCollector.translateToLocal("item.craftarcanum2.voxsonitus.note")+": " + EnumChatFormatting.RESET + nbtTagCompound.getByte("note"));
		}
	}

	@Override
	public void onCreated(ItemStack stack,World world, EntityPlayer player)
	{
		stack.setTagCompound(new NBTTagCompound());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.UNCOMMON;
	}

}

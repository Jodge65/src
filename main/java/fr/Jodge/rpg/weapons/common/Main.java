package fr.Jodge.rpg.weapons.common;

import fr.Jodge.jodgeLibrary.common.toolSet.JScythe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "rpgweapons", name = "RPG Weapons", version = "A0.1.0", dependencies = "after:jodgelibrary", acceptedMinecraftVersions = "[1.8]")
public class Main
{
	public static final String MODID = "rpgweapons";
	public static final String MODNAME = "RPG Weapons";
	public static final String MODVER = "A0.1.0";

	@Mod.Instance("rpgweapons")
	public static Main instance;

	@SidedProxy(clientSide = "fr.Jodge.rpg.weapons.client.ClientProxy", serverSide = "fr.Jodge.rpg.weapons.common.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRender();

		Item stoneScythe = new JScythe("Stone scythe", Blocks.cobblestone, Item.ToolMaterial.STONE, "rpgweapons").activeAutoCraftingRecipe();
		Item ironScythe = new JScythe("Iron scythe", Items.iron_ingot, Item.ToolMaterial.IRON, "rpgweapons").activeAutoCraftingRecipe();
		Item goldScythe = new JScythe("Gold scythe", Items.gold_ingot, Item.ToolMaterial.GOLD, "rpgweapons").activeAutoCraftingRecipe();
		Item diamondScythe = new JScythe("Diamond scythe", Items.diamond, Item.ToolMaterial.EMERALD, "rpgweapons").activeAutoCraftingRecipe();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}

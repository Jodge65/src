package fr.Jodge.jodgeLibrary.common.function;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum JNbtVar
{
	RightCombo("rC"), 
	RightPreviousCombo("rPC"), 
	LeftCombo("lC"), 
	LeftPreviousCombo("lPC"), 
	StartCombo("sC"),
	
	posCenterAreaX("pCAx"),
	posCenterAreaY("pCAy"),
	posCenterAreaZ("pCAz");
	
	private String name = "";

	JNbtVar(String name)
	{
		this.name = name;
	}

	public String toString()
	{
		return name;
	}

	private static boolean write(ItemStack stack, String varName, Object value)
	{
		boolean isWrite = false;
		
		if(value instanceof Integer)
		{
			stack.getTagCompound().setInteger(varName, (int) value);
			isWrite = true;
		}
		else if (value instanceof Double)
		{
			stack.getTagCompound().setDouble(varName, (double) value);
			isWrite = true;
		}
		
		return isWrite;
	}
	
	public static boolean writeNbtVar(ItemStack stack, JNbtVar var, Object value)
	{
		boolean isWrite = false;
		if (stack.hasTagCompound())
		{
			NBTTagCompound itemData = stack.getTagCompound();
			String varName = var.toString();
			if (itemData.hasKey(varName))
			{
				write(stack, varName, value);
				//stack.getTagCompound().setInteger(varName, value);
				isWrite = true;
			}
		}
		return isWrite;
	}
	
/*	public static boolean writeNbtVar(ItemStack stack, JNbtVar var, double value)
	{
		boolean isWrite = false;
		if (stack.hasTagCompound())
		{
			NBTTagCompound itemData = stack.getTagCompound();
			String varName = var.toString();
			if (itemData.hasKey(varName))
			{
				stack.getTagCompound().setDouble(varName, value);
				isWrite = true;
			}
		}
		return isWrite;
	}*/
	
	public static boolean incNbtVarInt(ItemStack stack, JNbtVar var)
	{
		int i = readNbtVarInt(stack, var);
		return writeNbtVar(stack, var, i + 1);
	}

	public static boolean decNbtVarInt(ItemStack stack, JNbtVar var)
	{
		int i = readNbtVarInt(stack, var);
		return writeNbtVar(stack, var, i - 1);
	}

	public static int readNbtVarInt(ItemStack stack, JNbtVar var)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound itemData = stack.getTagCompound();

			String varName = var.toString();

			if (itemData.hasKey(varName))
			{
				return stack.getTagCompound().getInteger(varName);
			}
		}
		return 0;
	}

	public static double readNbtVarDouble(ItemStack stack, JNbtVar var)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound itemData = stack.getTagCompound();

			String varName = var.toString();

			if (itemData.hasKey(varName))
			{
				return stack.getTagCompound().getDouble(varName);
			}
		}
		return 0;
	}

}

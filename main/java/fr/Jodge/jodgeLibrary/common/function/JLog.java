package fr.Jodge.jodgeLibrary.common.function;

import fr.Jodge.jodgeLibrary.common.Main;

public class JLog
{
	public static void write(String text)
	{
		if(Main.DEBUG)
		{
			System.out.println(text);
		}
		else
		{
			writeLog(text);
		}
	}

	private static void writeLog(String text)
	{
		System.out.println(text);
	}

}

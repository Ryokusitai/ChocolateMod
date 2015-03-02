package chocolate;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import eremc.EREMC;
import eremc.EmcHandler;

@Mod(modid = Chocolate.MODID, name =  Chocolate.MODNAME, version =  Chocolate.VERSION)
public class Chocolate
{

	public static final String MODID = "ChocolateMod";
	public static final String MODNAME = "ChocolateMod";
	public static final String VERSION = "@VERSION@";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ObjHandlerChoco.register();
		ObjHandlerChoco.addRecipes();
		ObjHandlerChoco.deleatRecipe();
	}

}

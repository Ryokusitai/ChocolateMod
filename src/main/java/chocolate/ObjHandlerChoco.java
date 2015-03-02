package chocolate;

import java.util.List;

import buildcraft.transport.gates.GateDefinition;
import buildcraft.transport.gates.ItemGate;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.potion.Potion;
import peaa.gameObjs.ObjHandlerPEAA;
import peaa.utils.RecipeCheck;
import cpw.mods.fml.common.registry.GameRegistry;

public class ObjHandlerChoco
{
	public static Item dough = new Item().setCreativeTab(CreativeTabs.tabMaterials)
			.setUnlocalizedName("CookieDough").setTextureName("chocolate:dough");
	public static Item chocolateBucket = new Item().setCreativeTab(CreativeTabs.tabMisc)
			.setUnlocalizedName("ChocolateBucket").setTextureName("chocolate:chocolateBucket").setMaxStackSize(1);
	// 移動速度アップ付与(lv 1, 10秒)
	public static Item chocolateBar = new ItemFood(2, false).setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 10, 0, 1.0F)
			.setCreativeTab(CreativeTabs.tabFood).setUnlocalizedName("ChocolateBar").setTextureName("chocolate:chocolateBar");
	public static Item hotChocolate = new ItemHotChocolate();

	public static void register()
	{
		GameRegistry.registerItem(dough, "Cookie Dough");
		GameRegistry.registerItem(chocolateBucket, "Chocolate Bucket");
		GameRegistry.registerItem(chocolateBar, "Chocolate Bar");
		GameRegistry.registerItem(hotChocolate, "Hot Chocolate");
	}

	public static void addRecipes()
	{
		// 通常レシピ
		GameRegistry.addShapelessRecipe(new ItemStack(dough), new ItemStack(Items.sugar), new ItemStack(Items.sugar),		// クッキーの生地
				new ItemStack(Items.wheat), new ItemStack(Items.wheat), new ItemStack(Items.dye, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(chocolateBucket),	new ItemStack(Items.dye, 1, 3),						// 液体チョコ
				new ItemStack(Items.sugar), new ItemStack(Items.milk_bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(chocolateBar, 8), new ItemStack(chocolateBucket));					// 板チョコ

		// かまどのレシピ追加
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(dough), new ItemStack(Items.cookie, 8),  0);					// クッキー
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(chocolateBucket), new ItemStack(hotChocolate, 8),  0);		// ホットチョコ
	}

	// クッキーのレシピ削除
	public static void deleatRecipe()
	{
		List list = CraftingManager.getInstance().getRecipeList();
		ShapedRecipes source;

		// recipe = 検索したいレシピ
		ShapedRecipes recipe = RecipeCheckChoco.createDataRecipe(new ItemStack(Items.cookie, 8), "WCW", 'W', new ItemStack(Items.wheat), 'C', new ItemStack(Items.dye, 1, 3));
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i) instanceof ShapedRecipes) {
				source = (ShapedRecipes)list.get(i);
				if(RecipeCheckChoco.checkMatchRecipe(recipe, source)) {
					list.remove(i);
				}
			}
		}

	}

}

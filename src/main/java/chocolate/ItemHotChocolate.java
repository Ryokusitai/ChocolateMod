package chocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemHotChocolate extends ItemFood
{
	public ItemHotChocolate()
	{
		super(1, false);
		this.setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood)
			.setUnlocalizedName("HotChocolate").setTextureName("chocolate:hotChocolate");
	}

	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

}

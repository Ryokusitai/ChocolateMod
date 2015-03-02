package chocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

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

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		ItemStack stack2 = super.onEaten(stack, world, player);
		// 80%の可能性でハート0.5回復
		if (world.rand.nextFloat() < 0.8F)
			player.heal(1.0F);
		return stack2;
	}

}

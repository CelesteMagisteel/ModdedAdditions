package xyz.fluxinc.moddedadditions.spells.recipe;

import org.bukkit.inventory.ItemStack;

public abstract class RecipeIngredient {

    public abstract boolean verifyItem(ItemStack stack);
}

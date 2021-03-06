package xyz.fluxinc.moddedadditions.magic.spells;

import org.bukkit.inventory.ItemStack;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

public class SpellRecipe {

    private final List<RecipeIngredient> ingredients = new ArrayList<>();
    private final RecipeIngredient catalyst;
    private final Magic result;

    public SpellRecipe(Magic result, RecipeIngredient catalyst, RecipeIngredient ingredient1, RecipeIngredient ingredient2) {
        this.result = result;
        this.catalyst = catalyst;
        ingredients.add(ingredient1);
        ingredients.add(ingredient1);
        ingredients.add(ingredient1);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient2);
        ingredients.add(ingredient2);
        ingredients.add(ingredient2);
    }

    public SpellRecipe(Magic result, RecipeIngredient catalyst, RecipeIngredient ingredient1, RecipeIngredient ingredient2,
                       RecipeIngredient ingredient3, RecipeIngredient ingredient4) {
        this.result = result;
        this.catalyst = catalyst;
        ingredients.add(ingredient1);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient4);
    }

    public SpellRecipe(Magic result, RecipeIngredient catalyst, RecipeIngredient ingredient1, RecipeIngredient ingredient2,
                       RecipeIngredient ingredient3, RecipeIngredient ingredient4, RecipeIngredient ingredient5,
                       RecipeIngredient ingredient6, RecipeIngredient ingredient7, RecipeIngredient ingredient8) {
        this.result = result;
        this.catalyst = catalyst;
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);
        ingredients.add(ingredient6);
        ingredients.add(ingredient7);
        ingredients.add(ingredient8);
    }

    public Magic getResult() {
        return result;
    }

    public int verifyItems(List<ItemStack> items, ItemStack catalyst) {
        List<ItemStack> itemStacks = new ArrayList<>(items);
        if (!this.catalyst.verifyItem(catalyst)) return 0;
        if (itemStacks.size() != 8) return 0;
        int count = 0;
        for (RecipeIngredient ingredient : ingredients) {
            for (int i = 0; i < itemStacks.size(); i++) {
                if (ingredient.verifyItem(itemStacks.get(i))) {
                    count++;
                    itemStacks.remove(i);
                    break;
                }
            }
        }
        return count;
    }
}

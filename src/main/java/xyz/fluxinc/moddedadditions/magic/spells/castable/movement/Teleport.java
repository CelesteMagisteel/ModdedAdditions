package xyz.fluxinc.moddedadditions.magic.spells.castable.movement;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.fluxinc.moddedadditions.ModdedAdditions;
import xyz.fluxinc.moddedadditions.magic.controller.SpellBookController;
import xyz.fluxinc.moddedadditions.magic.spells.Spell;
import xyz.fluxinc.moddedadditions.magic.spells.SpellRecipe;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.MaterialRecipeIngredient;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.RecipeIngredient;

public class Teleport extends Spell {

    @Override
    public ItemStack getDefaultItem(World.Environment environment, int level) {
        return new ItemStack(Material.ENDER_PEARL);
    }

    @Override
    public String getLocalizedName() {
        return "Teleport";
    }

    @Override
    public String getTechnicalName() {
        return "teleport";
    }

    @Override
    public String getDescription(int level) {
        switch (level) {
            case 1:
                return "Increases the distance!";
            case 2:
                return "Increases the distance further!";
            case 3:
                return "Decreases the cooldown!";
            default:
                return "Teleport to the block you are staring at!";
        }
    }

    @Override
    public int getModelId() {
        return ModdedAdditions.KEY_BASE + SpellBookController.SB_KEY_BASE + 22;
    }

    @Override
    public int getCost(World.Environment environment, int level) {
        return 50;
    }

    @Override
    public String getRiddle(int level) {
        switch (level) {
            case 0:
                return "&9Catalyst: &4Redstone\n\n&9The portal's key holds the truth as to how the tall ones move";
            case 1:
                return "&9Catalyst: &cGlowstone Dust\n\n&9The last stone, the last flower, an ancient head, all wrapped up in a movable storage";
            case 2:
                return "&9Catalyst: &bDiamond\n\n&9With withering petals, the fruits from beyond, crystals formed from the tears of the damned, and Hell's blackest rock";
            default:
                return null;
        }
    }

    @Override
    public long getCooldown(int level) {
        if (level == 4) {
            return 250;
        } else {
            return 500;
        }
    }

    @Override
    public SpellRecipe getRecipe(int level) {
        switch (level) {
            case 0:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.REDSTONE),
                        new MaterialRecipeIngredient(Material.ENDER_PEARL), new MaterialRecipeIngredient(Material.ENDER_EYE));
            case 1:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.GLOWSTONE_DUST),
                        new MaterialRecipeIngredient(Material.END_STONE), new MaterialRecipeIngredient(Material.CHORUS_FLOWER),
                        new MaterialRecipeIngredient(Material.DRAGON_HEAD), new RecipeIngredient() {
                    @Override
                    public boolean verifyItem(ItemStack stack) {
                        return stack.getType().toString().contains("SHULKER_BOX");
                    }
                });
            case 2:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.DIAMOND),
                        new MaterialRecipeIngredient(Material.WITHER_ROSE), new MaterialRecipeIngredient(Material.CHORUS_FRUIT),
                        new MaterialRecipeIngredient(Material.END_CRYSTAL), new MaterialRecipeIngredient(Material.BLACKSTONE));
            default:
                return null;
        }
    }

    @Override
    public boolean enactSpell(Player caster, LivingEntity target, int level) {
        int dist = 100;
        switch (level) {
            case 2:
                dist = 150;
                break;
            case 3:
                dist = 200;
                break;
        }
        Block targetBlock = caster.getTargetBlock(null, dist);
        if (targetBlock.getType() == Material.AIR) {
            caster.getWorld().playSound(caster.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
            return false;
        }
        Location targetLocation = targetBlock.getLocation().add(0, 1, 0);
        if (caster.getWorld().getBlockAt(targetLocation).getType() != Material.AIR) {
            return false;
        }
        targetLocation.setPitch(caster.getLocation().getPitch());
        targetLocation.setYaw(caster.getLocation().getYaw());
        caster.teleport(targetLocation);
        caster.getWorld().playSound(caster.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        return true;
    }
}

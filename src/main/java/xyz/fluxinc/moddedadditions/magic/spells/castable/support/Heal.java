package xyz.fluxinc.moddedadditions.magic.spells.castable.support;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;
import xyz.fluxinc.moddedadditions.ModdedAdditions;
import xyz.fluxinc.moddedadditions.magic.controller.SpellBookController;
import xyz.fluxinc.moddedadditions.magic.spells.Spell;
import xyz.fluxinc.moddedadditions.magic.spells.SpellRecipe;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.MaterialRecipeIngredient;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.PotionRecipeIngredient;

import java.util.ArrayList;
import java.util.List;

public class Heal extends Spell {

    @Override
    public ItemStack getDefaultItem(World.Environment environment, int level) {
        return new ItemStack(Material.GOLDEN_APPLE);
    }

    @Override
    public String getLocalizedName() {
        return "Heal";
    }

    @Override
    public String getTechnicalName() {
        return "heal";
    }

    @Override
    public String getDescription(int level) {
        switch (level) {
            case 1:
                return "Increases the amount healed!";
            case 2:
                return "Further increases the amount healed!";
            case 3:
                return "Heals all friendly mobs in a 5x5 area!";
            default:
                return "Heals your targets HP and Hunger!";
        }
    }


    @Override
    public int getModelId() {
        return ModdedAdditions.KEY_BASE + SpellBookController.SB_KEY_BASE + 40;
    }

    @Override
    public int getCost(World.Environment environment, int level) {
        return 25;
    }

    @Override
    public String getRiddle(int level) {
        switch (level) {
            case 0:
                return "&9Catalyst: &4Redstone\n\n&9The elixir of life gathered from the forbidden fruit";
            case 1:
                return "&9Catalyst: &cGlowstone Dust\n\n&9A sweetened mixture, designed to regenerate and heal, and strengthen";
            case 2:
                return "&9Catalyst: &bDiamond\n\n&9The doctors fear, the sweetened fruit, the orange root and a place to mix them all together";
            default:
                return null;
        }

    }

    @Override
    public long getCooldown(int level) {
        return 250;
    }

    @Override
    public SpellRecipe getRecipe(int level) {
        switch (level) {
            case 0:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.REDSTONE),
                        new PotionRecipeIngredient(PotionType.INSTANT_HEAL), new MaterialRecipeIngredient(Material.GOLDEN_APPLE));
            case 1:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.GLOWSTONE_DUST),
                        new PotionRecipeIngredient(PotionType.INSTANT_HEAL), new PotionRecipeIngredient(PotionType.STRENGTH),
                        new PotionRecipeIngredient(PotionType.REGEN), new MaterialRecipeIngredient(Material.SUGAR));
            case 2:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.DIAMOND),
                        new MaterialRecipeIngredient(Material.SWEET_BERRIES), new MaterialRecipeIngredient(Material.CARROT),
                        new MaterialRecipeIngredient(Material.CAULDRON), new MaterialRecipeIngredient(Material.APPLE));
            default:
                return null;
        }
    }

    @Override
    public boolean enactSpell(Player caster, LivingEntity target, int level) {
        int heal = 2;

        switch (level) {
            case 4:
            case 3:
                ++heal;
            case 2:
                ++heal;
        }
        List<LivingEntity> targets = level == 4 ? getNearbyEntities(target, 5) : new ArrayList<>();
        targets.add(target);

        int counter = 0;
        for (LivingEntity entity : targets) {
            boolean hungerCheck = true;
            if (entity instanceof Player) hungerCheck = ((Player) entity).getFoodLevel() >= 20;
            if (entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() == entity.getHealth() && hungerCheck)
                continue;
            if (healTarget(entity, heal)) counter++;
        }
        if (counter > 0) {
            target.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, target.getLocation(), 50, 0.5, 1, 0.5);
            target.getWorld().playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            return true;
        } else {
            return false;
        }
    }

    private List<LivingEntity> getNearbyEntities(LivingEntity target, int distance) {
        List<LivingEntity> entities = new ArrayList<>();
        for (Entity entity : target.getNearbyEntities(distance, distance, distance)) {
            if (!(entity instanceof LivingEntity)) continue;
            if (entity instanceof Monster) continue;
            entities.add((LivingEntity) entity);
        }
        return entities;
    }

    private boolean healTarget(LivingEntity target, int amount) {
        boolean doneHunger = true;
        boolean doneHealth = true;

        if (target instanceof Player) {
            if (((Player) target).getFoodLevel() == 20) {
                doneHunger = false;
            } else if (((Player) target).getFoodLevel() >= 20 - amount) {
                ((Player) target).setFoodLevel(20);
            } else {
                ((Player) target).setFoodLevel(((Player) target).getFoodLevel() + amount);
            }
        }

        if (target.getHealth() == target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
            doneHealth = false;
        } else if (target.getHealth() >= target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - amount) {
            target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        } else {
            target.setHealth(target.getHealth() + amount);
        }

        return doneHealth || doneHunger;

    }


}
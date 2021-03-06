package xyz.fluxinc.moddedadditions.magic.spells.castable.tank;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.fluxinc.moddedadditions.ModdedAdditions;
import xyz.fluxinc.moddedadditions.magic.controller.SpellBookController;
import xyz.fluxinc.moddedadditions.magic.spells.Spell;
import xyz.fluxinc.moddedadditions.magic.spells.SpellRecipe;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.EnchantedBookRecipeIngredient;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.MaterialRecipeIngredient;

public class HardenedForm extends Spell {

    @Override
    public ItemStack getDefaultItem(World.Environment environment, int level) {
        return new ItemStack(Material.BEDROCK);
    }

    @Override
    public String getLocalizedName() {
        return "Hardened Form";
    }

    @Override
    public String getTechnicalName() {
        return "hardenedform";
    }

    @Override
    public String getDescription(int level) {
        switch (level) {
            case 1:
                return "Increases the potency!";
            case 2:
                return "Increased duration!";
            case 3:
                return "Removes the slowdown!";
            default:
                return "Increases your resistance, while decreasing your speed!";
        }
    }

    @Override
    public int getModelId() {
        return ModdedAdditions.KEY_BASE + SpellBookController.SB_KEY_BASE + 60;
    }

    @Override
    public int getCost(World.Environment environment, int level) {
        return 75;
    }

    @Override
    public String getRiddle(int level) {
        switch (level) {
            case 0:
                return "&9Catalyst: &4Redstone\n\n&9Hard as the rocks closest to the core, you stand strong but slow, as if held by a sticky thread";
            case 1:
                return "&9Catalyst: &cGlowstone Dust\n\n&9Protection of all kinds surrounds and shields you from damage";
            case 2:
                return "&9Catalyst: &bDiamond\n\n&9The Golem's creation gives you an insight, and could be combined on the smiths workbench";
            default:
                return null;
        }
    }

    @Override
    public long getCooldown(int level) {
        return 20 * 1000;
    }

    @Override
    public SpellRecipe getRecipe(int level) {
        switch (level) {
            case 0:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.REDSTONE),
                        new MaterialRecipeIngredient(Material.OBSIDIAN), new MaterialRecipeIngredient(Material.COBWEB));
            case 1:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.GLOWSTONE_DUST),
                        new EnchantedBookRecipeIngredient(Enchantment.PROTECTION_ENVIRONMENTAL), new EnchantedBookRecipeIngredient(Enchantment.PROTECTION_EXPLOSIONS),
                        new EnchantedBookRecipeIngredient(Enchantment.PROTECTION_PROJECTILE), new MaterialRecipeIngredient(Material.SHIELD));
            case 2:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.DIAMOND),
                        new MaterialRecipeIngredient(Material.SNOW_BLOCK), new MaterialRecipeIngredient(Material.IRON_BLOCK),
                        new MaterialRecipeIngredient(Material.PUMPKIN), new MaterialRecipeIngredient(Material.SMITHING_TABLE));
            default:
                return null;
        }
    }

    @Override
    public boolean enactSpell(Player caster, LivingEntity target, int level) {
        if (caster != target) {
            caster.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("The body of your target becomes hard as a rock"));
            if (target instanceof Player) {
                ((Player) target).spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Your body becomes hard as a rock"));
            }
        } else {
            caster.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Your body becomes hard as a rock"));
        }
        new PotionEffect(PotionEffectType.ABSORPTION, (level >= 3 ? 40 : 20) * 20, level >= 2 ? 4 : 2).apply(target);
        new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (level >= 3 ? 40 : 20) * 20, level >= 2 ? 2 : 1).apply(target);
        if (level > 4) {
            new PotionEffect(PotionEffectType.SLOW, 20 * 20, 0).apply(target);
        }
        return true;
    }
}

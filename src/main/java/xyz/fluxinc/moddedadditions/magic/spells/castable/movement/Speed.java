package xyz.fluxinc.moddedadditions.magic.spells.castable.movement;

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
import org.bukkit.potion.PotionType;
import xyz.fluxinc.moddedadditions.ModdedAdditions;
import xyz.fluxinc.moddedadditions.magic.controller.SpellBookController;
import xyz.fluxinc.moddedadditions.magic.spells.Spell;
import xyz.fluxinc.moddedadditions.magic.spells.SpellRecipe;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.EnchantedBookRecipeIngredient;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.MaterialRecipeIngredient;
import xyz.fluxinc.moddedadditions.magic.spells.recipe.PotionRecipeIngredient;

public class Speed extends Spell {

    @Override
    public ItemStack getDefaultItem(World.Environment environment, int level) {
        return new ItemStack(Material.GLOWSTONE_DUST);
    }

    @Override
    public String getLocalizedName() {
        return "Speed";
    }

    @Override
    public String getTechnicalName() {
        return "speed";
    }

    @Override
    public String getDescription(int level) {
        switch (level) {
            case 1:
                return "Increases the duration!";
            case 2:
                return "Increases the potency!";
            case 3:
                return "Increases the duration further!";
            default:
                return "Increase your movement speed!";
        }
    }

    @Override
    public int getModelId() {
        return ModdedAdditions.KEY_BASE + SpellBookController.SB_KEY_BASE + 21;
    }

    @Override
    public int getCost(World.Environment environment, int level) {
        return 50;
    }

    @Override
    public String getRiddle(int level) {
        switch (level) {
            case 0:
                return "&9Catalyst: &4Redstone\n\n&9Sweetening your life, this will make you faster than light";
            case 1:
                return "&9Catalyst: &cGlowstone Dust\n\n&9A bottle of liquid speed held to you, combined with an elixir of health, given form within a liquid basin, and fermented with the eye of the dead";
            case 2:
                return "&9Catalyst: &cDiamond\n\n&9Faster flight, quicker than lightning, energetic beyond the norm, and riding high";
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
                        new MaterialRecipeIngredient(Material.GLOWSTONE_DUST), new MaterialRecipeIngredient(Material.SUGAR));
            case 1:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.GLOWSTONE_DUST),
                        new PotionRecipeIngredient(PotionType.SPEED), new PotionRecipeIngredient(PotionType.INSTANT_HEAL),
                        new MaterialRecipeIngredient(Material.CAULDRON), new MaterialRecipeIngredient(Material.FERMENTED_SPIDER_EYE));
            case 2:
                return new SpellRecipe(this, new MaterialRecipeIngredient(Material.DIAMOND),
                        new EnchantedBookRecipeIngredient(Enchantment.ARROW_DAMAGE), new EnchantedBookRecipeIngredient(Enchantment.CHANNELING),
                        new MaterialRecipeIngredient(Material.SUGAR), new MaterialRecipeIngredient(Material.SADDLE));
            default:
                return null;
        }
    }

    @Override
    public boolean enactSpell(Player caster, LivingEntity target, int level) {
        if (caster != target) {
            caster.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("The body of your target becomes faster"));
            if (target instanceof Player) {
                ((Player) target).spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Your feel your body become faster as mana courses through you"));
            }
        } else {
            caster.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Your feel your body become faster as mana courses through you"));
        }
        int dur = 20;
        int amp = 4;
        switch (level) {
            case 4:
                dur = 40;
            case 3:
                amp = 5;
                break;
            case 2:
                dur = 30;
                break;
        }
        new PotionEffect(PotionEffectType.SPEED, 20 * dur, amp).apply(target);
        return true;
    }
}

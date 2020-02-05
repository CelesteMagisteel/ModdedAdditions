package xyz.fluxinc.moddedadditions.spells.castable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.fluxinc.moddedadditions.ModdedAdditions;
import xyz.fluxinc.moddedadditions.spells.Spell;

import static xyz.fluxinc.fluxcore.utils.LoreUtils.addLore;

public class Fireball extends Spell {

    public Fireball(ModdedAdditions instance) { super(instance); }

    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public ItemStack getItemStack(int modelId) {
        ItemStack fireball = addLore(new ItemStack(Material.FIRE_CHARGE), "Costs: " + getCost() + " Mana");
        ItemMeta iMeta = fireball.getItemMeta(); iMeta.setCustomModelData(modelId); iMeta.setDisplayName(ChatColor.WHITE + getName());
        fireball.setItemMeta(iMeta);
        return fireball;
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public boolean enactSpell(Player caster, LivingEntity target) {
        org.bukkit.entity.Fireball fireball = caster.launchProjectile(org.bukkit.entity.Fireball.class);
        fireball.setYield(2);
        caster.getWorld().playSound(caster.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1, 1);
        return true;
    }
}

package xyz.fluxinc.moddedadditions.spells.castable;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.fluxinc.moddedadditions.ModdedAdditions;
import xyz.fluxinc.moddedadditions.spells.Spell;

import static xyz.fluxinc.fluxcore.utils.LoreUtils.addLore;

public class Teleport extends Spell {

    public Teleport(ModdedAdditions instance) { super(instance); }

    @Override
    public String getName() {
        return "Teleport";
    }

    @Override
    public ItemStack getItemStack(int modelId) {
        ItemStack teleport = addLore(new ItemStack(Material.ENDER_PEARL), "Costs: " + getCost() + " Mana");
        ItemMeta iMeta = teleport.getItemMeta(); iMeta.setCustomModelData(modelId); iMeta.setDisplayName(ChatColor.WHITE + getName());
        teleport.setItemMeta(iMeta);
        return teleport;
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public void castSpell(Player caster, LivingEntity target) {
        if (getInstance().getManaController().getMana(caster) >= getCost()) {
            caster.launchProjectile(EnderPearl.class);
            getInstance().getManaController().useMana(caster, getCost());
        } else { caster.getWorld().playSound(caster.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1); }
    }
}
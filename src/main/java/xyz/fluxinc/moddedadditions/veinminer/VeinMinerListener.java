package xyz.fluxinc.moddedadditions.veinminer;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.fluxinc.fluxcore.security.CoreProtectLogger;
import xyz.fluxinc.fluxcore.utils.BlockUtils;
import xyz.fluxinc.moddedadditions.common.hooks.JobsRebornHook;
import xyz.fluxinc.moddedadditions.common.hooks.McMMOHook;
import xyz.fluxinc.moddedadditions.common.storage.PlayerData;

import java.util.List;

import static xyz.fluxinc.fluxcore.utils.MineabilityUtils.verifyBlockMining;
import static xyz.fluxinc.fluxcore.utils.ToolUtils.*;
import static xyz.fluxinc.moddedadditions.ModdedAdditions.instance;

public class VeinMinerListener implements Listener {

    @EventHandler
    public void blockBreakListener(BlockBreakEvent event) {
        if (!event.getPlayer().isSneaking()) return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE && !instance.getVeinMinerController().getAllowInCreative())
            return;
        if (!verifyBlockMining(event.getPlayer().getInventory().getItemInMainHand(), event.getBlock().getType()))
            return;
        PlayerData playerData = instance.getPlayerDataController().getPlayerData(event.getPlayer());
        if (!playerData.veinMiner()) {
            return;
        }

        ItemStack mainHandItem = event.getPlayer().getInventory().getItemInMainHand();
        Material toolMat = mainHandItem.getType();
        if (toolMat == Material.SHEARS && instance.getVeinMinerController().checkShears(event.getBlock().getType())) {
            processBlocks(event.getBlock(), event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer());
        } else if (pickaxes.contains(toolMat) && instance.getVeinMinerController().checkPickaxe(event.getBlock().getType())) {
            processBlocks(event.getBlock(), event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer());
        } else if (axes.contains(toolMat) && instance.getVeinMinerController().checkAxe(event.getBlock().getType())) {
            processBlocks(event.getBlock(), event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer());
        } else if (shovels.contains(toolMat) && instance.getVeinMinerController().checkShovel(event.getBlock().getType())) {
            processBlocks(event.getBlock(), event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer());
        } else if (hoes.contains(toolMat) && instance.getVeinMinerController().checkHoe(event.getBlock().getType())) {
            processBlocks(event.getBlock(), event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer());
        } else if (instance.getVeinMinerController().checkHand(event.getBlock().getType())) {
            processBlocks(event.getBlock(), event.getPlayer());
        }
    }

    private void processBlocks(Block block, ItemStack toolUsed, Player player) {
        ItemStack tool = toolUsed.clone();
        ItemMeta iMeta = tool.getItemMeta();
        if (iMeta != null) {
            iMeta.setLore(null);
            tool.setItemMeta(iMeta);
        }
        List<Block> blockList = BlockUtils.getVMBlockList(block, instance.getVeinMinerController().getMaxBlocks(), true);
        blockList.remove(0);
        int remainingDurability = getRemainingDurability(toolUsed);
        int blocksBroken = 0;
        for (Block b : blockList) {
            if (instance.getBlockAccessController().checkBreakPlace(player, block.getLocation(), false)) {
                try { JobsRebornHook.addExperienceForBlockBreak(block, player); } catch (NoClassDefFoundError ignored) {}
                McMMOHook.addBlockExperience(block.getState(), player);
                blocksBroken++;
                CoreProtectLogger.logBlockBreak(player, b);
                b.breakNaturally(tool);
                if (remainingDurability - blocksBroken < 1) {
                    break;
                }
            }
        }
        takeDurability(player, toolUsed, blocksBroken);
    }

    private void processBlocks(Block block, Player player) {
        List<Block> blockList = BlockUtils.getVMBlockList(block, instance.getVeinMinerController().getMaxBlocks());
        blockList.remove(0);
        for (Block b : blockList) {
            if (instance.getBlockAccessController().checkBreakPlace(player, block.getLocation(), false)) {
                CoreProtectLogger.logBlockBreak(player, b);
                b.breakNaturally();
            }
        }
    }

}

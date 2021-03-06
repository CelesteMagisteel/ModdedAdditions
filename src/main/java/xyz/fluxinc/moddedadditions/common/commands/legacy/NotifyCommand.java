package xyz.fluxinc.moddedadditions.common.commands.legacy;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;
import static xyz.fluxinc.moddedadditions.ModdedAdditions.instance;

public class NotifyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(instance.getLanguageManager().generateMessage("nf-invalidUsage"));
            return true;
        }
        Player target = getServer().getPlayer(args[0]);
        if (target != null) {
            target.playSound(target.getLocation(), Sound.BLOCK_BELL_USE, 50, 1);
            sender.sendMessage(instance.getLanguageManager().generateMessage("nf-notifySender", getReplaceArray((Player) sender, target)));
            target.sendMessage(instance.getLanguageManager().generateMessage("nf-notifyTarget", getReplaceArray((Player) sender, target)));
        } else {
            sender.sendMessage(instance.getLanguageManager().generateMessage("userNotFound"));
        }
        return true;
    }

    private Map<String, String> getReplaceArray(Player sender, Player target) {
        Map<String, String> returnVals = new HashMap<>();
        returnVals.put("sender", sender.getName());
        returnVals.put("dsender", sender.getDisplayName());
        returnVals.put("target", target.getName());
        returnVals.put("dtarget", target.getDisplayName());
        return returnVals;
    }
}
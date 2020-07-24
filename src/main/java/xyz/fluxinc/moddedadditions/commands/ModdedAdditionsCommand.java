package xyz.fluxinc.moddedadditions.commands;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.EntitySelectorArgument;
import dev.jorel.commandapi.arguments.LiteralArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.fluxinc.moddedadditions.utils.registries.ItemRegistry;
import xyz.fluxinc.moddedadditions.storage.ExecutorStorage;
import xyz.fluxinc.moddedadditions.storage.PlayerData;

import java.util.*;

import static xyz.fluxinc.moddedadditions.ModdedAdditions.instance;

public class ModdedAdditionsCommand {


    private static HashMap<String, ExecutorStorage> getCommands() {
        HashMap<String, ExecutorStorage> returnVal = new HashMap<>();
        // Give Command
        LinkedHashMap<String, Argument> arguments = new LinkedHashMap<>();
        arguments.put("give", new LiteralArgument("give"));
        arguments.put("player", new EntitySelectorArgument(EntitySelectorArgument.EntitySelector.MANY_PLAYERS));
        arguments.put("item", new StringArgument().overrideSuggestions(ItemRegistry.getAllItemNames().toArray(new String[0])));
        returnVal.put("give", new ExecutorStorage((sender, args) -> {
            if (!(sender.hasPermission("moddedadditions.give"))) {
                sendPermissionDenied(sender);
                return;
            }
            Collection<Player> targets = new ArrayList<>();
            if (args[0] == null && sender instanceof Player) {
                targets.add((Player) sender);
            } else if (args[0] == null) {
                CommandAPI.fail("Sender must be a player");
            } else if (args[0] instanceof List) {
                targets = (Collection<Player>) args[0];
            } else {
                CommandAPI.fail("Invalid List of Players");
            }
            ItemStack itemStack = ItemRegistry.getItem((String) args[1]);
            if (itemStack == null) {
                sendInvalidItem(sender, (String) args[1]);
            } else {
                for (Player target : targets) {
                    target.getInventory().addItem(itemStack);
                }
            }
        }, arguments));

        // Sort Command
        arguments = new LinkedHashMap<>();
        arguments.put("sort", new LiteralArgument("sort"));
        returnVal.put("sort", new ExecutorStorage((sender, args) -> {
            if (!(sender.hasPermission("moddedadditions.sort"))) {
                sendPermissionDenied(sender);
                return;
            }
            if (!(sender instanceof Player)) {
                sendMustBePlayer(sender);
                return;
            }
            PlayerData data = instance.getPlayerDataController().getPlayerData((Player) sender);
            data.toggleSortChests();
            sendSortInventory((Player) sender, data.sortChests());
            instance.getPlayerDataController().setPlayerData((Player) sender, data);
        }, arguments));

        // Reload Command
        arguments = new LinkedHashMap<>();
        arguments.put("reload", new LiteralArgument("reload"));
        returnVal.put("reload", new ExecutorStorage((sender, args) -> {
            if (!(sender.hasPermission("moddedadditions.reload"))) {
                sendPermissionDenied(sender);
                return;
            }
            instance.reloadConfiguration();
            sender.sendMessage(instance.getLanguageManager().generateMessage("configurationReloaded"));
        }, arguments));


        return returnVal;
    }

    public static void registerCommands() {
        HashMap<String, ExecutorStorage> commands = getCommands();
        for (String key : commands.keySet()) {
            new CommandAPICommand("areatool")
                    .withAliases("at", "atool", "areat")
                    .withArguments(commands.get(key).getArguments())
                    .executes(commands.get(key).getExecutor())
                    .register();
        }
    }

    private static void sendPermissionDenied(CommandSender sender) {
        sender.sendMessage(instance.getLanguageManager().generateMessage("permissionDenied"));
    }

    private static void sendInvalidItem(CommandSender sender, String item) {
        Map<String, String> messageArgs = new HashMap<>();
        messageArgs.put("item", item);
        sender.sendMessage(instance.getLanguageManager().generateMessage("ma-unknownItem", messageArgs));
    }

    private static void sendMustBePlayer(CommandSender sender) {
        sender.sendMessage(instance.getLanguageManager().generateMessage("mustBePlayer"));
    }

    private static void sendSortInventory(Player player, boolean sortChests) {
        if (sortChests) {
            player.sendMessage(instance.getLanguageManager().generateMessage("ma-sortOn"));
        } else {
            player.sendMessage(instance.getLanguageManager().generateMessage("ma-sortOff"));
        }
    }

}

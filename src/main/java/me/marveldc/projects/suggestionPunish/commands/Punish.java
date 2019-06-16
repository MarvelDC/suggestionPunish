package me.marveldc.projects.suggestionPunish.commands;

import me.marveldc.projects.suggestionPunish.Main;
import me.marveldc.projects.suggestionPunish.PunishGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.marveldc.projects.suggestionPunish.Util.tl;

public class Punish implements CommandExecutor {

    public Punish(Main plugin) {
        plugin.getCommand("punish").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length <= 0) {
            sender.sendMessage(tl("&7&lSuggestion-Punish >> &rNo player was specified."));
            return true;
        }
        new PunishGUI(args[0], (Player) sender); // open punish gui for sender only
        return true;
    }
}

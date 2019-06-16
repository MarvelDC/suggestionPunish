package me.marveldc.projects.suggestionPunish.commands;

import me.marveldc.projects.suggestionPunish.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.*;

import static me.marveldc.projects.suggestionPunish.Util.tl;

public class SendDupe implements CommandExecutor {
    private HashMap<String, String[]> entries = new HashMap<>();

    public SendDupe(Main plugin) {
        plugin.getCommand("senddupe").setExecutor(this);
        // Player name, [punishment type, state/duration, reason, by, (7 = offline, a = online, c = banned)]
        entries.put("Bob", new String[]{"null", "null", "null", "null", "7"});
        entries.put("Steve", new String[]{"ban", "perm", "Alt Limit", "moderator1", "c"});
        entries.put("Player", new String[]{"ban", "perm", "Alt Limit", "moderator1", "c"});
        entries.put("Earth", new String[]{"ban", "expired", "Alt Limit", "moderator1", "a"});
        entries.put("Ice", new String[]{"ip-ban", "perm", "Bot", "aPlayer", "c"});
        entries.put("Fire", new String[]{"ban", "perm", "Alt Limit", "moderator1", "c"});
        entries.put("Water", new String[]{"ban", "perm", "Alt Limit", "moderator1", "c"});
        entries.put("Hacker", new String[]{"mute", "expired", "Targeted Disrespect", "moderator", "7"});
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ComponentBuilder list = new ComponentBuilder("");
        int count = 1;

        for (Map.Entry<String, String[]> entry : entries.entrySet()) {
            if (entry.getValue()[0].equals("null"))
                list
                    .append(tl("&"+entry.getValue()[4]+entry.getKey()+"&r"+(count == entries.size() ? "" : ", ")))
                    .event((HoverEvent) null)
                    .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punish "+entry.getKey()));
            else
                list
                    .append(tl("&"+entry.getValue()[4]+entry.getKey()+"&r"+(count == entries.size() ? "" : ", ")))
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(tl(
                        "Type: &c"+entry.getValue()[0]+
                        "\n&rDuration: &7"+entry.getValue()[1]+
                        "\n&rReason: &7"+entry.getValue()[2]+
                        "\n&rBy: &7"+entry.getValue()[3])).create()))
                    .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punish "+entry.getKey()));
            count++;
        }
        sender.sendMessage(tl("Scanning &a"+entries.keySet().toArray()[0]+":"));
        sender.spigot().sendMessage(list.create());
        return true;
    }
}

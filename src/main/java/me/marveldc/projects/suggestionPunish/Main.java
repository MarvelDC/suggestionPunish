package me.marveldc.projects.suggestionPunish;

import me.marveldc.projects.suggestionPunish.commands.Punish;
import me.marveldc.projects.suggestionPunish.commands.SendDupe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        new Punish(this);
        new SendDupe(this);
    }
}

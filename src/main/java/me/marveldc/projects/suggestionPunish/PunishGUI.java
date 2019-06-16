package me.marveldc.projects.suggestionPunish;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.marveldc.projects.suggestionPunish.Util.tl;
import static org.bukkit.Bukkit.createInventory;

public class PunishGUI {
    private String target;
    private Player sender;

    public PunishGUI(String _target, Player _sender) {
        this.target = _target;
        this.sender = _sender;
        openPunish();
    }

    private void openPunish() {
        /*
        - - - - - - - - - 8
        - - H - O - N - - 11, 13, 15
        - - - - - - - - - 26
        */
        Inventory inv = createInventory(null, 27, tl("Punishing: &c"+this.target));

        // add History icon to slot 11
        ItemStack history = new ItemStack(Material.BOOK, 1);
        ItemMeta historyMeta = history.getItemMeta();
        historyMeta.setDisplayName(tl("&fHistory"));
        history.setItemMeta(historyMeta);
        inv.setItem(11, history);

        // add New Offense icon to slot 13
        ItemStack offense = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta offenseMeta = offense.getItemMeta();
        offenseMeta.setDisplayName(tl("&fNew offense"));
        offense.setItemMeta(offenseMeta);
        inv.setItem(13, offense);

        // add Notes icon to slot 15
        ItemStack notes = new ItemStack(Material.PAPER, 1);
        ItemMeta notesMeta = notes.getItemMeta();
        notesMeta.setDisplayName(tl("&fNotes"));
        notes.setItemMeta(notesMeta);
        inv.setItem(15, notes);

        this.sender.closeInventory();
        this.sender.openInventory(inv);
    }
}

package com.github.happyrogelio7.renameplugin1;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;

public class RenamePlugin1CMD implements CommandExecutor {

    private RenamePlugin1 plugin;

    public RenamePlugin1CMD(RenamePlugin1 plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&cThis command can only be used by a player"));
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage(MessageColors.getMsgColor("&cUsage: /renameplugin1 <name>"));
            return true;
        }

        ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
        itemMeta.setDisplayName(MessageColors.getMsgColor(args[0]));
        player.getInventory().getItemInMainHand().setItemMeta(itemMeta);

        return true;
    }
}
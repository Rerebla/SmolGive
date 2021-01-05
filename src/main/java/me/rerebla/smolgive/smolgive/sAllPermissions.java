package me.rerebla.smolgive.smolgive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class sAllPermissions implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        ArrayList<String> permissions = SmolGive.permissionKeeper.getAllPermissions(commandSender.getName());
        if (permissions.isEmpty()) {
            commandSender.sendMessage("You have no permissions!");
        } else {
            for (String permission : permissions) {
                commandSender.sendMessage(permission);
            }
        }
        return true;
    }
}

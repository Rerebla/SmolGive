package me.rerebla.smolgive.smolgive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class sAllPermissionsOfPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> permissions= SmolGive.permissionKeeper.getAllPermissions(strings[0]);
        if(permissions.isEmpty()) {
            commandSender.sendMessage("They have no permissions!");
        }else{
            for (String permission:permissions) {
                commandSender.sendMessage(permission);
            }
        }
        return true;
    }
}

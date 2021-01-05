package me.rerebla.smolgive.smolgive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sRemoveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender.isOp())){
            commandSender.sendMessage("You have to be opped to use that command!");
            return false;
        }
        if(!SmolGive.permissionKeeper.lookForPlayer(strings[0])){return false;}
        SmolGive.permissionKeeper.removePermission(strings[0],strings[1]);
        return true;
    }
}

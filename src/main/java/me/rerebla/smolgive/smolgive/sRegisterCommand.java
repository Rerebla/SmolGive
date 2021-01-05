package me.rerebla.smolgive.smolgive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sRegisterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender.isOp())){
            commandSender.sendMessage("You have to be opped to use that command!");
            return false;
        }
        try{
            if(SmolGive.permissionKeeper.lookForPlayer(strings[0])){
            SmolGive.permissionKeeper.addPermission(strings[0], strings[1]);
            }
            else{
                SmolGive.permissionKeeper.addKeyValuePair(strings[0], strings[1]);
            }
        }
        catch (ArrayIndexOutOfBoundsException outOfBoundsException){
            return false;
        }
        return true;
    }
}

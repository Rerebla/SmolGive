package me.rerebla.smolgive.smolgive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sRemoveAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){return false;}
        try{
        if(SmolGive.permissionKeeper.lookForPlayer(strings[0])){
            SmolGive.permissionKeeper.removeAllPermissions(strings[0]);}
            return true;
        }
        catch(ArrayIndexOutOfBoundsException outOfBoundsException){
            outOfBoundsException.printStackTrace();
            return false;
        }
    }
}

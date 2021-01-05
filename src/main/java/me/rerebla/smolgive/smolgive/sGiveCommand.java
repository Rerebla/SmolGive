package me.rerebla.smolgive.smolgive;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class sGiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) throws ArrayIndexOutOfBoundsException {
        if (!(commandSender instanceof Player)) { return false; }
        String playerName = commandSender.getName();
        String requiredPermission = strings[0];
        if(SmolGive.permissionKeeper.getPermission(playerName, requiredPermission)){
            try{
            String commandOut = String.format("give %s %s %s", playerName, strings[0], strings[1]);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandOut);
            }catch(Exception ex){ex.printStackTrace();}
                return true;
        }else{
            return false;
        }
    }
}

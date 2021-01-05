package me.rerebla.smolgive.smolgive;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SmolGive extends JavaPlugin {
    public static SmolGive instance;
    public static PermissionKeeper permissionKeeper;
    @Override
    public void onEnable() {
        if(instance == null){
            instance = this;
        }else {
            try {
                throw new Exception("More than one SmolGive");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        permissionKeeper = new PermissionKeeper();
        permissionKeeper.deserialize();
        registerCommands();
    }
    private void registerCommands(){
        try{
            Objects.requireNonNull(this.getCommand("sgive")).setExecutor(new sGiveCommand());
            Objects.requireNonNull(this.getCommand("sremove")).setExecutor(new sRemoveCommand());
            Objects.requireNonNull(this.getCommand("sregister")).setExecutor(new sRegisterCommand());
            Objects.requireNonNull(this.getCommand("sremoveall")).setExecutor(new sRemoveAllCommand());
            Objects.requireNonNull(this.getCommand("sAllPermissions")).setExecutor(new sAllPermissions());
            Objects.requireNonNull(this.getCommand("sAllPermissionsOfPlayer")).setExecutor(new sAllPermissionsOfPlayer());
        }
        catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        permissionKeeper.serialize();
    }
}

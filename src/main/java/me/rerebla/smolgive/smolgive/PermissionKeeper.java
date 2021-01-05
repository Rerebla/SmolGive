package me.rerebla.smolgive.smolgive;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class PermissionKeeper implements Serializable {


    private HashMap<String, ArrayList<String>> permissions = new HashMap<>();
    String filename = "permission.ser";
    public void addPermission(String playerName, String permission){
        permissions.get(playerName).add(permission);
    }
    public boolean getPermission(String playerName, String permission){
        return permissions.get(playerName).contains(permission);
    }
    public void removePermission(String playerName, String permission){
        permissions.get(playerName).remove(permission);
    }
    public void removeAllPermissions(String playerName) {
        permissions.get(playerName).clear();
    }
    public boolean lookForPlayer(String playerName){
        return permissions.containsKey(playerName);
    }
    public void addKeyValuePair(String playerName, String permission){
         ArrayList<String> newArrayList = new ArrayList<>();
        newArrayList.add(permission);
        permissions.put(playerName, newArrayList);
    }
    public void addEmptyKeyValuePair(String playerName){
        permissions.put(playerName, new ArrayList<>());
    }
    public ArrayList<String> getAllPermissions(String playerName){
        if(lookForPlayer(playerName)){
            return permissions.get(playerName);
        }
        else{
            addEmptyKeyValuePair(playerName);
            return getAllPermissions(playerName);
        }
    }



    public void serialize(){
        try {
            FileOutputStream file =  new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(permissions);
            out.close();
            file.close();
        } catch (IOException IOException) {
            IOException.printStackTrace();
        }
    }
    public void deserialize(){
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            permissions = (HashMap<String, ArrayList<String>>)in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

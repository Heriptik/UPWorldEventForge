package xyz.ultrapixelmon.Config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static String NameWorldEvent;

    public static void load(){
        Configuration config = new Configuration(new File("config/UPWorldEventForge/config.json"));
        config.load();

        NameWorldEvent = config.getString("nomDuMonde", Configuration.CATEGORY_GENERAL,"DIM999","Le nom du monde utilisé (Type DIMX)");
        config.save();
    }
}

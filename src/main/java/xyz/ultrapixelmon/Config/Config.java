package xyz.ultrapixelmon.Config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static String NameWorldEvent;
    public static Integer NumeroDIMPokeSpawn;

    public static void load(){
        Configuration config = new Configuration(new File("config/UPWorldEventForge/config.json"));
        config.load();

        NameWorldEvent = config.getString("nomDuMonde", Configuration.CATEGORY_GENERAL,"DIM999","Le nom du monde utilisé pour le monde Event (Type DIMX)");
        NumeroDIMPokeSpawn = config.getInt("numeroDimensonDuPokeSpawn",Configuration.CATEGORY_GENERAL, 999, 0, 999, "Numéro de Dimension utilisé pour le monde PokeSpawn");
        config.save();
    }
}

package xyz.ultrapixelmon.Config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static String NameWorldEvent;
    public static Integer NumeroDIMPokeSpawn;
    public static Integer MaxPosKillY;

    public static void load(){
        Configuration config = new Configuration(new File("config/UPWorldEventForge/config.json"));
        config.load();

        NameWorldEvent = config.getString("nomDuMonde", Configuration.CATEGORY_GENERAL,"DIM999","Le nom du monde utilis� pour le monde Event (Type DIMX)");
        NumeroDIMPokeSpawn = config.getInt("numeroDimensonDuPokeSpawn",Configuration.CATEGORY_GENERAL, 999, 0, 999, "Num�ro de Dimension utilis� pour le monde PokeSpawn");
        MaxPosKillY = config.getInt("positionMaximumYAvantKill",Configuration.CATEGORY_GENERAL, 49, 0, 999, "Coordonn�e Y maximum avant que le joueur soit kill (49 par d�faut)");
        config.save();
    }
}

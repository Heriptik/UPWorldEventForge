package xyz.ultrapixelmon.Config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static String NameWorldEvent;
    public static Integer NumeroDIMPokeSpawn;
    public static Integer MaxPosKillY;
    public static Integer ChaiseMusicalMilieuX;
    public static Integer ChaiseMusicalMilieuZ;
    public static Integer ChaiseMusicalRange;



    public static void load(){
        Configuration config = new Configuration(new File("config/UPWorldEventForge/config.json"));
        config.load();

        NameWorldEvent = config.getString("nomDuMonde", Configuration.CATEGORY_GENERAL,"DIM999","Le nom du monde utilis� pour le monde Event (Type DIMX)");
        NumeroDIMPokeSpawn = config.getInt("numeroDimensonDuPokeSpawn",Configuration.CATEGORY_GENERAL, 999, 0, 999, "Num�ro de Dimension utilis� pour le monde PokeSpawn");
        MaxPosKillY = config.getInt("positionMaximumYAvantKill",Configuration.CATEGORY_GENERAL, 49, 0, 999, "Coordonn�e Y maximum avant que le joueur soit kill (49 par d�faut)");
        ChaiseMusicalMilieuX = config.getInt("positionXMilieuDeLaChaiseMusicale",Configuration.CATEGORY_GENERAL, 9999, -9999, 9999, "Coordonn�e X du milieu de la chaise musical");
        ChaiseMusicalMilieuZ = config.getInt("positionZMilieuDeLaChaiseMusicale",Configuration.CATEGORY_GENERAL, 9999, -9999, 9999, "Coordonn�e Z du milieu de la chaise musical");
        ChaiseMusicalRange = config.getInt("rangeDeLeChaiseMusical",Configuration.CATEGORY_GENERAL, 30, 0, 999, "Range du jeu de la chaise musical");

        config.save();
    }
}

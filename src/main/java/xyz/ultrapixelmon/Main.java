package xyz.ultrapixelmon;

import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import xyz.ultrapixelmon.Commands.ReloadCommand;
import xyz.ultrapixelmon.Config.Config;
import xyz.ultrapixelmon.Listeners.DisableConnectionInWorldEvent;
import xyz.ultrapixelmon.Listeners.DisableItemsUse;
import xyz.ultrapixelmon.Listeners.DisableSendPokemonInWorldEvent;
import xyz.ultrapixelmon.Listeners.DisableUseButton;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class Main
{
    public static final String MODID = "upworldeventforge";
    public static final String NAME = "UPWorldEventForge";
    public static final String VERSION = "0.3";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        Config.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new DisableSendPokemonInWorldEvent());
        MinecraftForge.EVENT_BUS.register(new DisableItemsUse());
        MinecraftForge.EVENT_BUS.register(new DisableConnectionInWorldEvent());
        MinecraftForge.EVENT_BUS.register(new DisableUseButton());
        Pixelmon.EVENT_BUS.register(new DisableSendPokemonInWorldEvent());

        logger.info("[UPWorldEVentForge] Initialisation effectue avec succes. Version: " + Main.VERSION);
    }

    @EventHandler
    public void onServerStrating(FMLServerStartingEvent event){
        event.registerServerCommand(new ReloadCommand());
    }
}

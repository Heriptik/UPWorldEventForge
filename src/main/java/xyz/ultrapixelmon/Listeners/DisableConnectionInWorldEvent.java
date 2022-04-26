package xyz.ultrapixelmon.Listeners;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import xyz.ultrapixelmon.Config.Config;

public class DisableConnectionInWorldEvent {

    @SubscribeEvent
    public void onPlayerJoinServer(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = (EntityPlayer) event.player;

        if(player.getEntityWorld().getWorldInfo().getWorldName().equals(Config.NameWorldEvent)){
            player.world.getMinecraftServer().getCommandManager().executeCommand(player.world.getMinecraftServer(), "spawn " + player.getName());
        }
    }
}

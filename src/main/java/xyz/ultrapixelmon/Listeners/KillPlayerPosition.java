package xyz.ultrapixelmon.Listeners;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.ultrapixelmon.Config.Config;

public class KillPlayerPosition {

    @SubscribeEvent
    public void onPlayerMove(PlayerEvent event){
        EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();
        double playerPosY = player.getPositionVector().y;

            if(player.getEntityWorld().getWorldInfo().getWorldName().equals(Config.NameWorldEvent)){
                if(playerPosY <= Config.MaxPosKillY){
                    player.setHealth(0);
                }
            }
    }

}

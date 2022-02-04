package xyz.ultrapixelmon.Listeners;

import com.pixelmonmod.pixelmon.api.events.PixelmonSendOutEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.ultrapixelmon.Config.Config;
import xyz.ultrapixelmon.Utils.ChatUtils;

public class DisableSendPokemonInWorldEvent {

    @SubscribeEvent
    public void onPlayerSendPokemon(PixelmonSendOutEvent event){
        EntityPlayerMP player = (EntityPlayerMP) event.player;

        if(player.getEntityWorld().getWorldInfo().getWorldName().equals(Config.NameWorldEvent)){
            event.setCanceled(true);
            player.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&7Vous ne pouvez pas sortir vos Pokémon dans ce monde.")));
        }
    }
}

package xyz.ultrapixelmon.Listeners;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.ultrapixelmon.Config.Config;
import xyz.ultrapixelmon.Utils.ChatUtils;

public class DisableUseButton {

    @SubscribeEvent
    public void onPlayerUseButton(PlayerInteractEvent.RightClickBlock event){
        EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();

        if(player.getEntityWorld().getWorldInfo().getWorldName().equals(Config.NameWorldEvent)){
            if(player.canUseCommand(4, "upworldeventforge.worldeventperm")) return;
            if(block instanceof BlockButton){
                event.setCanceled(true);
                player.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&cVous ne pouvez pas utiliser de boutton dans ce monde.")));
            }
        }
    }

}

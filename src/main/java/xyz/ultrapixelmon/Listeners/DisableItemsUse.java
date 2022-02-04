package xyz.ultrapixelmon.Listeners;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.ultrapixelmon.Config.Config;
import xyz.ultrapixelmon.Utils.ChatUtils;

public class DisableItemsUse {

    @SubscribeEvent
    public void onUseItems(PlayerInteractEvent event){
        EntityPlayer player = (EntityPlayer) event.getEntity();

        if(event.getItemStack().isEmpty()) return;

        if(player.getEntityWorld().getWorldInfo().getWorldName().equals(Config.NameWorldEvent)){
            if(event.getItemStack().getItem() instanceof ItemEnderPearl){
                player.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&7Vous ne pouvez pas utiliser cet item dans ce monde.")));
                event.setCanceled(true);
            }
        }
    }
}

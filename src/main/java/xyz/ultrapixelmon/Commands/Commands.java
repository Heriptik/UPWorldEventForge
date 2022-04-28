package xyz.ultrapixelmon.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import xyz.ultrapixelmon.Config.Config;
import xyz.ultrapixelmon.Utils.ChatUtils;
import xyz.ultrapixelmon.Utils.PermissionsUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Commands extends CommandBase {

    @Override
    public String getName() {
        return "upworldeventforge";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "&cUsage: /upworldeventforge";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if(args.length == 1){
            if(args[0].matches("reload")){
                if(PermissionsUtils.hasPermission("upworldeventforge.reload", (EntityPlayerMP) sender)){
                    Config.load();
                    sender.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&aConfiguration reload success.")));
                    return;
                }
                sender.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&cVous n'avez pas la permission d'utiliser cette commande.")));
                return;
            }
        }

        if(args.length == 1){
            if(args[0].matches("chaise_check")){

                List<String> playersInList = new ArrayList<>();

                for (EntityPlayerMP players : server.getServer().getPlayerList().getPlayers()){
                    double playerRange = Math.sqrt((Config.ChaiseMusicalMilieuX - (int) players.posX) * (Config.ChaiseMusicalMilieuX - (int) players.posX) + (Config.ChaiseMusicalMilieuZ - (int) players.posZ) * (Config.ChaiseMusicalMilieuZ - (int) players.posZ));

                    if(players.getEntityWorld().getWorldInfo().getWorldName().equals(Config.NameWorldEvent)){
                        if(PermissionsUtils.hasPermission("worldguard.region.bypass.DIM8", players)) continue;
                        if ((Config.ChaiseMusicalRange) > playerRange) {
                            if(players.isRiding()){
                                players.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&aBien joué !")));
                                playersInList.add(players.getName());
                            } else {
                                players.setHealth(0);
                            }
                        }
                    }
                }
                sender.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&aIl rèste en jeu : &f" + playersInList.size() + " &ajoueur(s) fou.")));
            }
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> possibleArgs = new ArrayList<>();
        possibleArgs.add("chaise_check");
        possibleArgs.add("reload");
        return getListOfStringsMatchingLastWord(args, possibleArgs);
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return PermissionsUtils.canUse("upworldeventforge.chaise_check", sender);
    }

}

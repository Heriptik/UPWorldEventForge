package xyz.ultrapixelmon.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import xyz.ultrapixelmon.Config.Config;
import xyz.ultrapixelmon.Utils.ChatUtils;
import xyz.ultrapixelmon.Utils.PermissionsUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ReloadCommand extends CommandBase {

    @Override
    public String getName() {
        return "upworldeventforgereload";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "&cUsage: /upworldeventforgereload";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Config.load();
        sender.sendMessage(new TextComponentString(ChatUtils.replaceTextFormating("&aConfiguration reload success.")));
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> possibleArgs = new ArrayList<>();
        return getListOfStringsMatchingLastWord(args, possibleArgs);
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return PermissionsUtils.canUse("upworldeventforge.reload", sender);
    }
}

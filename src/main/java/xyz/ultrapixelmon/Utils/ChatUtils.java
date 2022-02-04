package xyz.ultrapixelmon.Utils;

import net.minecraft.util.text.TextFormatting;

public class ChatUtils {

    public static String replaceTextFormating(final String text) {
        return text.replaceAll("&0", "" + TextFormatting.BLACK)
                .replaceAll("&1", "" + TextFormatting.DARK_BLUE)
                .replaceAll("&2", "" + TextFormatting.DARK_GREEN)
                .replaceAll("&3", "" + TextFormatting.DARK_AQUA)
                .replaceAll("&4", "" + TextFormatting.DARK_RED)
                .replaceAll("&5", "" + TextFormatting.DARK_PURPLE)
                .replaceAll("&6", "" + TextFormatting.GOLD)
                .replaceAll("&7", "" + TextFormatting.GRAY)
                .replaceAll("&8", "" + TextFormatting.DARK_GRAY)
                .replaceAll("&9", "" + TextFormatting.BLUE)
                .replaceAll("&a", "" + TextFormatting.GREEN)
                .replaceAll("&b", "" + TextFormatting.AQUA)
                .replaceAll("&c", "" + TextFormatting.RED)
                .replaceAll("&d", "" + TextFormatting.LIGHT_PURPLE)
                .replaceAll("&e", "" + TextFormatting.YELLOW)
                .replaceAll("&f", "" + TextFormatting.WHITE)
                .replaceAll("&k", "" + TextFormatting.OBFUSCATED)
                .replaceAll("&l", "" + TextFormatting.BOLD)
                .replaceAll("&m", "" + TextFormatting.STRIKETHROUGH)
                .replaceAll("&n", "" + TextFormatting.UNDERLINE)
                .replaceAll("&o", "" + TextFormatting.ITALIC)
                .replaceAll("&r", "" + TextFormatting.RESET);
    }

}

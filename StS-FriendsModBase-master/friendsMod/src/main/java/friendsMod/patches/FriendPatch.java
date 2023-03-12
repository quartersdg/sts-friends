package friendsMod.patches;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.screens.leaderboards.LeaderboardEntry;
import friendsMod.FriendsMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@SpirePatch2(clz = LeaderboardEntry.class, method = SpirePatch.CONSTRUCTOR)
public class FriendPatch {
    private static final Logger logger = LogManager.getLogger(FriendPatch.class.getName());

    private static final Map<String, Color> COLOURS;

    static {
        COLOURS = new HashMap<>();
        COLOURS.put("purple", Color.PURPLE.cpy());
        COLOURS.put("black", Color.BLACK.cpy());
        COLOURS.put("white", Color.WHITE.cpy());
        COLOURS.put("light_gray", Color.LIGHT_GRAY.cpy());
        COLOURS.put("gray", Color.GRAY.cpy());
        COLOURS.put("dark_gray", Color.DARK_GRAY.cpy());
        COLOURS.put("blue", Color.BLUE.cpy());
        COLOURS.put("navy", Color.NAVY.cpy());
        COLOURS.put("royal", Color.ROYAL.cpy());
        COLOURS.put("slate", Color.SLATE.cpy());
        COLOURS.put("sky", Color.SKY.cpy());
        COLOURS.put("cyan", Color.CYAN.cpy());
        COLOURS.put("teal", Color.TEAL.cpy());
        COLOURS.put("green", Color.GREEN.cpy());
        COLOURS.put("chartreuse", Color.CHARTREUSE.cpy());
        COLOURS.put("lime", Color.LIME.cpy());
        COLOURS.put("forest", Color.FOREST.cpy());
        COLOURS.put("olive", Color.OLIVE.cpy());
        COLOURS.put("yellow", Color.YELLOW.cpy());
        COLOURS.put("gold", Color.GOLD.cpy());
        COLOURS.put("goldenrod", Color.GOLDENROD.cpy());
        COLOURS.put("orange", Color.ORANGE.cpy());
        COLOURS.put("brown", Color.BROWN.cpy());
        COLOURS.put("tan", Color.TAN.cpy());
        COLOURS.put("firebrick", Color.FIREBRICK.cpy());
        COLOURS.put("red", Color.RED.cpy());
        COLOURS.put("scarlet", Color.SCARLET.cpy());
        COLOURS.put("coral", Color.CORAL.cpy());
        COLOURS.put("salmon", Color.SALMON.cpy());
        COLOURS.put("pink", Color.PINK.cpy());
        COLOURS.put("magenta", Color.MAGENTA.cpy());
        COLOURS.put("purple", Color.PURPLE.cpy());
        COLOURS.put("violet", Color.VIOLET.cpy());
        COLOURS.put("maroon", Color.MAROON.cpy());
    }

    @SpirePostfixPatch
    public static void LeaderboardEntry(LeaderboardEntry __instance, @ByRef Color[] ___color) {
        if (FriendsMod.friends.contains(__instance.name)) {
            logger.atInfo().log("Updating " + __instance.name);
            ___color[0] = COLOURS.getOrDefault(FriendsMod.highlightColor, Color.PURPLE).cpy();
        }
    }
}

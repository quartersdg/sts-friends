package friendsMod;

import basemod.BaseMod;
import basemod.interfaces.PreStartGameSubscriber;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import friendsMod.util.IDCheckDontTouchPls;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpireInitializer
public class FriendsMod implements PreStartGameSubscriber {
    public static final Logger logger = LogManager.getLogger(FriendsMod.class.getName());
    private static String modID;

    //This is for the in-game mod settings panel.
    private static final String MODNAME = "Friends Mod";
    private static final String AUTHOR = "Gremious, sdgoglin";
    private static final String DESCRIPTION = "A mod.";

    public static final List<String> friends = new ArrayList<>();
    public static String highlightColor = "purple";

    public FriendsMod() {
        logger.info("Subscribe to BaseMod hooks");

        BaseMod.subscribe(this);

        String configFriends = "";
        String configHighlightColor = "";
        try {
            SpireConfig config = new SpireConfig("Friends", "config");
            configFriends = getOrDefault(config, "friends", "Vorpal,stephen");
            configHighlightColor = getOrDefault(config, "highlight_color", "sky");
        } catch (IOException e) {
            e.printStackTrace();
        }

        friends.addAll(Arrays.stream(configFriends.split(",")).distinct().collect(Collectors.toList()));
        highlightColor = configHighlightColor;
        logger.info("Friends == " + friends);
        logger.info("Highlight Color == " + highlightColor);

        setModID("friendsMod");
    }

    private String getOrDefault(SpireConfig config, String key, String d) throws IOException {
        String v = config.getString(key);
        if (null == v || v.isEmpty()) {
            v = d;
            config.setString(key, v);
            config.save();
        }
        return v;
    }

    // ====== NO EDIT AREA ======
    // DON'T TOUCH THIS STUFF. IT IS HERE FOR STANDARDIZATION BETWEEN MODS AND TO ENSURE GOOD CODE PRACTICES.
    // IF YOU MODIFY THIS I WILL HUNT YOU DOWN AND DOWNVOTE YOUR MOD ON WORKSHOP

    public static void setModID(String ID) { // DON'T EDIT
        Gson coolG = new Gson(); // EY DON'T EDIT THIS
        //   String IDjson = Gdx.files.internal("IDCheckStringsDONT-EDIT-AT-ALL.json").readString(String.valueOf
        //   (StandardCharsets.UTF_8)); // i hate u Gdx.files
        InputStream in = FriendsMod.class.getResourceAsStream("/IDCheckStringsDONT-EDIT-AT-ALL.json"); // DON'T EDIT
        // THIS ETHER
        IDCheckDontTouchPls EXCEPTION_STRINGS = coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8),
                IDCheckDontTouchPls.class); // OR THIS, DON'T EDIT IT
        logger.info("You are attempting to set your mod ID as: " + ID); // NO WHY
        if (ID.equals(EXCEPTION_STRINGS.DEFAULTID)) { // DO *NOT* CHANGE THIS ESPECIALLY, TO EDIT YOUR MOD ID, SCROLL
            // UP JUST A LITTLE, IT'S JUST ABOVE
            throw new RuntimeException(EXCEPTION_STRINGS.EXCEPTION); // THIS ALSO DON'T EDIT
        } else if (ID.equals(EXCEPTION_STRINGS.DEVID)) { // NO
            modID = EXCEPTION_STRINGS.DEFAULTID; // DON'T
        } else { // NO EDIT AREA
            modID = ID; // DON'T WRITE OR CHANGE THINGS HERE NOT EVEN A LITTLE
        } // NO
        logger.info("Success! ID is " + modID); // WHY WOULD U WANT IT NOT TO LOG?? DON'T EDIT THIS.
    } // NO

    public static String getModID() { // NO
        return modID; // DOUBLE NO
    } // NU-UH

    private static void pathCheck() { // ALSO NO
        Gson coolG = new Gson(); // NNOPE DON'T EDIT THIS
        //   String IDjson = Gdx.files.internal("IDCheckStringsDONT-EDIT-AT-ALL.json").readString(String.valueOf
        //   (StandardCharsets.UTF_8)); // i still hate u btw Gdx.files
        InputStream in = FriendsMod.class.getResourceAsStream("/IDCheckStringsDONT-EDIT-AT-ALL.json"); // DON'T EDIT
        // THISSSSS
        IDCheckDontTouchPls EXCEPTION_STRINGS = coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8),
                IDCheckDontTouchPls.class); // NAH, NO EDIT
        String packageName = FriendsMod.class.getPackage().getName(); // STILL NO EDIT ZONE
        FileHandle resourcePathExists = Gdx.files.internal(getModID() + "Resources"); // PLEASE DON'T EDIT THINGS
        // HERE, THANKS
        if (!modID.equals(EXCEPTION_STRINGS.DEVID)) { // LEAVE THIS EDIT-LESS
            if (!packageName.equals(getModID())) { // NOT HERE ETHER
                throw new RuntimeException(EXCEPTION_STRINGS.PACKAGE_EXCEPTION + getModID()); // THIS IS A NO-NO
            } // WHY WOULD U EDIT THIS
            if (!resourcePathExists.exists()) { // DON'T CHANGE THIS
                throw new RuntimeException(EXCEPTION_STRINGS.RESOURCE_FOLDER_EXCEPTION + getModID() + "Resources");
                // NOT THIS
            }// NO
        }// NO
    }// NO

    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("========================= Initializing Friends Mod. Hi. =========================");
        FriendsMod defaultmod = new FriendsMod();
        logger.info("========================= /Friends Mod Initialized/ =========================");
    }

    @Override
    public void receivePreStartGame() {
        // nop
    }
}

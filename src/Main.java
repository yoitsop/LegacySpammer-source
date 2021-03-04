import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import javax.imageio.ImageIO;


@ScriptManifest(name = "Legacy Spammer AIO", author = "OP", version = 1.0, info = "", logo = "")

public class Main extends Script {
    private LegacySpammerGui spammerGui = new LegacySpammerGui();


    public void onStart() {
        if (spammerGui == null){
            spammerGui = new LegacySpammerGui();
        }
    }

    public void onExit() {
    }

    public int onLoop() throws InterruptedException {


        if (myPlayer().isVisible()) {

            ArrayList<String> messages = spammerGui.getStringlist();

            if (messages.size() > 0) {
                for (int i = 0; i < messages.size(); i++) {
                    this.keyboard.typeString(messages.get(i), true);
                }
                if (spammerGui.hopWorlds) {
                    if (spammerGui.isP2P) {
                        getWorlds().hopToP2PWorld();
                    } else {
                        getWorlds().hopToF2PWorld();
                    }
                    return random(5000,10000);
                }
            }
        }
        return random(1000, 3000);
    }

/*
    public void onPaint(final Graphics2D g) {

        Image background = null;
        try {
            URL url = new URL("https://i.imgur.com/iCmfb3A.png");
            background = ImageIO.read(url);
            g.drawImage(background,0,335,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}


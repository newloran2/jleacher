package br.com.newloran2.jleacher;

import br.com.newloran2.jleacher.listeners.DccListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.FileTransferFinishedEvent;
import org.pircbotx.hooks.events.IncomingFileTransferEvent;

/**
 * Hello world!
 *
 */
public class JLeacher {

    
    public static void main(String[] args) {
        PircBotX bot = new PircBotX();
        bot.getListenerManager().addListener(new DccListener(null));
        try {
            bot.setName("newloran2");
            bot.setName("newloran2");
            bot.connect("irc.rizon.net");
            bot.joinChannel("#animensk");
            bot.setVerbose(true);
            Thread.sleep(1000 * 10);
            bot.sendMessage("ANSK|Sora", "xdcc send #720");


        } catch (InterruptedException ex) {
            Logger.getLogger(JLeacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JLeacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IrcException ex) {
            Logger.getLogger(JLeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

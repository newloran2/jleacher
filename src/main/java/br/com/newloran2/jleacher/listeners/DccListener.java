/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.newloran2.jleacher.listeners;

import br.com.newloran2.jleacher.config.Config;
import java.io.File;
import org.pircbotx.Channel;
import org.pircbotx.DccFileTransfer;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.FileTransferFinishedEvent;

import org.pircbotx.hooks.events.IncomingFileTransferEvent;

/**
 *
 * @author newloran2
 */
public class DccListener extends ListenerAdapter {

   private Config config;

    public DccListener(Config config) {
        this.config = config;
    }
   
    
    @Override
    public void onIncomingFileTransfer(IncomingFileTransferEvent event) throws Exception {
        System.out.println("Evento de recebimento de arquivo iniciado");
        DccFileTransfer transfer = event.getTransfer();
        File file = new File("/Users/newloran2/Downloads/irc/" + transfer.getFilename());
        System.out.println("Criando arquivo em " + file.getPath());
        transfer.receive(file, true);
        transfer.getProgressPercentage();
        while (transfer.isIncoming()) {
            System.out.println("Total Transferido: " + transfer.getProgress() + "/"
                    + transfer.getSize() + ":"
                    + transfer.getProgressPercentage() + ":"
                    + transfer.getTransferRate());
            
        }
    }

    @Override
    public void onFileTransferFinished(FileTransferFinishedEvent event) throws Exception {
        //TODO mover arquivo para o diretório final
        
        
        
        
        
    }
    
    
    
    
    
    
}

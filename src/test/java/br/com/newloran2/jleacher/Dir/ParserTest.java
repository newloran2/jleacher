/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.newloran2.jleacher.Dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author newloran2
 */
public class ParserTest {

    private static File baseDir;

    public ParserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        String tmpDir = FileUtils.getTempDirectoryPath() + File.separator + "temp";
        String serverDir = "irc.rizon.net";
        String serverChannel = "#animensk";
        String[] channelBoots = new String[]{"ANSK|Laura", "ANSK|Kuroneko", "ANSK|Victorique", "ANSK|Kobato", "ANSK|Sora"};
        ArrayList<String[]> bootPacks = new ArrayList();
        bootPacks.add(new String[]{"795.nd", "796.nd", "847.nd"});
        bootPacks.add(new String[]{"913.nd", "915.nd", "939.nd"});
        bootPacks.add(new String[]{"708.nd", "825.nd", "884.nd"});
        bootPacks.add(new String[]{"276.nd", "761.nd", "830.nd"});
        bootPacks.add(new String[]{"720.nd"});

        File dirContents = new File(tmpDir + File.separator + serverDir);
        if (dirContents.exists()) {
            FileUtils.forceDelete(dirContents);
        }

        baseDir = dirContents.getParentFile();

        for (int boot = 0; boot < channelBoots.length - 1; boot++) {
            File channelDir = new File(
                    tmpDir
                    + File.separator
                    + serverDir
                    + File.separator
                    + serverChannel
                    + File.separator
                    + channelBoots[boot]);
            FileUtils.forceMkdir(channelDir);

            for (int packs = 0; packs < bootPacks.get(boot).length - 1; packs++) {
                for (int pack = 0; pack < bootPacks.get(boot).length; pack++) {
                    FileUtils.touch(new File(channelDir.getPath() + File.separator + bootPacks.get(boot)[pack]));
                }
            }

        }

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
//        FileUtils.forceDelete(baseDir);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getServerList method, of class Parser.
     */
    @Test
    public void testGetServerList() {
        System.out.println("getServerList");
        Parser instance = new Parser(baseDir);
        Collection<File> result = instance.getServerList();

        for (File server : result) {
            System.out.println("Server encontrado : " + server.getName());
        }

        assertTrue(result != null && result.size() > 0);
    }

    /**
     * Test of getChannelList method, of class Parser.
     */
    @Test
    public void testGetChannelList() {
        System.out.println("getChannelList");
        Parser instance = new Parser(baseDir);
        Collection<File> result = instance.getChannelList();
        for (File channel : result) {
            System.out.println("Channels encontrados : " + channel.getName());
        }
        assertTrue(result != null && result.size() > 0);
    }

    /**
     * Test of getBootList method, of class Parser.
     */
    @Test
    public void testGetBootList() {
        System.out.println("getBootList");
        Parser instance = new Parser(baseDir);
        Collection<File> result = instance.getBootList();
        for (File boot : result) {
            System.out.println("Boots encontrados : " + boot.getName());
        }
        assertTrue(result != null && result.size() > 0);
    }

    /**
     * Test of getNotProcessedPackList method, of class Parser.
     */
    @Test
    public void testGetNotProcessedPackList() {
        System.out.println("getNotProcessedPackList");
        Parser instance = new Parser(baseDir);
        Collection<File> result = instance.getNotProcessedPackList();
        for (File pack : result) {
            System.out.println("Pack encontrado : " + pack.getName());
        }
        assertTrue(result != null && result.size() > 0);
    }

    
}

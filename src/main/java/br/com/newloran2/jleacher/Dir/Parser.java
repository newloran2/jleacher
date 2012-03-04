/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.newloran2.jleacher.Dir;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

/**
 *
 * @author newloran2
 */
public class Parser {

    public static final String NOT_PROCESSED = "np";
    private File baseDir;

    public Parser(File baseDir) {
        this.baseDir = baseDir;
    }

    public Collection<File> getServerList() {
        File[] listFiles = baseDir.listFiles((FileFilter) FileFilterUtils.directoryFileFilter());
        Collection<File> files = new ArrayList<File>();
        return Arrays.asList(listFiles);

    }

    public Collection<File> getChannelList() {
        Collection<File> serverList = getServerList();
        Collection<File> channelList = new ArrayList<File>();
        for (File server : serverList) {
            channelList.addAll(Arrays.asList(server.listFiles((FileFilter) FileFilterUtils.directoryFileFilter())));
        }
        return channelList;
    }

    public Collection<File> getBootList() {
        Collection<File> channelList = getChannelList();
        Collection<File> bootList = new ArrayList<File>();

        for (File channel : channelList) {
            bootList.addAll(Arrays.asList(channel.listFiles((FileFilter) FileFilterUtils.directoryFileFilter())));
        }
        return bootList;
    }

    public Collection<File> getNotProcessedPackList() {
        Collection<File> bootList = getBootList();
        Collection<File> packList = new ArrayList<File>();

        for (File channel : bootList) {
            File[] files = channel.listFiles();
            for (File pack : files) {
                packList.add(pack);
            }
        }
        return packList;
    }

    public File getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(File baseDir) {
        this.baseDir = baseDir;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.newloran2.jleacher.Dir.vo;

import java.util.List;

/**
 *
 * @author newloran2
 */
public class Channel {

    private String name;
    private List<Bot> bots;

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

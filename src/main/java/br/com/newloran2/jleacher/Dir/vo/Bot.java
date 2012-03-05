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
public class Bot {

    private String name;
    private List<pack> packs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<pack> getPacks() {
        return packs;
    }

    public void setPacks(List<pack> packs) {
        this.packs = packs;
    }
}

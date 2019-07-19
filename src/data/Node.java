/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Vector;

/**
 *
 * @author Do Ngoc Huu
 */
public class Node {

    private Volcabulary root;

    public Node() {
        this.root = null;
    }

    public Volcabulary getRoot() {
        return root;
    }

    public void setRoot(Volcabulary root) {
        this.root = root;
    }

    public void addNewVolcabulary(Volcabulary newVolcabulary) {
        Volcabulary p = root;
        Volcabulary parent = null;
        while (p != null) {
            parent = p;
            if(p.getName().compareToIgnoreCase(newVolcabulary.getName()) > 0) {
                p = p.getLeft();
            } else if (p.getName().compareToIgnoreCase(newVolcabulary.getName()) < 0){
                p = p.getRight();
            } else {
                break;
            }
        }
        
        if (root == null) {
            root = newVolcabulary;
        } else {
            if (parent.getName().compareToIgnoreCase(newVolcabulary.getName()) > 0) {
                parent.setLeft(newVolcabulary);
            } else if(parent.getName().compareToIgnoreCase(newVolcabulary.getName()) < 0){
                parent.setRight(newVolcabulary);
            } else {
                for (String string : newVolcabulary.getMeaning()) {
                    if(!parent.checkMeaningExist(string)) {
                        parent.getMeaning().add(string);
                    }
                }
            }
        }
        
    }
}

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
    private int size;
    private Vector data;

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }
    
    public Node() {
        this.root = null;
        this.size = 0;
        this.data = new Vector();
    }

    public Volcabulary getRoot() {
        return root;
    }

    public void setRoot(Volcabulary root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addNewVolcabulary(Volcabulary newVolcabulary) {
        Volcabulary p = root;
        Volcabulary parent = null;
        while (p != null) {
            parent = p;
            if(p.getName().compareToIgnoreCase(newVolcabulary.getName()) > 0) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        
        if (root == null) {
            root = newVolcabulary;
            size++;
        } else {
            if (parent.getName().compareToIgnoreCase(newVolcabulary.getName()) > 0) {
                parent.setLeft(newVolcabulary);
                size++;
            } else if(parent.getName().compareToIgnoreCase(newVolcabulary.getName()) < 0){
                parent.setRight(newVolcabulary);
                size++;
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

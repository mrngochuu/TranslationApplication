    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Do Ngoc Huu
 */
public class Volcabulary {

    private String name;
    private LinkedList<String> meaning;
    private Volcabulary left, right;

    public Volcabulary(String name) {
        this.name = name;
        this.meaning = new LinkedList<String>();
        this.right = null;
        this.left = null;
    }

    public Volcabulary(String name, Volcabulary left, Volcabulary right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public void addMeaning(String str) {
        if(!checkMeaningExist(str)) {
            meaning.add(str);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getMeaning() {
        return meaning;
    }

    public void setMeaning(LinkedList<String> meaning) {
        this.meaning = meaning;
    }

    public Volcabulary getLeft() {
        return left;
    }

    public void setLeft(Volcabulary left) {
        this.left = left;
    }

    public Volcabulary getRight() {
        return right;
    }

    public void setRight(Volcabulary right) {
        this.right = right;
    }

    public boolean checkMeaningExist(String str) {
        for (String string : meaning) {
            if (string.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String getMeaningToString() {
        //sort meaning
        Collections.sort(meaning, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // getmeaning
        String s = "";
        for (int i = 0; i < meaning.size(); i++) {
            s += meaning.get(i).trim();
            if (i != (meaning.size() - 1)) {
                s += ", ";
            }
        }
        return s;
    }
    
}

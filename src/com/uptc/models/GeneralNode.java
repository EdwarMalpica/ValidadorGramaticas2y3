package com.uptc.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GeneralNode {

    private static int secuential;
    private int id;
    private Simbol simbol;
    private ArrayList<GeneralNode> childrenSimbol;

    public GeneralNode(Simbol simbol){
        this.id = secuential++;
        this.simbol = simbol;
        this.childrenSimbol = new ArrayList();
    }

    public int getId(){
        return id;
    }

    public Simbol getSimbol() {
        return simbol;
    }

    public void setSimbol(Simbol simbol) {
        this.simbol = simbol;
    }

    public ArrayList<GeneralNode> getChildrenSimbol() {
        return childrenSimbol;
    }

    public void setChildrenSimbol(ArrayList<GeneralNode> childrenSimbol) {
        this.childrenSimbol = childrenSimbol;
    }

    public void addChild(GeneralNode child){
        this.childrenSimbol.add(child);
    }

    @Override
    public String toString() {
        return " simbol=" + simbol.getSimbol();
    }

    public Set<GeneralNode> getAllLeafNodes() {
        Set<GeneralNode> leafNodes = new HashSet<GeneralNode>();
        if (this.childrenSimbol.isEmpty()) {
            leafNodes.add(this);
        } else {
            for (GeneralNode child : this.childrenSimbol) {
                leafNodes.addAll(child.getAllLeafNodes());
            }
        }
        return leafNodes;
    }
}

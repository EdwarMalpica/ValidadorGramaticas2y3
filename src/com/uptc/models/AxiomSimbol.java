package com.uptc.models;

public class AxiomSimbol implements Simbol{

    private String simbol; 

    public AxiomSimbol(String simbol){
        this.simbol = simbol;
    }
    @Override
    public String getPathImage() {
        return "src/img/axiomNode.png";
    }

    @Override
    public String getSimbol() {
        return simbol;
    }


    @Override
    public String toString() {
        return simbol;
    }
}

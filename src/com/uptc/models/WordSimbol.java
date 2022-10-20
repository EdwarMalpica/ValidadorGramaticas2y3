package com.uptc.models;

public class WordSimbol implements Simbol{

    private String simbol; 

    public WordSimbol(String simbol){
        this.simbol = simbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/childNode.png";
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
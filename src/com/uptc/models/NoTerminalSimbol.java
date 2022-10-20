package com.uptc.models;

public class NoTerminalSimbol implements Simbol{

    private String simbol; 

    public NoTerminalSimbol(String simbol){
        this.simbol = simbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/noTerminalNode.png";
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

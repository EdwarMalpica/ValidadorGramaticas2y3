package com.uptc.models;

public class TerminalSimbol implements Simbol{

    private String simbol; 

    public TerminalSimbol(String simbol){
        this.simbol = simbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/terminalNode.png";
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

package com.uptc.models;

public class Production {

    private String noTerminalSimbol;
    private String production;
    
    public Production(String noTerminalSimbol, String production) {
        this.noTerminalSimbol = noTerminalSimbol;
        this.production = production;
    }

    public String getNoTerminalSimbol() {
        return noTerminalSimbol;
    }

    public void setNoTerminalSimbol(String noTerminalSimbol) {
        this.noTerminalSimbol = noTerminalSimbol;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Production [noTerminalSimbol=" + noTerminalSimbol + ", production=" + production + "]";
    }
}

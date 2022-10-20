package com.uptc.models;

import java.util.ArrayList;

public class Grammar {

    private String grammarName;
    private ArrayList<String> noTerminalSimbols;
    private ArrayList<String> terminalSimbols;
    private ArrayList<Production> productions;
    private String axiomSimbol;

    public Grammar(ArrayList<String> noTerminalSimbols, ArrayList<String> terminalSimbols, String axiomSimbol){
        this.noTerminalSimbols = noTerminalSimbols;
        this.terminalSimbols = terminalSimbols;
        this.axiomSimbol = axiomSimbol;
    }

    public String getGrammarName() {
        return grammarName;
    }

    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }

    public ArrayList<String> getNoTerminalSimbols() {
        return noTerminalSimbols;
    }

    public void setNoTerminalSimbols(ArrayList<String> noTerminalSimbols) {
        this.noTerminalSimbols = noTerminalSimbols;
    }

    public ArrayList<String> getTerminalSimbols() {
        return terminalSimbols;
    }

    public void setTerminalSimbols(ArrayList<String> terminalSimbols) {
        this.terminalSimbols = terminalSimbols;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public String getAxiomSimbol() {
        return axiomSimbol;
    }

    public void setAxiomSimbol(String axiomSimbol) {
        this.axiomSimbol = axiomSimbol;
    }
}

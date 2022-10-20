package com.uptc.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class WordChecker {

    private final Grammar grammar;

    public WordChecker(Grammar grammar) {
        this.grammar = grammar;
    }

    /**
     * Obtiene las producciones cuyo simbolo no terminal es igual
     * al simbolo no terminal especificado
     * @param nonTerminalSymbol
     * @return
     */
    private ArrayList<Production> getProductions(String nonTerminalSymbol){
        System.out.println("axioma inicial : " + nonTerminalSymbol);
        ArrayList<Production> list = new ArrayList();
        ArrayList<Production> productionsList = grammar.getProductions();
        
        for (Production pro1 : productionsList) {
            if(pro1.getNoTerminalSimbol().equals(nonTerminalSymbol))
                list.add(pro1);
        }
        return list;         
    }

    private Production getNonTerminalProductions(String symbol, ArrayList<Production> productions) {
        for (Production p: productions) {
            String production = p.getProduction();
            if (!production.equals(production.toLowerCase())){
                if (p.getProduction().equals(symbol)){
                    return p;
                }
            }
        }
        return null;
    }

    private Production getTerminalProduction(String symbol, ArrayList<Production> productions){
        for (Production p: productions) {
            String production = p.getProduction();
            if (production.equals(production.toLowerCase())){
                if (p.getProduction().equals(symbol)){
                    return p;
                }
            }
        }
        return null;
    }
}

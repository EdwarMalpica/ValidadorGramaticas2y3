package com.uptc.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class GrammarManager {
    
    private Grammar grammar;
    private GeneralNode generalRoot;
    private WordChecker checker;

    private ArrayList<String> terminalChains;

    public GrammarManager(){

    }
    
    public Grammar getGrammar(){
        return this.grammar;
    }
    
    // metodo que crea la gramática
    public void createGrammar(String grammarName, String[] noTerminalSimbols, String[] terminalSimbols, 
    String axiomSimbol, ArrayList<Production> productions){
        this.terminalChains = new ArrayList<String>();
        this.grammar = new Grammar(changeToList(noTerminalSimbols), changeToList(terminalSimbols), axiomSimbol);
        grammar.setGrammarName(grammarName);
        grammar.setProductions(productions);
        generateGeneralTree();
        checker = new WordChecker(grammar);

    }
    
    public void createGrammar(Grammar grammar){
        this.grammar = grammar;
        generateGeneralTree();
        checker = new WordChecker(grammar);  
    }

// metodo que convierte la lista de palabras entrantes en arraylist
    public ArrayList<String> changeToList(String[] list){
        return new ArrayList(Arrays.asList(list));
    }

//  metodos para generar el arbol general de la gramática
    public void generateGeneralTree(){
        generalRoot = new GeneralNode(new AxiomSimbol(grammar.getAxiomSimbol()));
        addBranch(generalRoot,0);
    }

    public void addBranch(GeneralNode father, int level){
        if(level < 6){
            String simbols = father.getSimbol().getSimbol();//axioma
            for (int i = 0; i < simbols.length(); i++) {
                char simbol = simbols.charAt(i);
                if(isNoTerminal(simbol)){//si es una variable
                    addWordsToFather(father, simbols, i, simbol);
                    break;
                }
            }
            level++;
            for (GeneralNode childSimbol : father.getChildrenSimbol()) {
                addBranch(childSimbol,level);
            }
        }
    }

    public void validateWordRestart(GeneralNode father, int level, int levelMax){
        if(level < levelMax + 1){
            String simbols = father.getSimbol().getSimbol();//axioma
            for (int i = 0; i < simbols.length(); i++) {
                char simbol = simbols.charAt(i);
                if(isNoTerminal(simbol)){//si es una variable
                    addWordsToFather(father, simbols, i, simbol);
                    break;
                }
            }
            level++;
            for (GeneralNode childSimbol : father.getChildrenSimbol()) {
                validateWordRestart(childSimbol,level, levelMax);
            }
        }
    }

    public boolean checkWord(String word){
        generalRoot = new GeneralNode(new AxiomSimbol(grammar.getAxiomSimbol()));
        validateWordRestart(generalRoot,0, word.length());
        return  searchWordInLeafs(word);
    }

    private boolean searchWordInLeafs(String word) {
        Set<GeneralNode> terminalLeafs = generalRoot.getAllLeafNodes();
        for (GeneralNode leaf: terminalLeafs) {
            if(leaf.getSimbol().getSimbol().equals(word)){
                  return true;
            };
        }
        return false;
    }


    private void addWordsToFather(GeneralNode father, String simbols, int i, char simbol) {
        ArrayList<String> simbolsProductions = searchProduction(String.valueOf(simbol));
        for (String string : simbolsProductions) {
            father.addChild(new GeneralNode(new WordSimbol(formatWord(simbols,string,i))));
        }
    }

    private String formatWord(String simbols, String production, int simbolPosition){
        String word = "";
        for (int i = 0; i < simbols.length(); i++) {
            char simbol = simbols.charAt(i);
            if(i == simbolPosition){
                word += production;
            }else{
                word += simbol;
            }
        }
        return word;
    }

    // Métodos que valida si un simbolo es o no terminal
    private boolean isNoTerminal(char character){
        return grammar.getNoTerminalSimbols().contains(String.valueOf(character));
    }

    private boolean isTerminal(char character){
        return grammar.getNoTerminalSimbols().contains(String.valueOf(character));
    }
    
    //método que busca una producción dentro de la lista de producciones de la gramatica 
    public ArrayList<String> searchProduction(String noTerminalSimbol){
        ArrayList<String> simbolsProductions =  new ArrayList();
        ArrayList<Production> productions =  grammar.getProductions();
        for (Production production : productions) {
            if(noTerminalSimbol.equals(production.getNoTerminalSimbol())){
                simbolsProductions.add(production.getProduction());
            }
        }
        return simbolsProductions;
    }

    public ArrayList<Production> searchProductionsGrammar(String noTerminalSimbol) {
        ArrayList<Production> productionsList = new ArrayList();
        ArrayList<Production> productions = grammar.getProductions();
        for (Production production : productions) {
            if (noTerminalSimbol.equals(production.getNoTerminalSimbol())) {
                productionsList.add(production);
            }
        }
        return productionsList;
    }

    public void print(){
        System.out.println("Simbolos no terminales-------");
        ArrayList<String> simbolListOne = grammar.getNoTerminalSimbols();
        for (String string : simbolListOne) {
            System.out.println(string);
        }
        System.out.println("Simbolos terminales--------");
        ArrayList<String> simbolListTwo = grammar.getTerminalSimbols();
        for (String string : simbolListTwo) {
            System.out.println(string);
        }
        System.out.println("Axioma---------");
        System.out.println(grammar.getAxiomSimbol());
        ArrayList<Production> productions = grammar.getProductions();
        for (Production production : productions) {
            System.out.println(production);
        }
    }

    public void printTree(){
        printNode(generalRoot,1,-1);
    }

    public void printNode(GeneralNode node, int level, int fatherId){
        System.out.println(node + " - FatherId=" + fatherId + " - level=" +level);
        level++;
        for (GeneralNode child: node.getChildrenSimbol()) {
            printNode(child, level, node.getId());
        }
    }

    public GeneralNode getGeneralRoot(){
        return generalRoot;
    }


    public String getGrammarName(){
        return grammar.getGrammarName();
    }
}

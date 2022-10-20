package com.uptc.controllers;

import com.uptc.models.GrammarManager;
import com.uptc.views.PrincipalFrame;
import com.uptc.views.ProductionsDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private GrammarManager manager;
    private PrincipalFrame frame;
    private ProductionsDialog productionsDialog;


    public Controller() {
        manager = new GrammarManager();
        frame = new PrincipalFrame(this);
        productionsDialog = new ProductionsDialog(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case SAVE_GRAMMAR:
                //Por Hacer
                break;
            case LOAD_GRAMMAR:
                //Por hacer
                break;
            case ADD_PRODUCTIONS:
                productionsDialog.openDialog(frame);
                break;
            case ADD_GRAMMAR:
                createAndAddGrammar();
                break;
            case ACEPT_PRODUCTION:
                productionsDialog.setVisible(false);
                break;
            case DELETE_GRAMMAR:
                deleteParameters();
                break;
            case EDIT_GRAMMAR:
                editParameters();
                break;
            case ADD_PRODUCION:
                productionsDialog.addProductionField();
                break;
            case DELETE_PRODUCION:
                productionsDialog.deleteProductionField();
                break;
            case VALIDATE_WORD:
                validateWordOnGrammar();
                break;
        }
    }




    private void createAndAddGrammar() {
        manager.createGrammar(frame.getGrammarName(), frame.getNoTerminalSimbols(), frame.getSigma(),
                frame.getAxiom(), productionsDialog.getProductions());
        frame.showGeneralTree(manager.getGeneralRoot(), manager.getGrammarName());
    }

    private void editParameters() {
        frame.enableFields();
        productionsDialog.enableProductions();
    }

    private void deleteParameters() {
        frame.deleteContentFields();
        productionsDialog.deleteProductions();
    }

    private void validateWordOnGrammar() {
        String word = frame.getWord();
        boolean isLeaf = manager.checkWord(word);
        frame.showGeneralTree(manager.getGeneralRoot(), manager.getGrammarName());
        frame.isLeaf(isLeaf);
    }

    public static void main(String[] args) {
        new Controller();
    }
}

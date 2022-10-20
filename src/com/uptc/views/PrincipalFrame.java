package com.uptc.views;

import com.uptc.models.GeneralNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrincipalFrame extends JFrame{
    
    public static final Dimension WINDOW_SIZE = new Dimension(700,560);
    public static final String TITLE = "Identificador de Gramáticas";
    public static final String LOGO_PATH = "src/img/logo1.png";

    private PrincipalPanel principalPanel;

    public PrincipalFrame(ActionListener listener){
        initComponents(listener);
        setVisible(true);
        
    }

    private void initComponents(ActionListener listener){
        setTitle(TITLE);
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(LOGO_PATH).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        
        principalPanel = new PrincipalPanel(listener);
        add(principalPanel);
    }

    public String getGrammarName(){
        return principalPanel.getGrammarName();
    }   

    public String[] getSigma(){
        return principalPanel.getSigma();
    }

    public String[] getNoTerminalSimbols(){
        return principalPanel.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return principalPanel.getAxiom();
    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        principalPanel.showGeneralTree(root, grammarName);
    }

    public void enableFields(){
        principalPanel.enableFields();
    }

    public void deleteContentFields(){
        principalPanel.deleteContentFields();
    }

    public String getWord(){
        return principalPanel.getWord();
    }

    public void isLeaf(boolean isLeaf){
        principalPanel.isLeaf(isLeaf);
    }
    
    public ParametersPanel getParametersPanel(){
        return principalPanel.getParametersPanel();
    }
}
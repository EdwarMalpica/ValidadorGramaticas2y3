package com.uptc.views;

import javax.swing.*;
import java.awt.*;

public class PanelProductions extends JPanel{

    public static final Color COLOR_TEXT_FIELD = Color.WHITE;
    public static final Color DISABLE_COLOR = Color.GREEN;
   
    private JTextField noTerminalSimbol;
    private JTextField production;

    public PanelProductions(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        initComponents();
    }
    
    private void initComponents(){
        addFields();
    }

    private void addFields(){
        noTerminalSimbol = new JTextField(5);
        noTerminalSimbol.setFont(PanelTextFields.FIELDS_FONT);
        noTerminalSimbol.setBackground(COLOR_TEXT_FIELD);
        add(noTerminalSimbol);
        JLabel arrow = new JLabel("→");
        arrow.setFont(ParametersPanel.PARAMETERS_FONT);
        add(arrow);
        production = new JTextField(5);
        production.setFont(PanelTextFields.FIELDS_FONT);
        production.setBackground(COLOR_TEXT_FIELD);
        add(production);
    }
    
    public void setNoTerminalText(String text){
        noTerminalSimbol.setText(text);
    }
    
    public void setProductionText(String text){
        production.setText(text);
    }

    public String getNoTerminalSimbol() {
        noTerminalSimbol.setEnabled(false);
        noTerminalSimbol.setDisabledTextColor(DISABLE_COLOR);
        noTerminalSimbol.setBackground(Color.WHITE);
        return noTerminalSimbol.getText();
    }

    public String getProduction() {
        production.setEnabled(false);
        production.setDisabledTextColor(DISABLE_COLOR);
        production.setBackground(Color.WHITE);
        return production.getText();
    }

    public void enableTextFields(){
        noTerminalSimbol.setBackground(COLOR_TEXT_FIELD);
        noTerminalSimbol.setEnabled(true);
        production.setBackground(COLOR_TEXT_FIELD);
        production.setEnabled(true);
    }

    public void deleteContentTextFields(){
        noTerminalSimbol.setText("");
        noTerminalSimbol.setBackground(COLOR_TEXT_FIELD);
        noTerminalSimbol.setEnabled(true);
        production.setText("");
        production.setBackground(COLOR_TEXT_FIELD);
        production.setEnabled(true);
    }
}

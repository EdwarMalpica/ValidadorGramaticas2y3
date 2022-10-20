package com.uptc.views;

import com.uptc.controllers.Commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelWordValidate extends JPanel{

    private static final String BUTTON_TEXT = "Validar";
    public static final String EQUAL_SYMBOL = " = ";
    private static final String GRAMMAR_SIMBOL = "W";
    public static final Font TEXT_FIELD_FONT = new Font("Cambria Math", Font.PLAIN, 14);
    public static final Font LABEL_FONT = new Font("Cambria Math", Font.BOLD, 20);
    public static final String DESCRIPTION = "ANÁLISIS  Ingrese w para validar";
    public static final Font DESCRIPTION_FONT = new Font("Roboto", Font.BOLD, 14);

    private JTextField wordTextField;
    private JPanel panelBox;
    private ParticularTreePanel particularTreePanel;

    public PanelWordValidate(ActionListener listener){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.decode("#6CFC42"), 2));
        setBackground(Color.WHITE);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setOpaque(false);
        addLabel();
        addTextFieldAndButton(listener);
        add(panelBox, BorderLayout.PAGE_START);
        particularTreePanel = new ParticularTreePanel();
        add(particularTreePanel,BorderLayout.CENTER);
    }

    private void addLabel(){
        JPanel panelDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescription.setOpaque(false);
        JLabel description = new JLabel(DESCRIPTION);
        description.setFont(DESCRIPTION_FONT);
        panelDescription.add(description);
        panelBox.add(panelDescription);
    }

    private void addTextFieldAndButton(ActionListener listener){
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHeader.setOpaque(false);
        JLabel word = new JLabel(GRAMMAR_SIMBOL + EQUAL_SYMBOL);
        word.setFont(LABEL_FONT);
        panelHeader.add(word);
        wordTextField = new JTextField(10);
        wordTextField.setFont(TEXT_FIELD_FONT);
        panelHeader.add(wordTextField);
        Buttons validateButton = new Buttons(BUTTON_TEXT);
        validateButton.addActionListener(listener);
        validateButton.setActionCommand(Commands.VALIDATE_WORD.toString());
        panelHeader.add(validateButton);
        panelBox.add(panelHeader);
    }

    public String getWord(){
        return wordTextField.getText();
    }

    public void isLeaf(boolean isLeaf) {
        particularTreePanel.isLeaf(isLeaf);
    }
}


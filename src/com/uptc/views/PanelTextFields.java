package com.uptc.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTextFields extends JPanel{

    public static final Font TITLE_FONT = new Font("Cambria Math", Font.BOLD, 20);
    public static final Font FIELDS_FONT = new Font("Cambria Math", Font.PLAIN, 20);
    public static final int SIZE_TEXT_FIELD = 10;
    public static final Color COLOR_TEXT_FIELD = Color.decode("#E5F5EE");
    public static final Color DISABLE_COLOR = Color.decode("#808487");
    
    private JTextField textField;
    
    public PanelTextFields(String text, String message){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setOpaque(false);
        addLabel(text);
        addTextField(message);
    }

    public PanelTextFields(String text, String buttonText ,String message, ActionListener listener, String command){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setOpaque(false);
        addLabel(text);
        addButton(buttonText,message, listener, command);
    }

    private void addLabel(String text){
        JLabel title = new JLabel(text);
        title.setFont(TITLE_FONT);
        add(title);
    }

    private void addTextField(String message){
        textField = new JTextField(SIZE_TEXT_FIELD);
        textField.setFont(FIELDS_FONT);
        textField.setBackground(COLOR_TEXT_FIELD);
        textField.setToolTipText(message);
        add(textField);
    }
    
    public void setTextField(String text){
        textField.setText(text);
    }
    
    public JTextField getTextField(){
        return textField;
    }

    private void addButton(String text, String message, ActionListener listener, String command){
        Buttons button = new Buttons(text);
        button.setToolTipText(message);
        button.addActionListener(listener);
        button.setActionCommand(command);
        add(button);
    }

    public String getText(){
        textField.setEnabled(false);
        textField.setDisabledTextColor(DISABLE_COLOR);
        textField.setBackground(Color.WHITE);
        return textField.getText();
    }

    public void enableTextField(){
        textField.setBackground(COLOR_TEXT_FIELD);
        textField.setEnabled(true);
    }

    public void deletContentTextField(){
        textField.setText("");
        textField.setBackground(COLOR_TEXT_FIELD);
        textField.setEnabled(true);
    }
}

package com.uptc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.uptc.controllers.Commands;
import com.uptc.models.Production;

public class ProductionsDialog extends JDialog {

    public static final int QUANTITY_PRODUCTIONS = 3;

    private static final String ACEPT_TEXT = "Aceptar";
    private static final String REMOVE = "-";
    private static final String TEXT_PRODUCTIONS = "Ingrese las producciones";
    private static final String ADD_SIMBOL = "+";
    private static final String TITLE = "Producciones";
    private static final Dimension SIZE = new Dimension(300, 270);
    private static final String LOGO_PATH = "src/img/producciones.png";

    private JPanel panelDialog;
    private JPanel productions;
    private boolean isEnable;

    public ProductionsDialog(ActionListener listener) {
        isEnable = true;
        setTitle(TITLE);
        setSize(SIZE);
        setIconImage(new ImageIcon(LOGO_PATH).getImage());
        setModal(true);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        panelDialog = new JPanel(new BorderLayout());
        panelDialog.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelDialog.setBackground(Color.WHITE);
        addButton(listener);
        addProductionsPanel();
        addButtonAcept(listener);
        getContentPane().add(panelDialog);
    }

    private void addButton(ActionListener listener) {
        JPanel panelHeader = new JPanel(new FlowLayout());
        panelHeader.setOpaque(false);
        JLabel label = new JLabel(TEXT_PRODUCTIONS);
        label.setFont(ParametersPanel.DESCRIPTION_FONT);
        panelHeader.add(label);
        Buttons removeButton = new Buttons(REMOVE);
        removeButton.addActionListener(listener);
        removeButton.setActionCommand(Commands.DELETE_PRODUCION.toString());
        panelHeader.add(removeButton);
        Buttons addButton = new Buttons(ADD_SIMBOL);
        addButton.addActionListener(listener);
        addButton.setActionCommand(Commands.ADD_PRODUCION.toString());
        panelHeader.add(addButton);
        panelDialog.add(panelHeader, BorderLayout.PAGE_START);
    }

    private void addProductionsPanel() {
        productions = new JPanel();
        productions.setLayout(new BoxLayout(productions, BoxLayout.Y_AXIS));
        productions.setBackground(Color.WHITE);
        productions.add(new PanelProductions());
        panelDialog.add(new JScrollPane(productions), BorderLayout.CENTER);
    }

    private void addButtonAcept(ActionListener listener) {
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.setOpaque(false);
        Buttons buttonAcept = new Buttons(ACEPT_TEXT);
        buttonAcept.addActionListener(listener);
        buttonAcept.setActionCommand(Commands.ACEPT_PRODUCTION.toString());
        buttonAcept.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panelButton.add(buttonAcept);
        panelDialog.add(panelButton, BorderLayout.PAGE_END);
    }

    public void openDialog(Component component) {
        setLocationRelativeTo(component);
        setVisible(true);
    }

    public ArrayList<Production> getProductions() {
        ArrayList<Production> productionsList = new ArrayList();
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            PanelProductions production = (PanelProductions) componentsProductions[i];
            productionsList.add(new Production(production.getNoTerminalSimbol(), production.getProduction()));
        }
        productions.revalidate();
        productions.repaint();
        isEnable = false;
        return productionsList;
    }

    public void enableProductions() {
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            ((PanelProductions) componentsProductions[i]).enableTextFields();
        }
        isEnable = true;
        productions.revalidate();
        productions.repaint();
    }

    public void deleteProductions() {
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            ((PanelProductions) componentsProductions[i]).deleteContentTextFields();
        }
        isEnable = true;
        productions.revalidate();
        productions.repaint();
    }

    public void deleteProductionField() {
        Component[] componentsProductions = productions.getComponents();
        if (componentsProductions.length > 1 && isEnable) {
            productions.remove(componentsProductions.length - 1);
            productions.revalidate();
            productions.repaint();
        }
    }

    public void deleteFirstProduction() {
        Component[] componentsProductions = productions.getComponents();
        productions.remove(componentsProductions.length-1);
        productions.revalidate();
        productions.repaint();
    }

    public void addProductionField() {
        if (isEnable) {
            productions.add(new PanelProductions());
            productions.revalidate();
            productions.repaint();
        }
    }

    public PanelProductions addProductionFieldAndGet() {
        PanelProductions p = new PanelProductions();
        if (isEnable) {
            productions.add(p);
            productions.revalidate();
            productions.repaint();
        }
        return p;
    }
}

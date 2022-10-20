package com.uptc.views;

import com.uptc.controllers.Commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**Panel para ingresar valores de la gramatica
 * @author User
 *
 */
public class ParametersPanel extends JPanel{

    public static final String SIGMA = "T";
    public static final String V = "N";
    public static final String GRAMMAR = "G";
    public static final String AXIOM = "S";
    public static final String PRODUCTION = "P";
    public static final String GENERATE_BUTTON_TEXT = "Generar";
    public static final String EQUAL_SYMBOL = " = ";
    public static final String DESCRIPTION = "Ingrese los valores de la gramática";
    public static final Font PARAMETERS_FONT = new Font("Cambria Math", Font.BOLD, 20);
    public static final Font DESCRIPTION_FONT = new Font("Roboto", Font.BOLD, 13);

    private JPanel panelBox;
    private PanelTextFields grammarField;
    private PanelTextFields sigmaField;
    private PanelTextFields noTerminalField;
    private PanelTextFields axiomField;
    private PanelTextFields productionsField;
    
    public JTextField getGrammarField(){
        return grammarField.getTextField();
    }
    
    public JTextField getSigmaField(){
        return sigmaField.getTextField();
    }
    
    public JTextField getNoTerminalField(){
        return noTerminalField.getTextField();
    }
    
    public JTextField getAxiomField(){
        return axiomField.getTextField();
    }
    
    public ParametersPanel(ActionListener listener){
        setLayout(new FlowLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.decode("#6CFC42"), 2));
        initComponents(listener);
        addButtons(listener);
    }

    private void initComponents(ActionListener listener){
        panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setOpaque(false);
        addLable();
        addParameters(listener);
        add(panelBox);
    }

    private void addLable(){
        JPanel panelDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescription.setOpaque(false);
        JLabel description = new JLabel(DESCRIPTION);
        description.setFont(DESCRIPTION_FONT);
        panelDescription.add(description);
        panelBox.add(panelDescription);
    }

    private void addParameters(ActionListener listener){
        grammarField = new PanelTextFields(GRAMMAR + EQUAL_SYMBOL,"Ingrese tipo de gramática, solo tipo 2 ó 3");
        panelBox.add(grammarField);
        sigmaField = new PanelTextFields(SIGMA + EQUAL_SYMBOL,"Terminales Ej.(a,b)");
        panelBox.add(sigmaField);
        noTerminalField = new PanelTextFields(V + EQUAL_SYMBOL,"Variables Ej.(S,A)");
        panelBox.add(noTerminalField);
        axiomField = new PanelTextFields(AXIOM + EQUAL_SYMBOL,"Axioma inicial Ej.(S)");
        panelBox.add(axiomField);
        productionsField = new PanelTextFields(PRODUCTION + EQUAL_SYMBOL,"Abrir","(V, T);(V, TV) Ej.(S,aA);(A,bb)",listener,Commands.ADD_PRODUCTIONS.toString());
        panelBox.add(productionsField);
    }

    private void addButtons(ActionListener listener){
        JPanel panelButtons = new JPanel(new GridLayout(5, 1, 0, 5));
        panelButtons.setOpaque(false);
        
        // Boton generar
        Buttons buttonGenerate = new Buttons(GENERATE_BUTTON_TEXT);
        buttonGenerate.addActionListener(listener);
        buttonGenerate.setActionCommand(Commands.ADD_GRAMMAR.toString());
        panelButtons.add(buttonGenerate);
        
        // boton editar
        Buttons buttonEdit = new Buttons("Editar");
        buttonEdit.addActionListener(listener);
        buttonEdit.setActionCommand(Commands.EDIT_GRAMMAR.toString());
        panelButtons.add(buttonEdit);
        
        //boton borrar
        Buttons buttonDelete = new Buttons("Borrar");
        buttonDelete.addActionListener(listener);
        buttonDelete.setActionCommand(Commands.DELETE_GRAMMAR.toString());
        panelButtons.add(buttonDelete);
   
        
        // boton guardar
        /*Buttons buttonSave = new Buttons("Guardar");
        buttonSave.addActionListener(listener);
        buttonSave.setActionCommand(Commands.SAVE_GRAMMAR.toString());
        panelButtons.add(buttonSave);
       
        
        // boton cargar
        Buttons buttonLoad = new Buttons("Cargar");
        buttonLoad.addActionListener(listener);
        buttonLoad.setActionCommand(Commands.LOAD_GRAMMAR.toString());
        panelButtons.add(buttonLoad);
        */
        
        add(panelButtons);
    }

    public String getGrammarName(){
        return grammarField.getText();
    }

    public String[] getSigma(){
        return sigmaField.getText().split(",");
    }

    public String[] getNoTerminalSimbols(){
        return noTerminalField.getText().split(",");
    }

    public String getAxiom(){
        return axiomField.getText();
    }

    public void enableFields(){
        grammarField.enableTextField();
        sigmaField.enableTextField();
        noTerminalField.enableTextField();
        axiomField.enableTextField();
    }

    public void deleteContentFields(){
        grammarField.deletContentTextField();
        sigmaField.deletContentTextField();
        noTerminalField.deletContentTextField();
        axiomField.deletContentTextField();
    }
}

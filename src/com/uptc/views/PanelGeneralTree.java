package com.uptc.views;
import com.uptc.models.GeneralNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class PanelGeneralTree extends JPanel {
    
    private static final String TITLE_HEADER = "Arbol de Síntesis : ";
    private static final String GRAMMAR_SIMBOL = "G";
    private static final Color COLOR_HEADER = Color.decode("#6CFC42");
    public static final Font DESCRIPTION_FONT = new Font("Roboto", Font.BOLD, 16);

    private DefaultMutableTreeNode graphicRoot;
    private DefaultTreeModel treeModel;
    private JTree graphicTree;
    private JPanel panelCenter;

    private JLabel header;
    
    public PanelGeneralTree(){
        setLayout(new BorderLayout());
        setBackground(COLOR_HEADER);
        setBorder(BorderFactory.createLineBorder(Color.decode("#6CFC42"),2));
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setOpaque(false);
        panelCenter.setForeground(Color.decode("#FFC88F"));
        add(panelCenter,BorderLayout.CENTER);
        addHeader();
        treeModel = new DefaultTreeModel(graphicRoot);
        graphicTree = new JTree(treeModel);
        JScrollPane scroll = new JScrollPane(graphicTree);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panelCenter.add(scroll,BorderLayout.CENTER);
    }

    private void addHeader(){
        header = new JLabel();
        header.setForeground(Color.WHITE);
        header.setHorizontalTextPosition(SwingConstants.RIGHT);
        header.setVerticalTextPosition(SwingConstants.CENTER);
        header.setFont(DESCRIPTION_FONT);
        header.setText(TITLE_HEADER);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        add(header,BorderLayout.PAGE_START);
    }

    public void showTree(GeneralNode root, String grammarName){
        header.setText(TITLE_HEADER + GRAMMAR_SIMBOL + grammarName);
        try {
            graphicRoot = new DefaultMutableTreeNode(root.getSimbol());
        } catch (Exception e) {
        }
        
        printTree(graphicRoot,root);
        treeModel.setRoot(graphicRoot);
        expandTree();
        graphicTree.setCellRenderer(new MyTreeCellRenderer());
        revalidate();
        repaint();
    }

    private void printTree(DefaultMutableTreeNode graphicBase, GeneralNode base) {
        for (GeneralNode node : base.getChildrenSimbol()) {
            DefaultMutableTreeNode actual = new DefaultMutableTreeNode(node.getSimbol());
            graphicBase.add(actual);
            printTree(actual,node);
        }
    }

    public void expandTree() {
        expandAllNodes(graphicTree, 0, graphicTree.getRowCount());
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

}


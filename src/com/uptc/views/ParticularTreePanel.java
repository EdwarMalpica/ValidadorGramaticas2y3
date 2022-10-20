package com.uptc.views;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class ParticularTreePanel extends JPanel {

	private static final String GRAMMAR_SIMBOL = "W";
	private static final Color COLOR_HEADER_LEAF = Color.decode("#6CFC42");
	private static final Color COLOR_HEADER_NOT_LEAF = Color.decode("#6CFC42");
	public static final Font DESCRIPTION_FONT = new Font("Roboto", Font.BOLD, 16);

	private DefaultMutableTreeNode graphicRoot;
	private DefaultTreeModel treeModel;
	private JTree graphicTree;
	private JPanel panelCenter;

	private JLabel header;

	public ParticularTreePanel() {
		setLayout(new BorderLayout());
		setBackground(Color.GRAY);
		panelCenter = new JPanel(new BorderLayout());
		panelCenter.setOpaque(false);
		add(panelCenter, BorderLayout.CENTER);
		addHeader();
		treeModel = new DefaultTreeModel(graphicRoot);
		graphicTree = new JTree(treeModel);
		panelCenter.add(new JScrollPane(graphicTree), BorderLayout.CENTER);
	}

	private void addHeader() {
		header = new JLabel();
		header.setForeground(Color.WHITE);
		header.setHorizontalTextPosition(SwingConstants.RIGHT);
		header.setVerticalTextPosition(SwingConstants.CENTER);
		header.setFont(DESCRIPTION_FONT);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setVerticalAlignment(JLabel.CENTER);
		add(header, BorderLayout.PAGE_START);
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

	public void isLeaf(boolean isLeaf) {
		if (isLeaf) {
			this.header.setText("W hace parte del lenguaje");
			setBackground(COLOR_HEADER_LEAF);
		} else {
			this.header.setText("W no hace parte de la gramatica");
			setBackground(COLOR_HEADER_NOT_LEAF);
		}
	}
}

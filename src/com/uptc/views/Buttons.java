package com.uptc.views;

import javax.swing.*;
import java.awt.*;

/**Clase que dibuja los botones
 * @author User
 *
 */
public class Buttons extends JButton{

    public static final Font BUTTON_FONT = new Font("Roboto", Font.PLAIN, 20);
    public static final Color BACKGRAUND_BUTTON = Color.decode("#6CFC42");

    public Buttons(String text){
        setText(text);
        setFont(BUTTON_FONT);
        setBackground(BACKGRAUND_BUTTON);
        setForeground(Color.WHITE);
        setOpaque(false);
        setFocusable(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Dimension arcs = new Dimension(10,10);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
		graphics.setColor(getBackground());
		graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        super.paint(g);
    }
    
}
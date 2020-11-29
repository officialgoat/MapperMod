package com.github.officialgoat.mappermod.mapper_app;

import javax.swing.*;
import java.awt.*;

public class GTemplate extends JFrame {
    public static final int CANVAS_WIDTH = 640;
    public static final int CANVAS_HEIGHT = 480;

    private DrawCanvas canvas;

    public GTemplate(){
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        Container cp = getContentPane();
        cp.add(canvas);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setTitle("lul...");
        setVisible(true);
    }

    private class DrawCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);
            g.setColor(Color.yellow);
            g.drawString("Hello Screen!", 200, 100);
        }
    }
}

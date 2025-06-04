/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corel_draw.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class ImagePanel extends JPanel {
    public BufferedImage image;
    private int eventId;
    private ActionListener eventListener;
    
    public ImagePanel() {
        super();
        this.eventId = 0;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
        notifyFileSet();
    }
    
    public void setImageFromFile(File file) {
        try {
            this.image = ImageIO.read(file);
            
            repaint();
            notifyFileSet();
        } catch (IOException ex) {
            System.out.println("Error loading image: " + ex.getMessage());
        }
    }
    
    public void addEventListener(ActionListener actionListener) {
        this.eventListener = actionListener;
    }
    
    public void notifyFileSet() {
        this.eventId += 1;
        this.eventListener.actionPerformed(new ActionEvent(this, eventId, "IMAGE_SET"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (image != null) {
            if (image.getWidth() > image.getHeight()) {
                int proportionalHeight = Math.round(getWidth() / (image.getWidth() / image.getHeight()));
                g.drawImage(image, 0, Math.round((getHeight() / 2) - (proportionalHeight / 2)), getWidth(), proportionalHeight, this);
            } else {
                int proportionalWidth = Math.round(getHeight() / (image.getHeight() / image.getWidth()));
                
                g.drawImage(image, Math.round((getWidth() / 2) - (proportionalWidth / 2)), 0, proportionalWidth, getHeight(), this);
            }
        }
    }
}

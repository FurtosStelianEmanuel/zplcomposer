/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import utils.ImageUtils;

/**
 *
 * @author manel
 */
public class PreviewPanel extends DrawerBase {

    private Image preview;
    private final ImageUtils imageUtils;

    public PreviewPanel(ImageUtils imageUtils) {
        this.imageUtils = imageUtils;
    }

    public void setPreview(BufferedImage preview) {
        this.preview = preview;
        documentgenerator.DocumentGenerator.container.resolveDependencies(LayoutComposer.class).repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (preview == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        clearBackground(g2);
        setRenderingHints(g2);

        g2.drawImage(preview, 0, 0, preview.getWidth(null), preview.getHeight(null), null);
    }
}

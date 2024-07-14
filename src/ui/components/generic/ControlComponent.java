/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import layoutlanguage.LayoutComponent;

/**
 *
 * @author manel
 */
public class ControlComponent implements Drawable, Hoverable {

    public final Point position;

    public final Dimension dimension;
    public final BufferedImage icon;

    public ControlComponent(Point position, Dimension dimension, BufferedImage icon) {
        this.position = position;
        this.dimension = dimension;
        this.icon = icon;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(icon, null, position.x, position.y);
    }

    @Override
    public boolean isHovered(int x, int y) {
        return x > position.x && x < position.x + dimension.width
                && y > position.y && y < position.y + dimension.height;
    }
}

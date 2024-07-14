/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.simplelabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import layoutlanguage.Position;
import layoutlanguage.Size;
import layoutlanguage.components.simple.Rectangle;
import ui.components.generic.DrawableComponent;
import ui.components.generic.DrawableComponentWithSize;

/**
 *
 * @author manel
 */
public class DrawableRectangle extends DrawableComponentWithSize<Rectangle> {

    public int roundness;

    public DrawableRectangle() {
        this(new Point(0, 0), new Dimension(100, 100));
    }

    public DrawableRectangle(Point position, Dimension size) {
        super(position, size);
    }

    @Override
    public Rectangle getLayoutComponent() {
        return new Rectangle(
                new Position(position.x, position.y),
                new Size(size.width, size.height),
                3,
                "B",
                roundness
        );
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawRoundRect(position.x, position.y, size.width, size.height, roundness, roundness);
    }

    @Override
    public void finalizeMovement(int x, int y) {
    }

    @Override
    public void drawMovingComponent(Graphics2D g2) {
    }

    @Override
    public void drawPreview(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawRoundRect(previewPosition.x, previewPosition.y, size.width, size.height, roundness, roundness);
    }

    @Override
    public DrawableRectangle getComponentFromPreview() {
        return new DrawableRectangle(new Point(previewPosition), new Dimension(size));
    }
}

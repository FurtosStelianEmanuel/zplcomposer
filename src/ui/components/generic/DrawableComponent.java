/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import layoutlanguage.LayoutComponent;
import ui.DrawingPanel;

/**
 *
 * @author manel
 * @param <K>
 */
public abstract class DrawableComponent<K extends LayoutComponent> implements Drawable, Moveable, Previewable, Repaintable {

    public Point position;
    public Point previewPosition;
    public Point movingObjectPosition;
    protected List<ControlComponent> controlComponents;

    public DrawableComponent(Point position) {
        this.position = new Point(position.x, position.y);
        this.previewPosition = new Point();
        this.movingObjectPosition = new Point();
        controlComponents = new ArrayList();
    }

    public void drawControls(Graphics2D g2) {
        for (var component : controlComponents) {
            component.draw(g2);
        }
    }

    @Override
    public void updatePreviewPosition(int x, int y) {
        previewPosition.x = x;
        previewPosition.y = y;
    }

    @Override
    public void updateMovingObjectPosition(int x, int y) {
        movingObjectPosition.x = x;
        movingObjectPosition.y = y;
    }

    @Override
    public Point getMovingObjectPosition() {
        return movingObjectPosition;
    }

    @Override
    public void repaint() {
        documentgenerator.DocumentGenerator.container.resolveDependencies(DrawingPanel.class).repaint();
    }

    public abstract K getLayoutComponent();
}

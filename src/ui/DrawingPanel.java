/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import annotations.Injectable;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import layoutlanguage.LayoutComponent;
import layoutlanguage.LayoutConstants.ComponentType;
import layoutlanguage.components.simple.SimpleLabel;
import ui.components.simplelabel.DrawableSimpleLabel;
import ui.components.generic.DrawableComponent;
import ui.components.generic.DrawableConstants;
import ui.components.generic.Moveable;
import ui.components.generic.Previewable;
import ui.components.generic.events.EventSubscription;
import ui.components.simplelabel.DrawableRectangle;
import utils.ImageUtils;

/**
 *
 * @author manel
 */
public class DrawingPanel extends DrawerBase {

    private final List<DrawableComponent> components;
    private final List<EventSubscription> mouseClickSubscriptions;

    private Previewable previewedComponent;
    private Moveable movingComponent;

    public DrawingPanel(ImageUtils imageUtils) {
        components = new ArrayList();
        mouseClickSubscriptions = new ArrayList();
    }

    public void selectedComponentChanged(String componentType) {
        previewedComponent = componentType != null ? switch (componentType) {
            case ComponentType.SIMPLE_LABEL -> {
                var label = new DrawableSimpleLabel();
                label.previewPosition = new Point(0, 200);

                yield label;
            }
            case ComponentType.RECTANGLE -> {
                var rectangle = new DrawableRectangle();
                rectangle.previewPosition = new Point(0, 200);

                yield rectangle;
            }

            default ->
                null;
        } : null;

        documentgenerator.DocumentGenerator.container.resolveDependencies(LayoutComposer.class).repaint();
    }

    public void movingComponentChanged(DrawableComponent component) {
        movingComponent = component;

        documentgenerator.DocumentGenerator.container.resolveDependencies(LayoutComposer.class).repaint();
    }

    public void mouseMoved(int x, int y) {
        if (previewedComponent == null && movingComponent == null) {
            return;
        }

        if (previewedComponent != null) {
            previewedComponent.updatePreviewPosition(x, y);
        }

        if (movingComponent != null) {
            movingComponent.updateMovingObjectPosition(x, y);
        }

        documentgenerator.DocumentGenerator.container.resolveDependencies(LayoutComposer.class).repaint();
    }

    public void addSubscriberToMouseClicked(EventSubscription subscription) {
        mouseClickSubscriptions.add(subscription);
    }

    public void removeSubscriptionOfObject(Object source) {
        mouseClickSubscriptions.removeIf(s -> s.component == source);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        setRenderingHints(g2);
        clearBackground(g2);
        for (var component : components) {
            component.draw(g2);
        }

        drawPreview(g2);
        drawMovingComponent(g2);
    }

    void mouseEntered() {
    }

    void mouseExited() {
    }

    void mouseClicked(MouseEvent e) {
        addPreviewedComponent();
        finalizeMovementForMovingComponent();

        manageSubscription(e, mouseClickSubscriptions);
    }

    public List<LayoutComponent> getLayoutComponents() {
        return components.stream().map(c -> c.getLayoutComponent()).collect(Collectors.toList());
    }

    private void drawPreview(Graphics2D g2) {
        if (previewedComponent == null) {
            return;
        }

        previewedComponent.drawPreview(g2);
    }

    private void drawMovingComponent(Graphics2D g2) {
        if (movingComponent == null) {
            return;
        }

        movingComponent.drawMovingComponent(g2);
    }

    private void finalizeMovementForMovingComponent() {
        if (movingComponent == null) {
            return;
        }

        movingComponent.finalizeMovement(movingComponent.getMovingObjectPosition().x, movingComponent.getMovingObjectPosition().y);

        movingComponent = null;
        documentgenerator.DocumentGenerator.container.resolveDependencies(LayoutComposer.class).repaint();
    }

    private void addPreviewedComponent() {
        if (previewedComponent == null) {
            return;
        }

        components.add(previewedComponent.getComponentFromPreview());
        previewedComponent = null;
        documentgenerator.DocumentGenerator.container.resolveDependencies(LayoutComposer.class).repaint();
    }
}

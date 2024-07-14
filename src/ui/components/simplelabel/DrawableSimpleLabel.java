/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.simplelabel;

import annotations.Injectable;
import java.awt.Color;
import static java.awt.Font.BOLD;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import layoutlanguage.LayoutComponent;
import layoutlanguage.Position;
import layoutlanguage.Size;
import layoutlanguage.components.simple.SimpleLabel;
import ui.components.generic.DrawableComponentWithFont;
import ui.components.generic.DrawableConstants;
import zpl.ZPLConstants;
import static documentgenerator.DocumentGenerator.container;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import layoutlanguage.Font;
import layoutlanguage.LayoutConstants;
import ui.DrawingPanel;
import ui.LayoutComposer;
import ui.SimpleLabelEditor;
import ui.components.generic.ControlComponent;
import ui.components.generic.DrawableComponent;
import ui.components.generic.SizedFont;
import ui.components.generic.events.EventCallback;
import ui.components.generic.events.EventSubscription;
import ui.components.generic.events.Trigger;
import ui.components.generic.state.State;
import ui.components.simplelabel.states.DisabledSimpleLabelState;
import ui.components.simplelabel.states.NormalSimpleLabelState;
import utils.ImageUtils;
import utils.StringUtils;

/**
 *
 * @author manel
 */
@Injectable(ResolveWithNewInstance = true)
public class DrawableSimpleLabel extends DrawableComponentWithFont<SimpleLabel> {

    public String value;

    private State state;

    private final ImageUtils imageUtils = container.resolveDependencies(ImageUtils.class);
    private final StringUtils stringUtils = container.resolveDependencies(StringUtils.class);
    private final BufferedImage editIcon = imageUtils.getEditIcon();
    private final BufferedImage moveIcon = imageUtils.getMoveIcon();

    public DrawableSimpleLabel() {
        this(DrawableConstants.DEFAULT_LABEL_TEXT, new SizedFont("Dialog", BOLD, DrawableConstants.DEFAULT_FONT_WIDTH, DrawableConstants.DEFAULT_FONT_HEIGHT), new Point(100, 100));
    }

    public DrawableSimpleLabel(int x, int y) {
        this(DrawableConstants.DEFAULT_LABEL_TEXT, new SizedFont("Dialog", BOLD, DrawableConstants.DEFAULT_FONT_WIDTH, DrawableConstants.DEFAULT_FONT_HEIGHT), new Point(x, y));
    }

    public DrawableSimpleLabel(String value, SizedFont font, Point position) {
        super(font, position);
        this.value = value;

        state = container.resolveDependencies(NormalSimpleLabelState.class);

        addControls();
    }

    @Override
    public void drawMovingComponent(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.setFont(font);
        var stringBounds = stringUtils.getStringBounds(g2, value);
        g2.drawChars(value.toCharArray(), 0, value.length(), movingObjectPosition.x, movingObjectPosition.y + stringBounds.height);
    }

    @Override
    public void draw(Graphics2D g2) {
        state.draw(this, g2);
    }

    @Override
    public SimpleLabel getLayoutComponent() {
        var label = new SimpleLabel(
                value,
                new Position(Math.max(position.x, 0), Math.max(position.y, 0)),
                new Font("0", new Size(font.getWidth(), font.getHeight()), ZPLConstants.Orientation.normal)
        );

        return label;
    }

    @Override
    public void finalizeMovement(int x, int y) {
        position.x = x;
        position.y = y;

        state = container.resolveDependencies(NormalSimpleLabelState.class);
        controlComponents.clear();
        addControls();
    }

    @Override
    public void drawPreview(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.setFont(font);
        var stringBounds = stringUtils.getStringBounds(g2, value);
        g2.drawChars(DrawableConstants.DEFAULT_LABEL_TEXT.toCharArray(), 0, DrawableConstants.DEFAULT_LABEL_TEXT.length(), previewPosition.x, previewPosition.y + stringBounds.height);
    }

    @Override
    public DrawableSimpleLabel getComponentFromPreview() {
        return new DrawableSimpleLabel(DrawableConstants.DEFAULT_LABEL_TEXT, font, previewPosition);
    }

    @Override
    public void repaint() {
        //se face clear la components dar subscriptia tot ramane
        var drawingPanel = container.resolveDependencies(DrawingPanel.class);

        for (var component : controlComponents) {
            drawingPanel.removeSubscriptionOfObject(component);
        }
        controlComponents.clear();
        addControls();

        super.repaint();
    }

    private void addControls() {
        var drawingPanel = container.resolveDependencies(DrawingPanel.class);
        var g = drawingPanel.getGraphics();

        var fontMetrics = g.getFontMetrics(font);
        var bounds = fontMetrics.getStringBounds(value, g);

        var width = (int) bounds.getWidth();

        var spacing = 5;

        var startY = position.y + font.getHeight();
        var moveButton = new ControlComponent(new Point(position.x + width + spacing, startY), new Dimension(moveIcon.getWidth(), moveIcon.getHeight()), moveIcon);
        var editButton = new ControlComponent(new Point(position.x + width + spacing, startY - moveButton.dimension.height), new Dimension(editIcon.getWidth(), editIcon.getHeight()), editIcon);

        drawingPanel.addSubscriberToMouseClicked(new EventSubscription(moveButton, (Trigger<MouseEvent>) (e) -> {
            return moveButton.isHovered(e.getX(), e.getY());
        }, (EventCallback<MouseEvent>) (e) -> {
            if (state instanceof NormalSimpleLabelState) {
                state = container.resolveDependencies(DisabledSimpleLabelState.class);
                movingObjectPosition.x = e.getPoint().x;
                movingObjectPosition.y = e.getPoint().y;
                drawingPanel.movingComponentChanged(this);
            }
        }));

        drawingPanel.addSubscriberToMouseClicked(new EventSubscription(editButton, (Trigger<MouseEvent>) (e) -> {
            return editButton.isHovered(e.getX(), e.getY());
        }, (EventCallback<MouseEvent>) (e) -> {
            var editWindow = container.resolveDependencies(SimpleLabelEditor.class);
            editWindow.setLocationRelativeTo(container.resolveDependencies(LayoutComposer.class));
            editWindow.bind(this);
            editWindow.setVisible(true);
        }));

        controlComponents.add(moveButton);
        controlComponents.add(editButton);
    }
}

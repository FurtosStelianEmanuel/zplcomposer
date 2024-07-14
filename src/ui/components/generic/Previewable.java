/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.components.generic;

import java.awt.Graphics2D;

/**
 *
 * @author manel
 */
public interface Previewable {

    void updatePreviewPosition(int x, int y);

    void drawPreview(Graphics2D g2);

    <K extends DrawableComponent> K getComponentFromPreview();
}

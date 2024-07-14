/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic;

import java.awt.Point;
import layoutlanguage.LayoutComponent;

/**
 *
 * @author manel
 * @param <K>
 */
public abstract class DrawableComponentWithFont<K extends LayoutComponent> extends DrawableComponent<K> {

    public SizedFont font;

    public DrawableComponentWithFont(SizedFont font, Point position) {
        super(position);
        this.font = font;
    }
}

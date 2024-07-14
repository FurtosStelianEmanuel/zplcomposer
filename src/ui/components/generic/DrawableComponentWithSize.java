/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import layoutlanguage.LayoutComponent;

/**
 *
 * @author manel
 */
public abstract class DrawableComponentWithSize<K extends LayoutComponent> extends DrawableComponent<K> {

    public Dimension size;

    public DrawableComponentWithSize(Point position, Dimension size) {
        super(position);
        this.size = size;
    }
}

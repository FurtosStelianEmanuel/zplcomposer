/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.components.generic.state;

import java.awt.Graphics2D;
import ui.components.generic.DrawableComponent;

/**
 *
 * @author manel
 * @param <K>
 */
public interface State<K extends DrawableComponent> {

    void draw(K source, Graphics2D g2);
}

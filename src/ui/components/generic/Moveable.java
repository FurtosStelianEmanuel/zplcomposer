/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic;

import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author manel
 */
public interface Moveable {

    void finalizeMovement(int x, int y);

    void drawMovingComponent(Graphics2D g2);

    void updateMovingObjectPosition(int x, int y);

    Point getMovingObjectPosition();
}

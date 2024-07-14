/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.components.simple;

import layoutlanguage.LayoutComponent;
import layoutlanguage.Position;
import layoutlanguage.Size;

/**
 *
 * @author manel
 */
public class Rectangle extends LayoutComponent {

    public Size size;
    public int thickness;
    public String color;
    public int rounding;

    public Rectangle(Position position, Size size, int thickness, String color, int rounding) {
        super(Rectangle.class.getSimpleName(), position);
        this.size = size;
        this.thickness = thickness;
        this.color = color;
        this.rounding = rounding;
    }
}

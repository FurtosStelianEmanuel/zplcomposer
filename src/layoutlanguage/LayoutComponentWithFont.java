/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage;

/**
 *
 * @author manel
 */
public abstract class LayoutComponentWithFont extends LayoutComponent {

    public Font font;

    public LayoutComponentWithFont(String type, Position position, Font font) {
        super(type, position);
        this.font = font;
    }
}

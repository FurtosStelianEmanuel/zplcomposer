/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.components.simple;

import layoutlanguage.Font;
import layoutlanguage.LayoutComponent;
import layoutlanguage.LayoutComponentWithFont;
import layoutlanguage.Position;

/**
 *
 * @author manel
 */
public class SimpleLabel extends LayoutComponentWithFont {

    public String value = "";

    public SimpleLabel(String value, Position position, Font font) {
        super(SimpleLabel.class.getSimpleName(), position, font);
        this.value = value;
    }
}

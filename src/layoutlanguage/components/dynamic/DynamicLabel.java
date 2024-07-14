/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.components.dynamic;

import layoutlanguage.Font;
import layoutlanguage.LayoutComponent;
import layoutlanguage.LayoutComponentWithFont;
import layoutlanguage.Position;

/**
 *
 * @author manel
 */
public class DynamicLabel extends LayoutComponentWithFont {

    public DynamicLabel(Position position, Font font) {
        super(DynamicLabel.class.getSimpleName(), position, font);
    }
}

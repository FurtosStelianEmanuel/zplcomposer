/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.layoutzplconverter.marshalling.componentmarshallers;

import layoutlanguage.components.simple.Rectangle;
import layoutlanguage.marshalling.MarshallerInterface;
import zpl.ZPLCommands;

/**
 *
 * @author manel
 */
public class RectangleMarshaller implements MarshallerInterface<Rectangle, String> {

    @Override
    public String marshall(Rectangle source) {
        return ZPLCommands.fo_fieldOrigin(source.position)
                + ZPLCommands.gb_rectangle(source.size.width, source.size.height, source.thickness, source.color, source.rounding)
                + ZPLCommands.fs_fieldSeparator();
    }
}

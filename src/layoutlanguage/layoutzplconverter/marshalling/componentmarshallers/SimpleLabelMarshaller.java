/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.layoutzplconverter.marshalling.componentmarshallers;

import annotations.Injectable;
import layoutlanguage.components.simple.SimpleLabel;
import layoutlanguage.marshalling.MarshallerInterface;
import zpl.ZPLCommands;

/**
 *
 * @author manel
 */
@Injectable
public class SimpleLabelMarshaller implements MarshallerInterface<SimpleLabel, String> {

    public SimpleLabelMarshaller() {

    }

    @Override
    public String marshall(SimpleLabel source) {
        return ZPLCommands.fo_fieldOrigin(source.position)
                + ZPLCommands.a_font(source.font)
                + ZPLCommands.fd_fieldData(source.value)
                + ZPLCommands.fs_fieldSeparator();
    }
}

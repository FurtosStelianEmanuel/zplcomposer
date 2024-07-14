/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.layoutzplconverter;

import annotations.Injectable;
import layoutlanguage.LayoutPage;
import layoutlanguage.layoutzplconverter.marshalling.PrimaryMarshaller;

/**
 *
 * @author manel
 */
@Injectable
public class LayoutToZplConverter {

    public LayoutToZplConversionResult convertToZpl(LayoutPage layoutPage) {

        PrimaryMarshaller marshaller = new PrimaryMarshaller();

        var marshallingResult = marshaller.transformLayoutToZpl(layoutPage);

        return new LayoutToZplConversionResult(marshallingResult.zpl);
    }
}

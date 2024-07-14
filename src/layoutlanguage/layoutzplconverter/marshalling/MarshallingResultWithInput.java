/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.layoutzplconverter.marshalling;

import layoutlanguage.LayoutPage;

/**
 *
 * @author manel
 */
public class MarshallingResultWithInput {

    public String zpl;
    public LayoutPage input;

    public MarshallingResultWithInput(String zpl, LayoutPage input) {
        this.zpl = zpl;
        this.input = input;
    }
}

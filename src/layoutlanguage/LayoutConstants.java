/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage;

import layoutlanguage.components.dynamic.DynamicLabel;
import layoutlanguage.components.simple.Rectangle;
import layoutlanguage.components.simple.SimpleLabel;

/**
 *
 * @author manel
 */
public class LayoutConstants {

    public static class ComponentType {

        public static final String SIMPLE_LABEL = "SimpleLabel";
        public static final String DYNAMIC_LABEL = "DynamicLabel";
        public static final String RECTANGLE = "Rectangle";
    }

    public static String getComponentTypeNameFromClass(Class componentClass) {
        return componentClass.getSimpleName().replaceAll("Marshaller", "");
    }
}

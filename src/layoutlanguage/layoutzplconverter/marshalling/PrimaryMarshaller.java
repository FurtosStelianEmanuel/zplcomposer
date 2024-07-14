/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage.layoutzplconverter.marshalling;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import layoutlanguage.LayoutComponent;
import layoutlanguage.LayoutPage;
import layoutlanguage.layoutzplconverter.LayoutToZplConversionResult;
import layoutlanguage.layoutzplconverter.marshalling.componentmarshallers.SimpleLabelMarshaller;
import layoutlanguage.marshalling.MarshallerInterface;
import zpl.ZPLCommands;
import static documentgenerator.DocumentGenerator.container;
import layoutlanguage.LayoutConstants;
import layoutlanguage.layoutzplconverter.marshalling.componentmarshallers.RectangleMarshaller;

/**
 *
 * @author manel
 */
public class PrimaryMarshaller {

    private final List<Class> marshallers;

    public PrimaryMarshaller() {
        marshallers = new ArrayList() {
            {
                add(SimpleLabelMarshaller.class);
                add(RectangleMarshaller.class);
            }
        };
    }

    public MarshallingResultWithInput transformLayoutToZpl(LayoutPage page) {
        var builder = new StringBuilder();

        builder.append(ZPLCommands.xa_labelStart());

        for (var component : page.getComponents()) {
            var marshaller = getMarshallerForComponent(component);

            builder.append(marshaller.marshall(component).toString());
        }

        builder.append(ZPLCommands.xz_labelEnd());

        return new MarshallingResultWithInput(builder.toString(), page);
    }

    public MarshallerInterface getMarshallerForComponent(LayoutComponent layoutComponent) {
        var marshaller = marshallers.stream().filter(m -> LayoutConstants.getComponentTypeNameFromClass((Class) m).equals(layoutComponent.type)).findFirst().get();

        return (MarshallerInterface) container.resolveDependencies((Class) marshaller);
    }
}

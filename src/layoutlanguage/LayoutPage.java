/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manel
 */
public class LayoutPage {

    private final List<LayoutComponent> components;

    public LayoutPage() {
        components = new ArrayList();
    }

    public LayoutPage(List<LayoutComponent> components) {
        this.components = components;
    }

    public void addComponent(LayoutComponent component) {
        components.add(component);
    }

    public List<LayoutComponent> getComponents() {
        return components;
    }
}

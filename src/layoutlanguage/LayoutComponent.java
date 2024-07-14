/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage;

/**
 *
 * @author manel
 */
public abstract class LayoutComponent {

    public String type;
    public Position position;

    public LayoutComponent(String type, Position position) {
        this.type = type;
        this.position = position;
    }
}

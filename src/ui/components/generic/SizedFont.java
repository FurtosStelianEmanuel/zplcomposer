/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic;

import java.awt.Font;

/**
 *
 * @author manel
 */
public class SizedFont extends Font {

    int width, height;

    public SizedFont(String name, int style, int width, int height) {
        super(name, style, width);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

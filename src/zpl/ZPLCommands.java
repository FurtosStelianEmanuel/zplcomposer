/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zpl;

import layoutlanguage.Font;
import layoutlanguage.Position;

/**
 *
 * @author manel
 */
public class ZPLCommands {

    public static String fo_fieldOrigin(int x, int y) {
        return String.format("^FO%d,%d", x, y);
    }

    public static String fo_fieldOrigin(Position position) {
        return fo_fieldOrigin(position.x, position.y);
    }

    public static String a_font(Font font) {
        return String.format("^A%s%s,%d,%d", font.name, font.orientation, font.size.height, font.size.width);
    }

    public static String fd_fieldData(String input) {
        return String.format("^FD%s", input);
    }

    public static String fs_fieldSeparator() {
        return "^FS";
    }

    public static String xa_labelStart() {
        return "^XA";
    }

    public static String xz_labelEnd() {
        return "^XZ";
    }

    public static String gb_rectangle(int width, int height, int thickness, String color, int rounding) {
        return String.format("^GB%s,%s,%s,%s,%s", width, height, thickness, color, rounding);
    }
}

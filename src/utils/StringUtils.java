/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import annotations.Injectable;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

/**
 *
 * @author manel
 */
@Injectable(ResolveWithNewInstance = false)
public class StringUtils {

    public Rectangle getStringBounds(Graphics2D g2, String str,
            float x, float y) {
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector gv = g2.getFont().createGlyphVector(frc, str);
        return gv.getPixelBounds(null, x, y);
    }

    public Rectangle getStringBounds(Graphics2D g2, String str) {
        return getStringBounds(g2, str, 0, 0);
    }
}

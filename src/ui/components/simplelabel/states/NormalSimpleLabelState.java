/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.simplelabel.states;

import annotations.Injectable;
import java.awt.Color;
import java.awt.Graphics2D;
import ui.components.generic.state.State;
import ui.components.simplelabel.DrawableSimpleLabel;
import utils.StringUtils;

/**
 *
 * @author manel
 */
@Injectable(ResolveWithNewInstance = true)
public class NormalSimpleLabelState implements State<DrawableSimpleLabel> {

    private final StringUtils stringUtils;

    public NormalSimpleLabelState(StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }

    @Override
    public void draw(DrawableSimpleLabel source, Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.setFont(source.font);

        var bounds = stringUtils.getStringBounds(g2, source.value, source.position.x, source.position.y);
        g2.drawChars(source.value.toCharArray(), 0, source.value.length(), source.position.x, source.position.y + bounds.height);

        source.drawControls(g2);
    }
}

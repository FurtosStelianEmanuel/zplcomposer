/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JPanel;
import ui.components.generic.events.EventSubscription;
import ui.components.generic.events.SubscriptionManager;

/**
 *
 * @author manel
 */
public class DrawerBase extends JPanel implements SubscriptionManager {

    protected void setRenderingHints(Graphics2D g2) {
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setRenderingHints(rh);
    }

    protected void clearBackground(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
    }

    @Override
    public void manageSubscription(Object event, List<EventSubscription> subscriptions) {
        for (var subscription : subscriptions) {
            if (!subscription.trigger.shouldTrigger(event)) {
                continue;
            }

            subscription.callback.onEvent(event);
            break;
        }
    }
}

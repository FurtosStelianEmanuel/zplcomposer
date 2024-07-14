/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.components.generic.events;

import java.util.List;

/**
 *
 * @author manel
 */
public interface SubscriptionManager {

    void manageSubscription(Object event, List<EventSubscription> subscriptions);
}

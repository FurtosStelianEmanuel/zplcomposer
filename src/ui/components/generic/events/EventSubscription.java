/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.components.generic.events;

/**
 *
 * @author manel
 */
public class EventSubscription<K> {

    public K component;
    public Trigger trigger;
    public EventCallback callback;

    public EventSubscription(K component, Trigger trigger, EventCallback callback) {
        this.component = component;
        this.trigger = trigger;
        this.callback = callback;
    }
}

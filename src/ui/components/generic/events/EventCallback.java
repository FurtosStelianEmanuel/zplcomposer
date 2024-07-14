/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.components.generic.events;

/**
 *
 * @author manel
 * @param <K>
 */
public interface EventCallback<K> {

    void onEvent(K event);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labelary;

/**
 *
 * @author manel
 */
public class LabelGenerationResult {

    public byte[] bytes;
    public ViewType viewType;

    public LabelGenerationResult(byte[] bytes, ViewType viewType) {
        this.bytes = bytes;
        this.viewType = viewType;
    }
}

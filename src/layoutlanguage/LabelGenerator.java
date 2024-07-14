/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutlanguage;

import labelary.LabelGenerationResult;
import labelary.ViewType;

/**
 *
 * @author manel
 */
public interface LabelGenerator {

    LabelGenerationResult getZplView(String zpl, ViewType viewType);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package layoutlanguage.marshalling;

/**
 *
 * @author manel
 * @param <SourceType>
 * @param <TargetType>
 */
public interface MarshallerInterface<SourceType, TargetType> {

    public TargetType marshall(SourceType source);
}

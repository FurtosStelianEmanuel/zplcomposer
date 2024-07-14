/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filesystem;

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author manel
 */
public class FileToSave {

    public byte[] data;
    public File fileTemplate;

    public FileToSave(byte[] data, File fileTemplate) {
        this.data = data;
        this.fileTemplate = fileTemplate;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filesystem;

import annotations.Injectable;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manel
 */
@Injectable
public class FileSystemHelper {

    public boolean saveFile(FileToSave fileToSave) {
        try {
            Files.write(fileToSave.fileTemplate.toPath(), fileToSave.data);

            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileSystemHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}

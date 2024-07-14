/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import annotations.Injectable;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author manel
 */
@Injectable
public class ImageUtils {

    private final BufferedImage editIcon;
    private final BufferedImage moveIcon;

    public ImageUtils() {
        var originalEditIcon = new ImageIcon(getClass().getResource("/res/edit_icon.png"));
        this.editIcon = getResizedImage(originalEditIcon, 25, 25);

        var originalMoveIcon = new ImageIcon(getClass().getResource("/res/move_icon.png"));
        moveIcon = getResizedImage(originalMoveIcon, 25, 25);
    }

    public final BufferedImage getResizedImage(ImageIcon imageIcon, int targetWidth, int targetHeight) {
        return getResizedImage(toBufferedImage(imageIcon.getImage()), targetWidth, targetHeight);
    }

    public final BufferedImage getResizedImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        return outputImage;
    }

    public final BufferedImage getResizedImage(BufferedImage originalImage, double scale) {
        return getResizedImage(originalImage, (int) (originalImage.getWidth() * scale), (int) (originalImage.getHeight() * scale));
    }

    public final static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    public BufferedImage getEditIcon() {
        return editIcon;
    }

    public BufferedImage getMoveIcon() {
        return moveIcon;
    }
}

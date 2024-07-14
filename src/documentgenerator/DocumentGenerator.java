package documentgenerator;

import banana.Injector;
import banana.InjectorInterface;
import banana.exceptions.ClassNotInjectable;
import banana.exceptions.InterfaceNotImplemented;
import banana.exceptions.UnresolvableDependency;
import filesystem.FileSystemHelper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import labelary.LabelaryLabelGenerator;
import layoutlanguage.layoutzplconverter.LayoutToZplConverter;
import throttling.Throttler;
import ui.LayoutComposer;
import layoutlanguage.LabelGenerator;
import utils.ImageUtils;
import utils.StringUtils;

/**
 *
 * @author manel
 */
public class DocumentGenerator {
    
    public static InjectorInterface container;
    private final LayoutComposer layoutComposerWindow;
    
    public DocumentGenerator(InjectorInterface container) {
        DocumentGenerator.container = container;
        layoutComposerWindow = container.resolveDependencies(LayoutComposer.class);
        java.awt.EventQueue.invokeLater(() -> {
            layoutComposerWindow.setVisible(true);
        });
        
    }
    
    public static void main(String[] args) throws IOException, InterfaceNotImplemented, ClassNotInjectable, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, UnresolvableDependency {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayoutComposer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Injector applicationContainer = new Injector(new HashMap<>(), new HashMap<>(), new ArrayList<>());
        
        applicationContainer
                .addDependency(Throttler.class, Throttler.class)
                .addDependency(FileSystemHelper.class, FileSystemHelper.class)
                .addDependency(LayoutToZplConverter.class, LayoutToZplConverter.class)
                .addDependency(LabelGenerator.class, LabelaryLabelGenerator.class)
                .addDependency(ImageUtils.class, ImageUtils.class)
                .addDependency(StringUtils.class, StringUtils.class);
        
        applicationContainer.initialise();
        
        DocumentGenerator documentGenerator = new DocumentGenerator(applicationContainer);
    }

    /**
     * var generator =
     * container.resolveDependencies(LabelaryLabelGenerator.class);
     *
     * var zpl = """ ^XA
     *
     * ^FX Top section with logo, name and address. ^CF0,60
     * ^FO50,50^GB100,100,100^FS ^FO75,75^FR^GB100,100,100^FS
     * ^FO93,93^GB40,40,40^FS ^FO220,50^FDIntershipping, Inc.^FS ^CF0,30
     * ^FO220,115^FD1000 Shipping Lane^FS ^FO220,155^FDShelbyville TN 38102^FS
     * ^FO220,195^FDUnited States (USA)^FS ^FO50,250^GB700,3,3^FS
     *
     * ^FX Second section with recipient address and permit information. ^CFA,30
     * ^FO50,300^FDJohn Doe^FS ^FO50,340^FD100 Main Street^FS
     * ^FO50,380^FDSpringfield TN 39021^FS ^FO50,420^FDUnited States (USA)^FS
     * ^CFA,15 ^FO600,300^GB150,150,3^FS ^FO638,340^FDPermit^FS
     * ^FO638,390^FD123456^FS ^FO50,500^GB700,3,3^FS
     *
     * ^FX Third section with bar code. ^BY5,2,270 ^FO100,550^BC^FD12345678^FS
     *
     * ^FX Fourth section (the two boxes on the bottom).
     * ^FO50,900^GB700,250,3^FS ^FO400,900^GB3,250,3^FS ^CF0,40
     * ^FO100,960^FDCtr. X34B-1^FS ^FO100,1010^FDREF1 F00B47^FS
     * ^FO100,1060^FDREF2 BL4H8^FS ^CF0,190 ^FO470,955^FDCA^FS
     *
     * ^XZ""";
     *
     * PrimaryMarshaller primaryMarshaller = new PrimaryMarshaller();
     *
     * var page = new LayoutPage();
     *
     * for (int i = 0; i < 5; i++) { var simpleLabel = new SimpleLabel("test
     * foca " + i, new Position(100, 50 * i), new Font("A", new Size(50, 50),
     * ZPLConstants.Orientation.normal));
     *
     * page.addComponent(simpleLabel); }
     *
     * var result = primaryMarshaller.transformLayoutToZpl(page);
     *
     * var generationResult = generator.getZplView(result.zpl, ViewType.Image);
     *
     * var fileSystemHelper =
     * container.resolveDependencies(FileSystemHelper.class);
     * fileSystemHelper.saveFile(new FileToSave(generationResult.bytes, new
     * File("test1.png")));
     *
     */
}

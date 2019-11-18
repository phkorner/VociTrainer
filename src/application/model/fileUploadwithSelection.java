package src.application.model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;




public class fileUploadwithSelection extends Component {
    private static Component parent;

    public static void main(String[] args){

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Select Access File", "accdb");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(parent);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
    }
}


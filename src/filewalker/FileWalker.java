/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewalker;

import filewalker.utils.FileNameSplitter;
import filewalker.utils.FileSizesSplitter;
import filewalker.utils.FolderWalker;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slavik
 */
public class FileWalker {

    private static String folderPath;
    private static String[] cliArgs;
    
    private static String readPath() {
        Scanner reader = new Scanner(System.in);
        String input = "";
        input = reader.next();
        File file = new File(input);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileWalker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            reader.close();        
        }
        return input;
    }
    
    /**
     * @param args the command line arguments
     * @param args[0] - path to folder
     */
    public static void main(String[] args) {
        
        folderPath = args.length > 0 ? args[0] : readPath();
        FileWalkerReportManager report = new FileWalkerReportManager(folderPath);
        try {
            report.doReport();
        } catch (IOException ex) {
            Logger.getLogger(FileWalker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
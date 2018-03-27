/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewalker.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Slavik
 */
public class OutputFileWriter {
    
    private File outputFile;
    private BufferedWriter writer;

    public OutputFileWriter(File outputFile) {
        this.outputFile = outputFile;
    }
    
    public void write(String[] string) throws IOException {
        writer = new BufferedWriter(new FileWriter(outputFile.getAbsolutePath()));
        
        for (int i = 0; i < string.length; i++)
            writer.write(string[i]);
        
        writer.close();
    }
}
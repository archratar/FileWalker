/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewalker.utils;

import java.util.regex.Pattern;

/**
 *
 * @author Slavik
 */
public class FileNameSplitter {
    
    private String[][] names = null;
    
    public FileNameSplitter() {}
    
    public String[] processFileName(String fileName) {
        return fileName.split(Pattern.quote("."));
    }
    
    public String[][] processFileNames(String[] fileNames) {
        String[][] names = new String[fileNames.length][2];
        for (int i = 0; i < fileNames.length; i++) {
            names[i] = this.processFileName(fileNames[i]);
        }
        this.names = names;
        return names;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            builder.append(names[i][0] + " " + names[i][1] + "\n");
        }
        return builder.toString();
     }
}
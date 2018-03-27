/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewalker.utils;

import java.io.File;
import java.util.LinkedList;

/**
 *
 * @author Slavik
 */
public class FolderWalker {
    
    private File folder = null;
    private LinkedList<File> files = null;
    private int position = 0;
    
    public FolderWalker(File folder) {
        this.files = new LinkedList();
        this.folder = folder;
        initFiles();
    }
    
    private void initFiles() {
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            this.files.add(files[i]);
        }
    }
    
    public File iterate() {
        this.position = this.position > files.size() ? 0 : position; 
        return files.get(position++);
    }
    
    public void setFolder(File folder) {
        this.folder = folder;
        this.files = new LinkedList();
    }
    
    public String getFolderPath() {
        return this.folder.getAbsolutePath();
    }
    
    public LinkedList<File> getFiles() {
        return this.files;
    }
    
    public String[] getFilesNames() {
        String[] filesNames = new String[files.size()];
        for (int i = 0; i < this.files.size(); i++)
            filesNames[i] = this.files.get(i).getName();
        return filesNames;
    }
}
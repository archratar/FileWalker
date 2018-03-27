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

/**
 *
 * @author Slavik
 */
public class FileWalkerReportManager {
    
    private FileNameSplitter fileNameSplitter;
    private FileSizesSplitter fileSizesSplitter;
    private FolderWalker folderWalker;
    private File folder; 
    
    private String[] fileNames = null;
    private int[][] whArray = null;

    public FileWalkerReportManager(String folderPath) {
        this.fileNameSplitter = new FileNameSplitter();
        this.fileSizesSplitter = new FileSizesSplitter();
        this.folder = new File(folderPath);
        this.folderWalker = new FolderWalker(folder);
    }
    
    public void doReport() throws IOException {
        File reportFile = this.makeFile();
        fileNames = folderWalker.getFilesNames();
        whArray = fileSizesSplitter.split(fileNames);
        FileOutputStream output = new FileOutputStream(reportFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile));
        
        int i = 1;
        for (int j = 0; j < fileNames.length; j++, i++) {
            if (fileNames[j].equalsIgnoreCase("filelist.txt") || fileNames[j].equalsIgnoreCase("file_list.txt")) {
                i--;
                continue;
            }
            writer.write(i + ". " + fileNames[j]);
            writer.newLine();
        }
        writer.append("Всього файлів: " + --i);
        writer.newLine();
        writer.append("Метрів квадратних: " + doCalculation().toString());
        writer.close();
    }
    
    private File makeFile() throws IOException {
        File file = new File(this.folder.getAbsolutePath() + File.separator + "fileList.txt");
        file.createNewFile();
        return file;
    }
    
    private Double doCalculation() {
        Double whSumm = new Double(0.f);
        for(int i[] : whArray) {
            whSumm += i[0] * i[1];
        }
        return whSumm/1000000.f;
    }
}
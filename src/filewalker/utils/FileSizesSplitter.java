/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewalker.utils;

/**
 *
 * @author Slavik
 */
public class FileSizesSplitter {
    
    public FileSizesSplitter() {
    }
    
    public int[][] split(String[] filesNames) {
        int[][] whArray = new int[filesNames.length][2];
        for (int i = 0; i < filesNames.length; i++) {
            whArray[i] = whExtract(filesNames[i]);
        }
        return whArray;
    }
    
    private int[] whExtract(String string) {
        
        char[] str = string.toCharArray();
        int[] wh = new int[2];
        
        for (int i = 0; i < str.length && str[i] != '.'; i++) {
            if (str[i] == 'w' || str[i] == 'W')
                wh[0] = getInt(str, i);
            else if (str[i] == 'h' || str[i] == 'H') {
                wh[1] = getInt(str, i);
                break;
            }
        }
        return wh;
    }
    
    private int getInt(char[] array, int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = ++position; i < array.length; i++) {
            if (array[i] == '_' || array[i] == '.')
                break;
            builder.append(array[i]);
        }
        return Integer.parseInt(builder.toString());
    }
    
    private boolean match(char ch, char match) {
        return ch == match;
    }
}
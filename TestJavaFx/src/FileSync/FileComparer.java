/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Miki
 */
public class FileComparer {

    public static void compareFileTrees(HashMap<String, FileRecord> sourceFiles, HashMap<String, FileRecord> destinationFiles) throws Exception{
        Iterator sourceFilesIterator = sourceFiles.entrySet().iterator();
        FileRecord tempDestFile, tempSrcFile;
        
    while (sourceFilesIterator.hasNext()) {
        Map.Entry currentFilePair = (Map.Entry)sourceFilesIterator.next();
        
        tempSrcFile = (FileRecord) currentFilePair.getValue();
        tempDestFile = destinationFiles.get(currentFilePair.getKey());
        
        if(destinationFiles.get(currentFilePair.getKey()) != null ){
            if (equalFiles(tempSrcFile,tempDestFile)){
                tempDestFile.setDestiny(FileOperation.NOCHANGE);
            }
            else{
                tempDestFile.setDestiny(FileOperation.UPDATE);
            }
        }
        else{
            FileRecord newRecord = new FileRecord(tempSrcFile.getAbsolutePath());
            newRecord.setDestiny(FileOperation.CREATE);
            destinationFiles.put((String) currentFilePair.getKey(), newRecord);
        }
    }
    }
    
    public static Boolean equalFiles(File a, File b) throws Exception {
        if (a.isDirectory() && b.isDirectory()) {
            return true;
        }
        if (!equalSizes(a, b)) {
            return false;
        }
        if (!equalContents(a, b)) {
            return false;
        }
        return true;
    }

    private static boolean equalSizes(File a, File b) {
        return a.length() == b.length();
    }

    private static boolean equalContents(File a, File b)  throws Exception {
        FileInputStream aFileStream = new FileInputStream(a);
        FileInputStream bFileStream = new FileInputStream(b);
        int aFileIterator = aFileStream.read();
        int bFileIterator = bFileStream.read();
        while (aFileIterator != -1) {
            if (aFileIterator != bFileIterator) {
              return false;
            }
            aFileIterator = aFileStream.read();
            bFileIterator = bFileStream.read();
        }
        aFileStream.close();
        bFileStream.close();
        return true;
    }
}

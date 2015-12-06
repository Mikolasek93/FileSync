/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafx;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class FileHandler {
    protected String srcPath;
    protected String dstPath;
    
    HashMap<String,FileRecord> srcFiles;
    HashMap<String,FileRecord> dstFiles;

    public FileHandler(String srcPath, String dstPath) {
        this.srcPath = srcPath;
        this.dstPath = dstPath;
        
        this.srcFiles = new HashMap<>();
        this.dstFiles = new HashMap<>();
        
        Thread srcLoader;
        srcLoader = new Thread(() -> DirectoryLoader.loadDir(new File(srcPath))).start();
    }
    
    HashMap<String,FileRecord> generateDirectoryTree(String path){
        
    }
    
    
}

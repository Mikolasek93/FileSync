/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafx;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
       Thread srcLoader = new Thread(() -> {
            this.srcFiles = DirectoryLoader.loadDir(new File(srcPath));
            this.dstFiles = DirectoryLoader.loadDir(new File(dstPath));
            System.out.println("NACITAM");
        });
       
       Thread dstLoader = new Thread(() -> {
            // this.dstFiles = DirectoryLoader.loadDir(new File(dstPath));
        });
       
       Thread comparer = new Thread(() -> {
            try {
                srcLoader.join();
                dstLoader.join();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted threads.");
            }
        });
    }
    
    public void StartLoaders(){
        Thread srcLoader;
        

    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync;

import FileSync.GUI.UserInterface;
import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class FileHandler {
    
    UserInterface ParentUI;
    
    protected String srcPath;
    protected String dstPath;
    
    HashMap<String,FileRecord> srcFiles;
    HashMap<String,FileRecord> dstFiles;
    
    protected Thread srcThread;
    protected Thread dstThread;
    protected Thread cmpThread;

    public FileHandler(String srcPath, String dstPath, UserInterface ParentUI) {
        this.ParentUI = ParentUI;
        this.srcPath = srcPath;
        this.dstPath = dstPath;
        
       this.srcThread = new Thread(() -> {
            this.srcFiles = DirectoryLoader.loadDir(new File(srcPath));
        });
       
       this.dstThread = new Thread(() -> {
            this.dstFiles = DirectoryLoader.loadDir(new File(dstPath));
        });
       
       this.cmpThread = new Thread(() -> {
           try {
                srcThread.join();
                dstThread.join();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted threads.");
            }
        });
    }
    
}

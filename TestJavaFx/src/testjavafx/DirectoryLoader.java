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
public class DirectoryLoader {
    
    public static HashMap<String,FileRecord> loadDir(File dir) {
        String relativePath = "./";
        HashMap<String,FileRecord> dirTree = new HashMap<>();
        browseDirsRecursively(dir, relativePath, dirTree);
        return dirTree;
    }

    public static void browseDirsRecursively(File dir, String path, HashMap<String,FileRecord> dirTree) {
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(path+"\n");
            if (file.isDirectory()) {
                dirTree.put(path, new FileRecord(file.getAbsolutePath()));
                browseDirsRecursively(file, path + file.getName() + "/", dirTree);
            } else {
                dirTree.put(path, new FileRecord(file.getAbsolutePath()));
            }
        }
    }
}

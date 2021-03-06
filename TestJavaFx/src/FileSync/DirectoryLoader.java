/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class DirectoryLoader {
    
    public static HashMap<String,FileRecord> loadDir(File dir) {
        String relativePath = File.separator;
        HashMap<String,FileRecord> dirTree = new HashMap<>();
        browseDirsRecursively(dir, relativePath, dirTree);
        return dirTree;
    }

    public static void browseDirsRecursively(File dir, String path, HashMap<String,FileRecord> dirTree) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                dirTree.put(path, new FileRecord(file.getAbsolutePath()));
                browseDirsRecursively(file, path + file.getName() + File.separator  , dirTree);
            } else {
                dirTree.put(path, new FileRecord(file.getAbsolutePath()));
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Miki
 */
public class FileComparer {

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
        FileInputStream fis1 = new FileInputStream(a);
        FileInputStream fis2 = new FileInputStream(b);
        int i1 = fis1.read();
        int i2 = fis2.read();
        while (i1 != -1) {
            if (i1 != i2) {
              return false;
            }
            i1 = fis1.read();
            i2 = fis2.read();
        }
        fis1.close();
        fis2.close();
        return true;
    }
}

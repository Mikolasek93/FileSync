/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync;

import java.io.File;

/**
 *
 * @author Michal
 */
public class FileRecord extends File {
    protected FileOperation destiny;

    public FileRecord(String string) {
        super(string);
    }

    public FileOperation getDestiny() {
        return destiny;
    }

    public void setDestiny(FileOperation destiny) {
        this.destiny = destiny;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync;

import java.io.File;
import java.util.HashMap;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Michal
 */
public class FileHandler {

    protected String srcPath;
    protected String dstPath;

    HashMap<String, FileRecord> sourceFiles;
    HashMap<String, FileRecord> destinationFiles;

    protected Task sourceTask;
    protected Task destinationTask;
    protected Task<Void> compareTask;

    public FileHandler(String srcPath, String dstPath) {
        this.srcPath = srcPath;
        this.dstPath = dstPath;

        this.sourceTask = new Task<HashMap<String, FileRecord>>() {
            @Override
            public HashMap<String, FileRecord> call() {
                return DirectoryLoader.loadDir(new File(srcPath));
            }
        };

        this.sourceTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        sourceFiles = (HashMap<String, FileRecord>) sourceTask.getValue();
                    }
                });

        this.destinationTask = new Task<HashMap<String, FileRecord>>() {
            @Override
            public HashMap<String, FileRecord> call() {
                return DirectoryLoader.loadDir(new File(srcPath));
            }
        };

        this.destinationTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        destinationFiles = (HashMap<String, FileRecord>) destinationTask.getValue();
                    }
                });

        // COMPARE TASK TODO 
        
        
        
    }

}

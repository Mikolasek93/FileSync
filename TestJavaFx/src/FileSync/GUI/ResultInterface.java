/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync.GUI;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author Michal
 */
public class ResultInterface extends Stage {

    protected final String appName = "Results of comparation";

    protected TextArea resultArea;
    
    protected Button syncButton;
    protected Button cancelButton;
    
    protected String srcAbsPath;
    protected String dstAbsPath;
    
    protected GridPane baseGrid;
    
    protected final int windowWidth = 800;
    protected final int windowHeight = 600;

    public ResultInterface(){
        super();
        this.setTitle(appName);
        initButtons(this);
        initTextAreas();
        initGrid();
        placeElements();
        Scene scene = new Scene(baseGrid, windowWidth, windowHeight);
    }

    
    public void initGrid() {
        this.baseGrid = new GridPane();
        this.baseGrid.setAlignment(Pos.CENTER);
        this.baseGrid.setHgap(10);
        this.baseGrid.setVgap(10);
        this.baseGrid.setPadding(new Insets(25, 25, 25, 25));
    }

    public void initButtons(Stage primaryStage) {
        this.syncButton = new Button("Start synchronization");
        this.cancelButton = new Button("Cancel");

        syncButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            System.out.println(file);
            // TODO new Thread(() -> DirectoryLoader.displayDirectoryContents(file, dstFolderArea)).start();
        });
        
        cancelButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            System.out.println(file);
            // TODO new Thread(() -> DirectoryLoader.displayDirectoryContents(file, dstFolderArea)).start();
        });
    }

    public void initTextAreas() {
        this.resultArea = new TextArea("Result");
    }

    public void placeElements() {
        baseGrid.add(syncButton, 0, 0, 1, 1);
        baseGrid.add(cancelButton, 1, 0, 1, 1);

        resultArea.setEditable(false);

        baseGrid.add(resultArea, 0, 1, 2, 2);
        baseGrid.setPadding(new Insets(25, 25, 25, 25));
    }
    
    
}

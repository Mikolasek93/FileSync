/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSync.GUI;

import FileSync.FileHandler;
import FileSync.FileSyncApp;
import java.io.File;
import javafx.application.Application;
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
public class UserInterface extends Application {
    protected FileSyncApp appData;
    protected FileHandler fileHandler;

    protected final int windowWidth = 650;
    protected final int windowHeight = 130;
    
    protected TextArea srcFolderArea;
    protected TextArea dstFolderArea;

    protected Button srcButton;
    protected Button dstButton;
    protected Button cmpButton;
    protected Button cancelButton;

    protected String srcAbsPath;
    protected String dstAbsPath;

    protected GridPane baseGrid;
    protected final String appName = "FileSync";

    protected boolean srcChosen;
    protected boolean dstChosen;

    public void initGrid() {
        this.baseGrid = new GridPane();
        this.baseGrid.setAlignment(Pos.CENTER);
        this.baseGrid.setHgap(10);
        this.baseGrid.setVgap(10);
        this.baseGrid.setPadding(new Insets(25, 25, 25, 25));
    }

    public void initButtons(Stage primaryStage) {
        this.srcButton = new Button("Source Folder");
        this.dstButton = new Button("Destination Folder");
        this.cmpButton = new Button("Start comparation");
        this.cancelButton = new Button("Cancel comparation");
        this.cmpButton.setDisable(true);
        this.cancelButton.setDisable(true);
        
        srcButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            if (file == null) {
                return;
            }
            this.srcAbsPath = file.getAbsolutePath();
            this.srcChosen = true;
            srcFolderArea.setText(this.srcAbsPath);
            
            if (dstChosen) {
                cmpButton.setDisable(false);
            }
        });

        dstButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            if (file == null) {
                return;
            }
            this.dstAbsPath = file.getAbsolutePath();
            this.dstChosen = true;
            dstFolderArea.setText(this.dstAbsPath);
            
            if (srcChosen) {
                cmpButton.setDisable(false);
            }
        });

        cmpButton.setOnAction((ActionEvent arg0) -> {
            cmpButton.setDisable(true);
            cancelButton.setDisable(false);
            this.fileHandler = new FileHandler(srcAbsPath, dstAbsPath, this);
        });
        
        cancelButton.setOnAction((ActionEvent arg0) -> {
            
            cancelButton.setDisable(true);
            cmpButton.setDisable(false);
        });
    }

    public void initTextAreas() {
        this.srcFolderArea = new TextArea("Input folder");
        this.dstFolderArea = new TextArea("Output folder");
        
        srcFolderArea.setEditable(false);
        dstFolderArea.setEditable(false);
    }

    public void placeElements() {
        baseGrid.add(srcButton, 0, 0, 1, 1);
        baseGrid.add(dstButton, 1, 0, 1, 1);
        baseGrid.add(cmpButton, 0, 2, 1, 1);
        baseGrid.add(cancelButton, 1, 2, 1, 1);
        
        baseGrid.add(srcFolderArea, 0, 1, 1, 1);
        baseGrid.add(dstFolderArea, 1, 1, 1, 1);
        baseGrid.setPadding(new Insets(5, 5, 5, 5));
    }

    @Override
    public void start(Stage primaryStage) {
        this.srcChosen = false;
        this.dstChosen = false;
        primaryStage.setTitle(appName);
        initButtons(primaryStage);
        initTextAreas();
        initGrid();
        placeElements();
        Scene scene = new Scene(baseGrid, windowWidth, windowHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
        
     }
}

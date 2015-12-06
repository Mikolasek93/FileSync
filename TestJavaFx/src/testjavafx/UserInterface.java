/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavafx;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author Michal
 */
public class UserInterface extends Application {
    protected FileSyncApp appData;

    protected Label srcFolderLabel;

    protected TextArea srcFolderArea;
    protected TextArea dstFolderArea;
    
    protected Button srcButton;
    protected Button dstButton;
    protected Button cmpButton;

    protected String srcAbsPath;
    protected String dstAbsPath;
   
    protected GridPane baseGrid;
    protected final String appName = "test";
    
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
        
        srcButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            this.srcAbsPath = file.getAbsolutePath();
            });

        dstButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            this.dstAbsPath = file.getAbsolutePath();
            });

        cmpButton.setOnAction((ActionEvent arg0) -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(primaryStage);
            System.out.println(file);
            //ResultInterface.launch();
            // todo new Thread(() -> DirectoryLoader.displayDirectoryContents(file, dstFolderArea)).start();
        });
    }

    public void initTextAreas() {
        this.srcFolderArea = new TextArea("TEST");
        this.dstFolderArea = new TextArea("TEST");
    }

    public void placeElements() {
        baseGrid.add(srcButton, 0, 0, 1, 1);
        baseGrid.add(dstButton, 1, 0, 1, 1);

        srcFolderArea.setEditable(false);
        dstFolderArea.setEditable(false);

        baseGrid.add(srcFolderArea, 0, 1, 1, 2);
        baseGrid.add(dstFolderArea, 1, 1, 1, 2);
        baseGrid.setPadding(new Insets(25, 25, 25, 25));
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(appName);
        initButtons(primaryStage);
        initTextAreas();
        initGrid();
        placeElements();
        Scene scene = new Scene(baseGrid, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public UserInterface() {
    }
    
}
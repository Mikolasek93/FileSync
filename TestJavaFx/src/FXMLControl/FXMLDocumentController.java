package FXMLControl;
 
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
 
public class FXMLDocumentController {
    @FXML private Text actiontarget;
    
    @FXML protected TextField sourceFolder;
    @FXML protected TextField destinationFolder;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }
    
    
    @FXML protected void handleSourceButtonAction(ActionEvent event) {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(new Stage());
            if (file == null) {
                return;
            }
            this.sourceFolder.setText(file.getAbsolutePath());
    }
    
    @FXML protected void handleDestinationButtonAction(ActionEvent event) {
            DirectoryChooser fileChooser = new DirectoryChooser();
            File file = fileChooser.showDialog(new Stage());
            if (file == null) {
                return;
            }
            this.destinationFolder.setText(file.getAbsolutePath());
    }
    
        
    @FXML protected void handleCompareButtonAction(ActionEvent event) {
    }
}
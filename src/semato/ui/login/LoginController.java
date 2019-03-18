package semato.ui.login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import semato.ui.appmain.AppmainController;

public class LoginController {

    //private double xOffset = 0;
    //private double yOffset = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView CloseButton;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;


    @FXML
    private Label login_label;


    @FXML
    void handleCloseButtonAction(MouseEvent event) {
    System.exit(0);
    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {

        login_label.setText(" ");
        String uname = username.getText();
        String pass = password.getText();

        if(uname.equals("admin") && pass.equals("admin"))
        {
            closeStage();
            loadAppMain();
        }
        else{
            login_label.setText("Podano niepoprawne dane.");
        }
    }
    private void closeStage(){
        ((Stage)username.getScene().getWindow()).close();
    }

    public void loadAppMain(){

        try{
            Parent parent = FXMLLoader.load(getClass().getResource("/semato/ui/appmain/appmain.fxml"));
            Stage stage = new Stage(StageStyle.TRANSPARENT);
          //  stage.initStyle(StageStyle.TRANSPARENT);

            /*
            // for moving stage
            parent.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            */
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();


        }   catch (IOException ex){
            Logger.getLogger(AppmainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void initialize() {

    }
}



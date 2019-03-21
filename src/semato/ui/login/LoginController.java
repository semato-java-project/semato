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
import semato.ui.MainController;
import semato.ui.oferta.OfertaController;

public class LoginController extends MainController {

    @FXML
    private ImageView CloseButton;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label login_label;


    private static LoginController instance;

    public LoginController() {
        instance = this;
    }

    public static LoginController getInstance() {
        return instance;
    }

    public String getUsername() {
        return username.getText();
    }


    @FXML
    void handleCloseButtonAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {

        login_label.setText(" ");
        String uname = username.getText();
        String pass = password.getText();

        if (uname.equals("admin") || uname.equals("Mietek") && pass.equals("admin")) {
            closeStage();
            loadPage("/semato/ui/oferta/oferta.fxml");
        } else {
            login_label.setText("Podano niepoprawne dane.");
        }
    }

    private void closeStage() {
        ((Stage) CloseButton.getScene().getWindow()).close();
    }


    public void loadPage(String path) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            MovingStage(root, stage);


        } catch (IOException ex) {
            Logger.getLogger(OfertaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Dlaczego musialem to nadpisac poniżej? bez tego sie nie buildowalo
    @Override
    public void start(Stage primaryStage) throws Exception {

        loadPage("login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


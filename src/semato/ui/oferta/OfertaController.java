package semato.ui.oferta;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import semato.ui.MainController;
import semato.ui.login.LoginController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OfertaController extends MainController {

    @FXML
    AnchorPane oferta;

    @FXML
    private Text username;

    @FXML
    AnchorPane holderPane;

    @FXML
    AnchorPane oferta_content_pane;

    @FXML
    private JFXButton LogOutButton;


    private static OfertaController instance;

    public OfertaController(){
        instance = this;
    }

    public static OfertaController getInstance(){
        return instance;
    }

    public void setUsername(String uname){
        this.username.setText(uname);
    }

    private void setNode(Node node){


        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }

    private void createPage(AnchorPane Content, String loc)
    {
        try {
            Content = FXMLLoader.load(getClass().getResource(loc));
            setNode(Content);
        } catch(IOException e ) {
            e.printStackTrace();
        }
    }

   @FXML
   void logOut(ActionEvent event){
      ((Stage)LogOutButton.getScene().getWindow()).close();
       loadPage("/semato/ui/login/login.fxml");
   }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createPage(oferta,"/semato/ui/oferta/content_oferta.fxml");
        setUsername("Witaj, " + LoginController.getInstance().getUsername());
    }
}

package semato.ui.oferta;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import semato.ui.MainController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OfertaController extends MainController {

    @FXML
    AnchorPane holderPane;

    @FXML
    AnchorPane oferta_content_pane;

    @FXML
    private ImageView Close;

    @FXML
    private JFXButton LogOutButton;

    @FXML
    void handleCloseAction(MouseEvent event) {
        System.exit(0);
    }

    private void setNode(Node node){
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }

    private void createPage()
    {
        try {
            oferta_content_pane = FXMLLoader.load(getClass().getResource("/semato/ui/oferta/content_oferta.fxml"));
            setNode(oferta_content_pane);
        } catch(IOException e ) {
            e.printStackTrace();
        }
    }

   @FXML
   void logOut(ActionEvent event){
      ((Stage)LogOutButton.getScene().getWindow()).close();
       loadPage("/semato/ui/login/login.fxml");
   }

    public void loadPage(String path){

        try{
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            MovingStage(root,stage);
        }   catch (IOException ex){
            Logger.getLogger(OfertaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void initialize() {
        createPage();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

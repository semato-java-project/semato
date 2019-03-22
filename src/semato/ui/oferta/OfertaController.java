package semato.ui.oferta;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import semato.ui.MainController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import semato.ui.homepage.HomePageController;
import sun.plugin.javascript.navig.Anchor;

import java.net.URL;
import java.util.ResourceBundle;


public class OfertaController  {


    @FXML
    private AnchorPane oferta_content_pane;

    @FXML
    private JFXButton ReserveButton;

    @FXML
    void ShowReservationDetails(ActionEvent event) {
        oferta_content_pane.getChildren().clear();
        HomePageController.getInstance().createContentPage(oferta_content_pane,"/semato/ui/makereservation/content_makereservation.fxml");
    }


}

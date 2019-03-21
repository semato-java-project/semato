package semato.ui.makereservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import semato.ui.homepage.HomePageController;
import semato.ui.oferta.OfertaController;

public class MakeReservationController {

    @FXML
    private Pane backToOfertaButton;

    @FXML
    private AnchorPane makereservation_content_pane;

    @FXML
    void BackToOferta(ActionEvent event) {
        makereservation_content_pane.getChildren().clear();
        HomePageController.getInstance().createContentPage(OfertaController.getInstance().getOferta_content_pane(),"/semato/ui/oferta/content_oferta.fxml.fxml");

    }
}

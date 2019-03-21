package semato.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public abstract class MainController extends Application {

     private double xOffset = 0;
     private double yOffset = 0;


    @FXML
    private ImageView CloseButton;

    @FXML
    void handleCloseButtonAction(MouseEvent event) {
        System.exit(0);
    }


    public void MovingStage(Parent root, Stage stage)
    {
        // for moving stage
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

    }
}

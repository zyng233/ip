package popi.launch;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import popi.core.Popi;
import popi.ui.MainWindow;

/**
 * A GUI for Popi using FXML.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Popi popi = new Popi();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            Parent root = loader.load();

            MainWindow controller = loader.getController();
            controller.setPopi(popi);

            Scene scene = new Scene(root);
            String css = getClass().getResource("/view/style.css") != null
                    ? getClass().getResource("/view/style.css").toExternalForm()
                    : "";
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.setTitle("Popi");
            stage.setResizable(false);
            stage.setMinHeight(600.0);
            stage.setMinWidth(400.0);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

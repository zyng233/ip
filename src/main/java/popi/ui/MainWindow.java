package popi.ui;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import popi.core.Popi;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends Stage {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    private Popi popi;
    private Ui ui;
    private final Image USER = loadImage("/images/dinosaur.jpg");
    private final Image POPI = loadImage("/images/popi.png");

    /**
     * Constructor for MainWindow.
     */
    public MainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            AnchorPane root = loader.load();

            // Setup the scene and stage
            Scene scene = new Scene(root);
            String cssPath = "/view/style.css";
            String css = getClass().getResource(cssPath) != null
                    ? getClass().getResource(cssPath).toExternalForm()
                    : "";
            scene.getStylesheets().add(css);
            setScene(scene);
            setTitle("Popi");
            setResizable(false);
            setMinHeight(600.0);
            setMinWidth(400.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the MainWindow.
     */
    @FXML
    public void initialize() {
        ui = new Ui();
        ui.showWelcome();
        String greeting = ui.getResponse();
        dialogContainer.getChildren().add(
                DialogBox.getPopiDialog(greeting, POPI)
        );
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Popi instance */
    public void setPopi(Popi d) {
        popi = d;
        popi.setUi(ui);
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Popi's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        if (popi == null) {
            System.err.println("Error: Popi instance is not initialized.");
            return;
        }

        String input = userInput.getText();
        String response = popi.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, USER),
                DialogBox.getPopiDialog(response, POPI)
        );
        userInput.clear();
    }

    private Image loadImage(String path) {
        InputStream imageStream = this.getClass().getResourceAsStream(path);
        if (imageStream == null) {
            throw new IllegalArgumentException("Image file not found: " + path);
        }
        return new Image(imageStream);
    }
}

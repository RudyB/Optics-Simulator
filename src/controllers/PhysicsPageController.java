package controllers;
/*
 * @Author:  Rudy Bermudez
 * @Email:   hello@rudybermudez.co
 * @Date:    May 02, 2016
 * @Project: RudyBermudez_P3
 * @Package:    controllers
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The type Physics page controller.
 */
public class PhysicsPageController {

    /**
     * The Is grating page.
     */
    private boolean isGratingPage;

    /**
     * The Close button.
     */
    @FXML
    Button closeButton;

    /**
     * The Toggle page button.
     */
    @ FXML
    Button togglePageButton;

    /**
     * The Anchor pane.
     */
    @FXML
    AnchorPane anchorPane;


    /**
     * Initialize.
     */
    public void initialize(){
        Stage stage = new Stage();
        isGratingPage = true;
        togglePageButton.setText("Go to Circular Hole Diffraction");
        setBackgroundImage("/images/Grating.png");
    }

    /**
     * Close window.
     *
     * @param actionEvent the action event
     */
    @FXML
    void closeWindow(ActionEvent actionEvent){
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.close();
    }

    /**
     * Toggle page.
     *
     * @param actionEvent the action event
     */
    @FXML
    void togglePage(ActionEvent actionEvent){
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        if (isGratingPage){
            setBackgroundImage("/images/Circular.png");
            togglePageButton.setText("Go to Grating Diffraction");
            isGratingPage = false;
        } else {
            togglePageButton.setText("Go to Circular Hole Diffraction");
            setBackgroundImage("/images/Grating.png");
            isGratingPage = true;
        }


    }

    /**
     * Set background image.
     *
     * @param image the image
     */
    void setBackgroundImage(String image){
        BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResource(image).toExternalForm(),800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        anchorPane.setBackground(new Background(backgroundImage));
    }


}

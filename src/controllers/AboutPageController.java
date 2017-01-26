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
import javafx.stage.Stage;

/**
 * The type About page controller.
 */
public class AboutPageController {

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
}

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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Start page controller.
 */
public class StartPageController {


    /**
     * Load circular hole Page.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    public void loadCircularHole(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CircularHolePage.fxml"));
        Scene editorPage = new Scene(loader.load());
        primaryStage.setScene(editorPage);
        primaryStage.setTitle("Experiment: Circular Hole Diffraction");
        primaryStage.show();

    }

    /**
     * Load grating diffraction Page.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    public void loadGratingDiffraction(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setTitle("Experiment: Grating Diffraction");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DiffractionGratingPage.fxml"));
        Scene editorPage = new Scene(loader.load());
        primaryStage.setScene(editorPage);
        primaryStage.show();
    }

}
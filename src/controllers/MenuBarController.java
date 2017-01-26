package controllers;
/*
 * @Author:  Rudy Bermudez
 * @Email:   hello@rudybermudez.co
 * @Date:    May 03, 2016
 * @Project: RudyBermudez_P3
 * @Package:    controllers
 */

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The type Menu bar controller.
 */
public class MenuBarController {

    /**
     * The My menu bar.
     */
    @FXML
    MenuBar myMenuBar;

    /**
     * The Print node.
     */
    public Node printNode;

    /**
     * The Save node.
     */
    public Node saveNode;

    /**
     * Load physics page.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void loadPhysicsPage(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PhysicsPage.fxml"));
        Scene editorPage = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(editorPage);
        stage.setTitle("Theory (Physics Behind This Program)");
        stage.show();
    }

    /**
     * Load about page.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void loadAboutPage(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AboutPage.fxml"));
        Scene editorPage = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(editorPage);
        stage.setTitle("About the Developers");
        stage.show();

    }

    /**
     * Load diffraction page.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void loadDiffractionPage(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) myMenuBar.getScene().getWindow();
        primaryStage.hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DiffractionGratingPage.fxml"));
        Scene editorPage = new Scene(loader.load());
        primaryStage.setScene(editorPage);
        primaryStage.setTitle("Experiment: Grating Diffraction");
        primaryStage.show();
    }

    /**
     * Load circular hole page.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML void loadCircularHolePage(ActionEvent actionEvent) throws  IOException {
        Stage primaryStage = (Stage) myMenuBar.getScene().getWindow();
        primaryStage.hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CircularHolePage.fxml"));
        Scene editorPage = new Scene(loader.load());
        primaryStage.setScene(editorPage);
        primaryStage.setTitle("Experiment: Circular Hole Diffraction");
        primaryStage.show();
    }

    /**
     * Save image.
     */
    @FXML
    public void saveImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG File","*.png"),
                new FileChooser.ExtensionFilter("GIF File","*.gif"));

        File image = fileChooser.showSaveDialog(saveNode.getScene().getWindow());

        int fileExtensionLength = fileChooser.getSelectedExtensionFilter().getExtensions().get(0).length();
        String fileExt = fileChooser.getSelectedExtensionFilter().getExtensions().get(0).substring(2,fileExtensionLength);

        try {
            ImageIO.write(getSnapshot(saveNode),fileExt,image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get snapshot buffered image.
     *
     * @param node the node
     * @return the buffered image
     */
    private BufferedImage getSnapshot(Node node){
        WritableImage snapshot = node.snapshot(null,null);
        return SwingFXUtils.fromFXImage(snapshot, null);
    }

    /**
     * Print image.
     */
    @FXML
    public void printImage() {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        printerJob.showPrintDialog(printNode.getScene().getWindow());
        if (printerJob != null) {
            boolean success = printerJob.printPage(printNode);
            if (success) {
                printerJob.endJob();
            }
        }
    }

}

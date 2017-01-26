package controllers;
/*
 * @Author:  Rudy Bermudez
 * @Email:   hello@rudybermudez.co
 * @Date:    May 02, 2016
 * @Project: RudyBermudez_P3
 * @Package:    controllers
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.CircleApertureDrawing;
import models.CircleDiffraction;
import models.CircleDiffractionPattern;
import models.CircleIntensityProfile;

/**
 * The type Circular hole page controller.
 */
public class CircularHolePageController extends MenuBarController{

    /**
     * The My menu bar.
     */
    @FXML
    MenuBar myMenuBar;

    /**
     * The Experiment image view.
     */
    @FXML
    ImageView experimentImageView;

    /**
     * The Aperture tab.
     */
    @FXML
    Tab apertureTab;
    /**
     * The Experiment tab.
     */
    @FXML
    Tab experimentTab;
    /**
     * The Profile tab.
     */
    @FXML
    Tab profileTab;
    /**
     * The Pattern tab.
     */
    @FXML
    Tab patternTab;

    /**
     * The Wavelength slider.
     */
    @FXML
    Slider wavelengthSlider;
    /**
     * The Diameter slider.
     */
    @FXML
    Slider diameterSlider;
    /**
     * The Distance slider.
     */
    @FXML
    Slider distanceSlider;

    /**
     * The Angle 1 text.
     */
    @FXML TextField angle1Text;
    /**
     * The Angle 2 text.
     */
    @FXML TextField angle2Text;
    /**
     * The Angle 3 text.
     */
    @FXML TextField angle3Text;

    /**
     * The Radius 1 text.
     */
    @FXML TextField radius1Text;
    /**
     * The Radius 2 text.
     */
    @FXML TextField radius2Text;
    /**
     * The Radius 3 text.
     */
    @FXML TextField radius3Text;


    /**
     * The wavelength slider value
     */
    @FXML Label wavelengthLabel;

    /**
     * The diameter slider label
     */
    @FXML Label diameterLabel;

    /**
     * The distance slider label
     */
    @FXML Label distanceLabel;





    /**
     * The Circle drawing.
     */
    CircleApertureDrawing circleDrawing;
    /**
     * The Pattern.
     */
    CircleDiffractionPattern pattern;
    /**
     * The Experiment.
     */
    CircleDiffraction experiment;
    /**
     * The Profile.
     */
    CircleIntensityProfile profile;

    /**
     * Initialize.
     */
    public void initialize() {
        circleDrawing = new CircleApertureDrawing(.5, .000400);
        pattern = new CircleDiffractionPattern(.5, .000400, 500);
        experiment = new CircleDiffraction(.5, .000400, 500);
        profile = new CircleIntensityProfile(.5, .000400);
        apertureTab.setContent(circleDrawing);
        profileTab.setContent(profile);
        patternTab.setContent(pattern);
        setExperimentImageColor("/images/experiments/circular/Purple.jpg");
        updateData();

        wavelengthSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double w = (double)newValue/1000000;
                circleDrawing.setMmWavelength(w);
                pattern.setMmWavelength(w);
                experiment.setMmWavelength(w);
                profile.setMmWavelength(w);
                wavelengthLabel.setText(String.valueOf(Math.round(w*1000000*100d)/100d));
                if (w>= .000400 && w <= .000425) {
                    setExperimentImageColor("/images/experiments/circular/Purple.jpg");
                }
                else if (w>= .000430 && w <= .000489) {
                    setExperimentImageColor("/images/experiments/circular/Blue.jpg");
                }
                else if (w>= .000490 && w <= .000548) {
                    setExperimentImageColor("/images/experiments/circular/Green.jpg");
                }
                else if (w >= .000550 && w <= .000600){
                    setExperimentImageColor("/images/experiments/circular/Yellow.jpg");
                } else if (w >= .000600 && w <= .000630){
                    setExperimentImageColor("/images/experiments/circular/Orange.jpg");
                } else if (w >= .000630 && w <= .000700){
                    setExperimentImageColor("/images/experiments/circular/Red.jpg");
                }
                updateData();

            }
        });

        diameterSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double d = (double)newValue;
                circleDrawing.setMmDiameter(d);
                pattern.setMmDiameter(d);
                experiment.setMmDiameter(d);
                profile.setMmDiameter(d);
                diameterLabel.setText(String.valueOf(Math.round(d*100d)/100d));
                updateData();

            }
        });

        distanceSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double d = (double)newValue;
                pattern.setMmScreenDistance(d);
                experiment.setMmScreenDistance(d);
                distanceLabel.setText(String.valueOf(Math.round(d*100d)/100d));
                updateData();

            }
        });
    }


    /**
     * Update data.
     */
//Math.round(value * 100000d) / 100000d
    public void updateData(){
        angle1Text.setText(String.valueOf(
                Math.round(experiment.getNthDiffractionAngle(1)*100000d)/100000d
        ));
        angle2Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionAngle(2)-experiment.getNthDiffractionAngle(1))*100000d)/100000d
        ));
        angle3Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionAngle(3)-experiment.getNthDiffractionAngle(2))*100000d)/100000d
        ));
        radius1Text.setText(String.valueOf(
                Math.round(experiment.getAirysRadius()*1000d)/1000d
        ));
        radius2Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionRadius(2)-experiment.getNthDiffractionRadius(1))*1000d)/1000d
        ));
        radius3Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionRadius(3)-experiment.getNthDiffractionRadius(2))*1000d)/1000d
        ));
    }

    /**
     * Save image.
     */
    @Override
    public void saveImage() {
        saveNode = profile;
        super.saveImage();
    }

    /**
     * Print image.
     */
    @Override
    public void printImage() {
        printNode = profile;
        super.printImage();
    }

    /**
     * Set experiment image color.
     *
     * @param imagePath the image path
     */
    private void setExperimentImageColor(String imagePath){
        experimentImageView.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
    }
}



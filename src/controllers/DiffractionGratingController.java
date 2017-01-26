package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.DiffractionGrating;
import models.GratingApertureDrawing;

/**
 * Created by tonyfox on 5/3/16.
 */
public class DiffractionGratingController extends MenuBarController {

    /**
     * The Experiment.
     */
    DiffractionGrating experiment;
    /**
     * The Aperture drawing.
     */
    GratingApertureDrawing apertureDrawing;

    /**
     * The Aperture tab.
     */
    @FXML
    Tab apertureTab;

    /**
     * The Experiment image view.
     */
    @FXML
    ImageView experimentImageView;

    /**
     * The My menu bar.
     */
    @FXML
    MenuBar myMenuBar;

    /**
     * The Angle 1 text.
     */
    @FXML
    TextField angle1Text;
    /**
     * The Angle 2 text.
     */
    @FXML
    TextField angle2Text;
    /**
     * The Angle 3 text.
     */
    @FXML
    TextField angle3Text;

    /**
     * The Radius 1 text.
     */
    @FXML
    TextField radius1Text;
    /**
     * The Radius 2 text.
     */
    @FXML
    TextField radius2Text;
    /**
     * The Radius 3 text.
     */
    @FXML
    TextField radius3Text;

    /**
     * The Wavelength slider.
     */
    @FXML
    Slider wavelengthSlider;
    /**
     * The Density slider.
     */
    @FXML
    Slider densitySlider;
    /**
     * The Distance slider.
     */
    @FXML
    Slider distanceSlider;

    /**
     * The wavelength slider value
     */
    @FXML
    Label wavelengthLabel;

    /**
     * The diameter slider label
     */
    @FXML Label densityLabel;

    /**
     * The distance slider label
     */
    @FXML Label distanceLabel;

    /**
     * Initialize.
     */
    public void initialize() {
        experiment = new DiffractionGrating(.000400, 500, 1);
        apertureDrawing = new GratingApertureDrawing(.000400, 1);
        apertureTab.setContent(apertureDrawing);
        setExperimentImageColor("/images/experiments/grating/Purple.jpg");
        updateData();

        wavelengthSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double d = (double) newValue / 1000000;
                experiment.setMmWavelength(d);
                apertureDrawing.setMmWavelength(d);
                wavelengthLabel.setText(String.valueOf(Math.round(d*1000000*100d)/100d));
                if (d>= .000400 && d <= .000425) {
                    setExperimentImageColor("/images/experiments/grating/Purple.jpg");
                }
                else if (d>= .000430 && d <= .000489) {
                    setExperimentImageColor("/images/experiments/grating/Blue.jpg");
                }
                else if (d>= .000490 && d <= .000548) {
                    setExperimentImageColor("/images/experiments/grating/Green.jpg");
                }
                else if (d >= .000550 && d <= .000600){
                    setExperimentImageColor("/images/experiments/grating/Yellow.jpg");
                } else if (d >= .000600 && d <= .000630){
                    setExperimentImageColor("/images/experiments/grating/Orange.jpg");
                } else if (d >= .000630 && d <= .000700){
                    setExperimentImageColor("/images/experiments/grating/Red.jpg");
                }
                updateData();
            }
        });

        densitySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double d = (double) newValue;
                experiment.setLineDensity(Math.round(d));
                apertureDrawing.setLineDensity(d);
                densityLabel.setText(String.valueOf(Math.round(d)));
                updateData();
            }
        });

        distanceSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double d = (double) newValue;
                experiment.setMmScreenDistance(d);
                distanceLabel.setText(String.valueOf(Math.round(d*100d)/100d));
                updateData();

            }
        });
    }


    /**
     * Update data.
     */
    public void updateData() {
        angle1Text.setText(String.valueOf(
                Math.round(experiment.getNthDiffractionAngle(1) * 100000d) / 100000d
        ));
        angle2Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionAngle(2)) * 100000d) / 100000d
        ));
        angle3Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionAngle(3)) * 100000d) / 100000d
        ));
        radius1Text.setText(String.valueOf(
                Math.round(experiment.getNthDiffractionDistance(1) * 1000d) / 1000d
        ));
        radius2Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionDistance(2)) * 1000d) / 1000d
        ));
        radius3Text.setText(String.valueOf(
                Math.round((experiment.getNthDiffractionDistance(3)) * 1000d) / 1000d
        ));
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

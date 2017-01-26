package models;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;


/**
 * This class draws the diffraction patter on the airys disk from diffraction through a circular aperture
 */
public class CircleDiffractionPattern extends StackPane {
    /**
     * The Pixelstomm.
     */
    private final int PIXELSTOMM = 20; //note: 1mm = 100 pixels
    /**
     * The Mm diameter.
     */
    private double mmDiameter;
    /**
     * The Mm wavelength.
     */
    private double mmWavelength;
    /**
     * The Mm screen distance.
     */
    private double mmScreenDistance;
    /**
     * The Airys disk.
     */
    private Circle airysDisk = new Circle();


    /**
     * constructor that sets up the drawing with proper disk radius, color, and gradient
     *
     * @param mmDiameter       diameter of aperture in millimeters
     * @param mmWavelength     wavelength of light source in millimeters
     * @param mmScreenDistance screen distance from aperture in millimeters
     */
    public CircleDiffractionPattern(double mmDiameter, double mmWavelength, double mmScreenDistance){
        this.mmDiameter = mmDiameter;
        this.mmWavelength = mmWavelength;
        this.mmScreenDistance = mmScreenDistance;
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        airysDisk.setRadius(calculateAirysRadius()*PIXELSTOMM);
        airysDisk.setFill(createGradient(mmWavelength));
        getChildren().add(airysDisk);

    }


    /**
     * method creates gradient coloring based on wavelength to fill the disk
     *
     * @param wavelength wavelength in millimeters
     * @return gradient object to fill the airys disk
     */
    public RadialGradient createGradient(double wavelength){
        Color color = WavelengthToColor.getColor(wavelength,1);
        RadialGradient gradient = new RadialGradient(0, 0, airysDisk.getCenterX(), airysDisk.getCenterY(),
                airysDisk.getRadius(), false, null, new Stop(1, Color.BLACK), new Stop(.2, color));
        return gradient;
    }


    /**
     * calcilates the radius of the airys disk to be draw base class components
     *
     * @return radius in millimeters
     */
    public double calculateAirysRadius(){
        CircleDiffraction circleDiff = new CircleDiffraction(mmDiameter, mmWavelength, mmScreenDistance);
        //System.out.print(circleDiff.getAirysRadius());
        return circleDiff.getAirysRadius();
    }


    /**
     * getter for diameter
     *
     * @return diameter in millimeters
     */
    public double getMmDiameter() {
        return mmDiameter;
    }


    /**
     * setter for diameter that updates the drawing
     *
     * @param mmDiameter diameter in millimeters
     */
    public void setMmDiameter(double mmDiameter) {
        this.mmDiameter = mmDiameter;
        double newRadius = calculateAirysRadius();
        airysDisk.setRadius(newRadius * PIXELSTOMM);
        RadialGradient newGradient = createGradient(mmWavelength);
        airysDisk.setFill(newGradient);
    }


    /**
     * getter for wavelength
     *
     * @return wavelength in millimeters
     */
    public double getMmWavelength() {
        return mmWavelength;
    }

    /**
     * setter for wavelength that updates the drawing
     *
     * @param mmWavelength wavelength in millimeters
     */
    public void setMmWavelength(double mmWavelength) {
        this.mmWavelength = mmWavelength;
        RadialGradient newGradient = createGradient(mmWavelength);
        airysDisk.setFill(newGradient);
    }

    /**
     * getter for screen distance
     *
     * @return screen distance from aperture in millimeters
     */
    public double getMmScreenDistance() {
        return mmScreenDistance;
    }

    /**
     * setter for screen distance that updates the drawing
     *
     * @param mmScreenDistance screen distance from aperture in millimeters
     */
    public void setMmScreenDistance(double mmScreenDistance) {
        this.mmScreenDistance = mmScreenDistance;
        double newRadius = calculateAirysRadius();
        airysDisk.setRadius(newRadius * PIXELSTOMM);
        RadialGradient newGradient = createGradient(mmWavelength);
        airysDisk.setFill(newGradient);
    }
}

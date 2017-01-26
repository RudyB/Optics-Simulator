package models;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * This class creates a drawing of the circle aperture
 */
public class CircleApertureDrawing extends StackPane {
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
     * The Aperture.
     */
    private Circle aperture = new Circle();


    /**
     * constructor that creates a circle aperture drawing with proper diameter and color according to wavelength
     *
     * @param mmDiameter   diameter of opening in millimeters
     * @param mmWavelength wavelength of light in millimeters
     */
    public CircleApertureDrawing(double mmDiameter, double mmWavelength){
        this.mmDiameter = mmDiameter;
        this.mmWavelength = mmWavelength;
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        aperture.setRadius(mmDiameter*PIXELSTOMM);
        aperture.setFill(WavelengthToColor.getColor(mmWavelength,1));
        getChildren().add(aperture);

    }


    /**
     * getter for diameter
     *
     * @return circle hole diameter in millimeters
     */
    public double getMmDiameter() {
        return mmDiameter;
    }


    /**
     * setter for diameter that updates the drawing
     *
     * @param mmDiameter the mm diameter
     */
    public void setMmDiameter(double mmDiameter) {
        this.mmDiameter = mmDiameter;
        aperture.setRadius(mmDiameter*PIXELSTOMM);
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
     * setter fot wavelength that updates drawing color
     *
     * @param mmWavelength wavelength in millimeters
     */
    public void setMmWavelength(double mmWavelength) {
        this.mmWavelength = mmWavelength;
        aperture.setFill(WavelengthToColor.getColor(mmWavelength,1));
    }

    /**
     * Get color paint.
     *
     * @return the paint
     */
    public Paint getColor(){
        return aperture.getFill();
    }
}

package models;


import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 * The type Grating aperture drawing.
 */
public class GratingApertureDrawing extends StackPane {
    /**
     * The Mm wavelength.
     */
    private double mmWavelength;
    /**
     * The Line density.
     */
    private double lineDensity;
    /**
     * The Lines.
     */
    private Group lines = new Group();

    /**
     * Instantiates a new Grating aperture drawing.
     *
     * @param mmWavelength the mm wavelength
     * @param lineDensity  the line density
     */
    public GratingApertureDrawing(double mmWavelength, double lineDensity){
        this.mmWavelength = mmWavelength;
        this.lineDensity = lineDensity;
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        makeGroup();
        getChildren().add(lines);
    }

    /**
     * Make group.
     */
    public void makeGroup(){
        double displayNum = lineDensity;
        if (displayNum>100){
            displayNum = 100;
        }
        lines.getChildren().clear();
        for(int i=1; i<=displayNum*2; i+=2){
            Line line1 = new Line(i, 0, i, 100);
            line1.setStroke(WavelengthToColor.getColor(mmWavelength,1));
            lines.getChildren().add(line1);
        }

    }

    /**
     * Sets mm wavelength.
     *
     * @param mmWavelength the mm wavelength
     */
    public void setMmWavelength(double mmWavelength) {
        this.mmWavelength = mmWavelength;
        makeGroup();
    }

    /**
     * Sets line density.
     *
     * @param lineDensity the line density
     */
    public void setLineDensity(double lineDensity) {
        this.lineDensity = lineDensity;
        makeGroup();
    }

    /**
     * Gets mm wavelength.
     *
     * @return the mm wavelength
     */
    public double getMmWavelength() {
        return mmWavelength;
    }

    /**
     * Gets line density.
     *
     * @return the line density
     */
    public double getLineDensity() {
        return lineDensity;
    }

    /**
     * Get color paint.
     *
     * @return the paint
     */
    public Paint getColor(){return WavelengthToColor.getColor(mmWavelength,1);}
}

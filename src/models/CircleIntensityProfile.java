package models;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;

/**
 * The CircleIntensityProfile class creates a JavaFX node that contains a plot of the central-line intensity profile
 */
public class CircleIntensityProfile extends StackPane {
    /**
     * The Resolution.
     */
    private final int RESOLUTION = 20;
    /**
     * The Mm diameter.
     */
    private double mmDiameter;
    /**
     * The Mm wavelength.
     */
    private double mmWavelength;
    /**
     * The X axis.
     */
    private NumberAxis xAxis = new NumberAxis();
    /**
     * The Y axis.
     */
    private NumberAxis yAxis = new NumberAxis();
    /**
     * The Line chart.
     */
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    /**
     * The Series.
     */
    private XYChart.Series series = new XYChart.Series();


    /**
     * constructor for the CircleIntensityProfile that establishes sets up the axes and plot features in addition to
     * plotting initial parameters.
     *
     * @param diameter   diameter of aperture in millimeters
     * @param wavelength wavelength of aperture in millimeters
     */
    public CircleIntensityProfile(double diameter, double wavelength){
        mmDiameter = diameter;
        mmWavelength = wavelength;
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        xAxis.setLabel("Radians");
        yAxis.setLabel("Relative Intensity");
        lineChart.getData().add(series);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(1.1);
        yAxis.setTickUnit(.1);
        plotIntensity();
        getChildren().add(lineChart);
    }


    /**
     * computeRelativeIntensity
     *
     * @param angle diffraction angle in radians
     * @return double representing relative light intensity at the given angle
     */
    private double computeRelativeIntensity(double angle){
        double beta = (Math.PI * mmDiameter * Math.sin(angle))/ mmWavelength;
        double intensity = Math.pow((2 * SpecialFunction.j1(beta))/beta, 2);
        //System.out.printf("%f", intensity);
        return intensity;
    }


    /**
     * plotIntensity updates the chart with the proper central-line intensity profile using the set mmDiameter and
     * mmWavelength fields. It also updates the plot line color to correspond with the wavelength in visible light
     */
    private void plotIntensity(){
        series.getData().clear();
        double xMin = computeXMin(mmDiameter, mmWavelength);
        double xMax = computeXMax(mmDiameter, mmWavelength);
        double step = computeStep(mmDiameter, mmWavelength);
        for(double x = xMin; x <= xMax; x += step){
            //System.out.printf("%f, %f\n", x, computeRelativeIntensity(x));
            series.getData().add(new XYChart.Data<Number, Number>(x, computeRelativeIntensity(x)));
        }
        //System.out.printf("\n\n\n\n");
        lineChart.setStyle("CHART_COLOR_1: " + WavelengthToColor.getHex(mmWavelength, 1.0) + ";");



    }

    /**
     * computes an appropriate maximum angle value for an intensity plot series based on diameter and wavelength, to
     * ensure a nicely scaled graph
     *
     * @param diameter   diameter of aperture in millimeters
     * @param wavelength wavelength of light in millimeters
     * @return double double
     */
    private double computeXMax(double diameter, double wavelength){
        return (wavelength * 4) / diameter;
    }


    /**
     * computes an appropriate minimum angle value for an intensity plot series based on diameter and wavelength, to
     * ensure a nicely scaled graph
     *
     * @param diameter   diameter of aperture in millimeters
     * @param wavelength wavelength of light in millimeters
     * @return double double
     */
    private double computeXMin(double diameter, double wavelength){
        return -1 * computeXMax(diameter, wavelength);
    }


    /**
     * computes an appropriate angle step value for an intensity plot series based on diameter and wavelength, to ensure
     * a nicely scaled graph
     *
     * @param diameter   diameter of aperture in millimeters
     * @param wavelength wavelength of light in millimeters
     * @return double double
     */
    private double computeStep(double diameter, double wavelength){
        return wavelength / (diameter * RESOLUTION);
    }


    /**
     * setter for the aperture diameter parameter that then updates the intensity plot
     *
     * @param diameter new diameter of aperture in millimeters
     */
    public void setMmDiameter(double diameter){
        mmDiameter = diameter;
        plotIntensity();
    }


    /**
     * setter for the laser wavelength that then updates the intensity plot
     *
     * @param wavelength new wavelength of light in millimeters
     */
    public void setMmWavelength(double wavelength){
        mmWavelength = wavelength;
        plotIntensity();
    }

    /**
     * getter for wavelength
     *
     * @return wavelength in millimeters
     */
    public double getMmWavelength() {
        return mmWavelength;
    }
}

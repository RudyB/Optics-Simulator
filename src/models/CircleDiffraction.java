package models;

/**
 * This class sets up a circular aperture diffraction experiment and has functions to compute the distance between
 * angles and the distance between different orders of diffraction
 */
public class CircleDiffraction {
    /**
     * The Bessel zeroes.
     */
    private final double[] besselZeroes = {3.8317, 7.0156, 10.1735, 13.3237, 16.4706};
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
     * constructor sets up the experiment
     *
     * @param mmDiameter       diameter of circular aperture in millimeters
     * @param mmWavelength     diameter of wavelength in nanometers
     * @param mmScreenDistance distance from aperture to screen in millimeters
     */
    public CircleDiffraction(double mmDiameter, double mmWavelength, double mmScreenDistance){
        this.mmDiameter = mmDiameter;
        this.mmWavelength = mmWavelength;
        this.mmScreenDistance = mmScreenDistance;
    }

    /**
     * computes the diffraction angle of the nth order light minima
     *
     * @param nthDiffractionOrder int - order of diffraction (1 being the Airy disk)
     * @return double - angle of diffraction in radians
     */
    public double getNthDiffractionAngle(int nthDiffractionOrder) {
        if(nthDiffractionOrder <1 || nthDiffractionOrder >5){
            throw new IndexOutOfBoundsException("Only diffraction orders 1-5 supported");
        }
        double factor = besselZeroes[nthDiffractionOrder-1] / Math.PI;
        return (factor * mmWavelength)/ mmDiameter;

    }

    /**
     * computes the radius of the nth order light minima
     *
     * @param nthDiffractionOrder int - order of diffraction (1 being the Airy disk)
     * @return double - distance in millimeters
     */
    public double getNthDiffractionRadius(int nthDiffractionOrder) {
        return getNthDiffractionAngle(nthDiffractionOrder) * mmScreenDistance;
    }

    /**
     * gets radius of airys disk which is the 1st order diffraction radius
     *
     * @return radius in mm
     */
    public double getAirysRadius(){
        return getNthDiffractionRadius(1);
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
     * setter for diameter
     *
     * @param mmDiameter diameter in millimeters
     */
    public void setMmDiameter(double mmDiameter) {
        this.mmDiameter = mmDiameter;
    }


    /**
     * getter for wavelength
     *
     * @return wavlength in milimeters
     */
    public double getMmWavelength() {
        return mmWavelength;
    }

    /**
     * setter for wavelength
     *
     * @param mmWavelength in millimeters
     */
    public void setMmWavelength(double mmWavelength) {
        this.mmWavelength = mmWavelength;
    }


    /**
     * getter for distance from aperture to screen
     *
     * @return distance in millimeters
     */
    public double getMmScreenDistance() {
        return mmScreenDistance;
    }


    /**
     * setter for distance from aperture to screen
     *
     * @param mmScreenDistance distance in millimeters
     */
    public void setMmScreenDistance(double mmScreenDistance) {
        this.mmScreenDistance = mmScreenDistance;
    }
}

package models;

/**
 * This class sets up a circular aperture diffraction experiment and has functions to compute the distance between
 * angles and the distance between different orders of diffraction
 */
public class DiffractionGrating {
    /**
     * The Mm wavelength.
     */
    private double mmWavelength;
    /**
     * The Mm screen distance.
     */
    private double mmScreenDistance;
    /**
     * The Line density.
     */
    private double lineDensity;
    /**
     * The Slit separation.
     */
    private double slitSeparation;


    /**
     * constructor for grating experiment
     *
     * @param mmWavelength     wavelength of light source in millimeteres
     * @param mmScreenDistance distance from screen to aperture in millimeters
     * @param lineDensity      slits per millimeter
     */
    public DiffractionGrating(double mmWavelength, double mmScreenDistance, double lineDensity){
        this.mmWavelength = mmWavelength;
        this.mmScreenDistance = mmScreenDistance;
        this.lineDensity = lineDensity;
        this.slitSeparation = calculateSlitSeperation();
    }


    /**
     * calculates the distance between slits
     *
     * @return distance in millimeters
     */
    public double calculateSlitSeperation(){
        double separation = (1.0/lineDensity);
        this.slitSeparation = separation;
        return separation;
    }


    /**
     * computes the diffraction angle of the nth order light maxima
     *
     * @param nthDiffractionOrder int - order of diffraction
     * @return double - angle of diffraction in radians
     */
    public double getNthDiffractionAngle(int nthDiffractionOrder) {
        if(nthDiffractionOrder <1){
            throw new IndexOutOfBoundsException("Diffraction order must be 1 or greater");
        }
        return ((double)nthDiffractionOrder * mmWavelength) / slitSeparation;
    }


    /**
     * computes the distance of the nth order light maxima
     *
     * @param nthDiffractionOrder int - order of diffraction
     * @return double - distance in millimeters
     */
    public double getNthDiffractionDistance(int nthDiffractionOrder) {
        return getNthDiffractionAngle(nthDiffractionOrder) * mmScreenDistance;
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
     * setter for wavelength
     *
     * @param mmWavelength wavelength in millimeters
     */
    public void setMmWavelength(double mmWavelength) {
        this.mmWavelength = mmWavelength;
    }

    /**
     * getter for screen distance from grate
     *
     * @return distance in millimeters
     */
    public double getMmScreenDistance() {
        return mmScreenDistance;
    }

    /**
     * setter for screen distance from grate
     *
     * @param mmScreenDistance distance in millimeters
     */
    public void setMmScreenDistance(double mmScreenDistance) {
        this.mmScreenDistance = mmScreenDistance;
    }


    /**
     * getter for line density
     *
     * @return slits per millimeter
     */
    public double getLineDensity() {
        return lineDensity;
    }

    /**
     * setter for line density that updates slit separation
     *
     * @param lineDensity slits per millimeter
     */
    public void setLineDensity(double lineDensity) {
        this.lineDensity = lineDensity;
        calculateSlitSeperation();
    }


}

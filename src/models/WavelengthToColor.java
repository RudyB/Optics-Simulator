package models;

import javafx.scene.paint.Color;

/**
 * This class has static functions that convert a wavelength in mm to a JavaFX color representation or a Hex
 * representation. Based on an algorithm from http://www.efg2.com/Lab/ScienceAndEngineering/Spectra.htm
 */
public class WavelengthToColor {

    /**
     * getColor takes an input in millimeters and returns a JavaFX color object with RGB values corresponding to that
     * wavelength
     *
     * @param wavelength wavelength in millimeters
     * @param opacity    opacity from 0.0 to 1.0
     * @return javafx.scene.paint.Color color
     */
    public static Color getColor(double wavelength, double opacity) {
        wavelength = wavelength * 1000000.0;
        double Gamma = 0.80;
        int IntensityMax = 255;
        double red, green, blue, factor;

        if ((wavelength >= 380) && (wavelength < 440)) {
            red = -(wavelength - 440.0) / (440 - 380);
            green = 0.0;
            blue = 1.0;
        } else if ((wavelength >= 440) && (wavelength < 490)) {
            red = 0.0;
            green = (wavelength - 440.0) / (490 - 440);
            blue = 1.0;
        } else if ((wavelength >= 490) && (wavelength < 510)) {
            red = 0.0;
            green = 1.0;
            blue = -(wavelength - 510.0) / (510 - 490);
        } else if ((wavelength >= 510) && (wavelength < 580)) {
            red = (wavelength - 510) / (580 - 510);
            green = 1.0;
            blue = 0.0;
        } else if ((wavelength >= 580) && (wavelength < 645)) {
            red = 1.0;
            green = -(wavelength - 645.0) / (645 - 580);
            blue = 0.0;
        } else if ((wavelength >= 645) && (wavelength < 781)) {
            red = 1.0;
            green = 0.0;
            blue = 0.0;
        } else {
            red = 0.0;
            green = 0.0;
            blue = 0.0;
        }
        // Let the intensity fall off near the vision limits
        if ((wavelength >= 380) && (wavelength < 420)) {
            factor = 0.3 + 0.7 * (wavelength - 380) / (420 - 380);
        } else if ((wavelength >= 420) && (wavelength < 701)) {
            factor = 1.0;
        } else if ((wavelength >= 701) && (wavelength < 781)) {
            factor = 0.3 + 0.7 * (780 - wavelength) / (780 - 700);
        } else {
            factor = 0.0;
        }
        if (red != 0) {
            red = (IntensityMax * Math.pow(red * factor, Gamma)) / 255.0;
        }
        if (green != 0) {
            green = (IntensityMax * Math.pow(green * factor, Gamma)) / 255.0;
        }
        if (blue != 0) {
            blue = (IntensityMax * Math.pow(blue * factor, Gamma)) / 255.0;
        }
        //System.out.printf("%f, %f, %f,", red, green, blue);
        return new Color(red, green, blue, opacity);
    }

    /**
     * getHex takes an wavelength in millimeters and returns a String hex code for the color corresponding to that
     * wavelength
     *
     * @param wavelength wavelength in millimeters
     * @param opacity    the opacity
     * @return java.lang.String string
     */
    public static String getHex(double wavelength, double opacity){
        Color color = getColor(wavelength, opacity);
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }



}

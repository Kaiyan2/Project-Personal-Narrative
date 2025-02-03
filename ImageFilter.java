import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  /* 
   * Constructor to initialize ImageFilter object with a given image filename.
   * This calls the constructor of the superclass (ImagePlus) with the provided filename.
   */
  public ImageFilter(String filename) {
    super(filename);  // Calls the superclass constructor with the filename
  }

  /* 
   * Method to apply a colorize effect to the image.
   * It loops through each pixel in the image, calculates the average color, 
   * and then applies a specific color depending on the average color value.
   */
  public void colorize() {
    Pixel[][] pixels = getImagePixels();  // Get the pixel array of the image

    // Loop through each pixel in the image
    for (Pixel[] row : pixels) {
      for (Pixel currentPixel : row) {
        // Calculate the average color of the current pixel
        int avgColor = (currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen()) / 3;

        // Apply a color based on the average color value
        if (avgColor < 85) {
          currentPixel.setRed(255);    // Set pixel to red
          currentPixel.setGreen(0);    // Set pixel green to 0
          currentPixel.setBlue(0);     // Set pixel blue to 0
        } else if (avgColor < 170) {
          currentPixel.setRed(0);      // Set pixel red to 0
          currentPixel.setGreen(255);  // Set pixel green to 255
          currentPixel.setBlue(0);     // Set pixel blue to 0
        } else {
          currentPixel.setRed(0);      // Set pixel red to 0
          currentPixel.setGreen(0);    // Set pixel green to 0
          currentPixel.setBlue(255);   // Set pixel blue to 255
        }
      }
    }
  }

  /* 
   * Method to apply a negative effect to the image.
   * For each pixel, it inverts the red, green, and blue values by subtracting them from 255.
   */
  public void makeNegative() {
    Pixel[][] x = getImagePixels();  // Get the pixel array of the image
    
    // Loop through each pixel in the image
    for (int row = 0; row < x.length; row++) {
      for (int col = 0; col < x[0].length; col++) {
        Pixel currentPixel = x[row][col];
        
        // Get the current red, green, and blue values of the pixel
        int currentRedPixel = currentPixel.getRed();
        int currentGreenPixel = currentPixel.getGreen();
        int currentBluePixel = currentPixel.getBlue();
        
        // Invert the color values by subtracting each color from 255
        currentPixel.setRed(255 - currentRedPixel);
        currentPixel.setGreen(255 - currentGreenPixel);
        currentPixel.setBlue(255 - currentBluePixel);
      }
    }
  }

  /* 
   * Method to mirror the image vertically.
   * This swaps the left side and right side pixels to create a mirror effect.
   */
  public void mirrorVertical() {
    Pixel[][] x = getImagePixels();  // Get the pixel array of the image

    // Loop through each row of pixels
    for (int row = 0; row < x.length; row++) {
      // Loop through each column on the left side of the image
      for (int col = 0; col < x[0].length / 2; col++) {
        // Get the left and right pixels in the row
        Pixel leftSide = x[row][col];
        Pixel rightSide = x[row][x[0].length - col - 1];

        // Set the color of the left side pixel to match the right side
        leftSide.setColor(rightSide.getColor());
      }
    }
  }

  /* 
   * Method to sharpen the image.
   * For each pixel, it calculates the difference in color values between the pixel and its neighboring pixels,
   * and adjusts the pixel color to make the image appear sharper.
   */
  public void sharpen() {
    Pixel[][] pixels = getImagePixels();  // Get the pixel array of the image

    // Loop through the image, avoiding the edges
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];

        // Calculate the difference between the current pixel and its upper-left neighbor
        int redDiff = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
        int greenDiff = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
        int blueDiff = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
        
        // Calculate the average difference in color
        int averageDiff = (redDiff + greenDiff + blueDiff) / 3;

        // Apply the difference to the current pixel
        int newRed = currentPixel.getRed() + averageDiff;
        int newGreen = currentPixel.getGreen() + averageDiff;
        int newBlue = currentPixel.getBlue() + averageDiff;

        // Ensure that the color values don't exceed 255
        if (newRed > 255) {
          newRed = 255;
        }

        if (newGreen > 255) {
          newGreen = 255;
        }

        if (newBlue > 255) {
          newBlue = 255;
        }

        // Set the new color values for the pixel
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
}
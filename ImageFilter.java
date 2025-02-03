import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  // Constructor to initialize the ImageFilter with a filename
  public ImageFilter(String filename) {
    super(filename);
  }

  // Method to colorize the image based on average pixel color
  public void colorize() {
    Pixel[][] pixels = getImagePixels();

    // Iterate over each row and pixel in the image
    for (Pixel[] row : pixels) {
      for (Pixel currentPixel : row) {

        // Calculate average color of the pixel
        int avgColor = (currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen()) / 3;

        // Colorize based on the average color value
        if (avgColor < 85) {
          currentPixel.setRed(255);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0); // Red
        } else if (avgColor < 170) {
          currentPixel.setRed(0);
          currentPixel.setGreen(255);
          currentPixel.setBlue(0); // Green
        } else {
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
          currentPixel.setBlue(255); // Blue
        }
      }
    }
  }

  // Method to invert the colors of the image (negative effect)
  public void makeNegative() {
    Pixel[][] x = getImagePixels();
    
    // Iterate through each pixel to invert its color
    for (int row = 0; row < x.length; row++) {
      for (int col = 0; col < x[0].length; col++) {
        Pixel currentPixel = x[row][col];
        
        // Get current color values
        int currentRedPixel = currentPixel.getRed();
        int currentGreenPixel = currentPixel.getGreen();
        int currentBluePixel = currentPixel.getBlue();
        
        // Invert the color values
        currentPixel.setRed(255 - currentRedPixel);
        currentPixel.setGreen(255 - currentGreenPixel);
        currentPixel.setBlue(255 - currentBluePixel);
      }
    }
  }

  // Method to create a vertical mirror image
  public void mirrorVertical() {
    Pixel[][] x = getImagePixels();
    
    // Iterate through each row and mirror the image vertically
    for (int row = 0; row < x.length; row++) {
      for (int col = 0; col < x[0].length / 2; col++) {
        Pixel leftSide = x[row][col];
        Pixel rightSide = x[row][x[0].length - col - 1];

        // Set the left side pixel color to the right side pixel's color
        leftSide.setColor(rightSide.getColor());
      }
    }
  }

  // Method to sharpen the image by calculating pixel differences
  public void sharpen() {
    Pixel[][] pixels = getImagePixels();

    // Iterate through pixels (excluding borders)
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];
        
        // Calculate the difference with the neighboring pixel
        int redDiff = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
        int greenDiff = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
        int blueDiff = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
        
        // Calculate the average color difference
        int averageDiff = (redDiff + greenDiff + blueDiff) / 3;

        // Adjust the pixel color based on the difference
        int newRed = currentPixel.getRed() + averageDiff;
        int newGreen = currentPixel.getGreen() + averageDiff;
        int newBlue = currentPixel.getBlue() + averageDiff;

        // Ensure the new color values don't exceed the maximum value (255)
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }
        
        // Set the sharpened color back to the pixel
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

  // Method to apply a blue filter to the image
  public void makeBlue() {
    Pixel[][] x = getImagePixels();
    
    // Iterate through each pixel and increase the blue component
    for (int row = 0; row < x.length; row++) {
      for (int col = 0; col < x[0].length; col++) {
        Pixel currentPixel = x[row][col];
        
        // Get current pixel color values
        int currentGreenPixel = currentPixel.getGreen();
        int currentRedPixel = currentPixel.getRed();
        int currentBluePixel = currentPixel.getBlue();
        
        // Increase the blue component
        currentPixel.setBlue(currentBluePixel + 150);

        // Ensure the blue component does not exceed 255
        if (currentPixel.getBlue() > 255) {
          currentPixel.setBlue(255);
        }
      }
    }
  }
}
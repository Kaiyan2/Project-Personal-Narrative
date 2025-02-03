import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {
  // Instance variable to store average points for players
  private double[][] avgPoints;

  // Constructor with avgPoints parameter to initialize the instance variable
  public MyStory(double[][] avgPoints) {
    this.avgPoints = avgPoints;
  }

  // Default constructor with example data for avgPoints
  public MyStory() {
    // Example data for average points per player
    this.avgPoints = new double[][] { {10, 20}, {15, 25} };
  }

  // Getter method to return the avgPoints
  public double[][] getavgPoints() {
    return avgPoints;
  }

  // Method to calculate the average of all points in avgPoints
  public double calcAveragePoints() {
    double total = 0.0;
    int numElements = avgPoints.length * avgPoints[0].length;
    // Loop through each element of the 2D array and sum the points
    for (int row = 0; row < avgPoints.length; row++) {
      for (int col = 0; col < avgPoints[0].length; col++) {
        total += avgPoints[row][col];
      }
    }
    // Return the average by dividing the total sum by the number of elements
    return total / numElements;
  }

  // Method to draw the scene for Steph Curry
  public void drawStephScene() {
    clear("navy");  // Set the background color to navy
    setTextHeight(30);  // Set the text height
    setTextColor("white");  // Set text color to white
    setTextStyle(Font.MONO, FontStyle.BOLD);  // Set text style to bold and mono
    drawText("Steph Curry", 100, 35);  // Draw the text "Steph Curry" at the specified position
    ImageFilter stephCurry = new ImageFilter("stephCurry.jpg");  // Load the image of Steph Curry
    drawImage(stephCurry, 70, 50, 250);  // Draw the image of Steph Curry
    pause(1.0);  // Pause for 1 second
    stephCurry.colorize();  // Apply colorization filter to the image
    drawImage(stephCurry, 70, 50, 250);  // Draw the modified image
    pause(1.0);  // Pause for 1 second
  }

  // Method to draw the scene for LeBron James
  public void drawLebronScene() {
    clear("white");  // Set the background color to white
    setTextHeight(30);  // Set the text height
    setTextColor("black");  // Set text color to black
    setTextStyle(Font.MONO, FontStyle.BOLD);  // Set text style to bold and mono
    drawText("LeBron James", 100, 45);  // Draw the text "LeBron James"
    ImageFilter lebronJames = new ImageFilter("lebronJames.jpg");  // Load the image of LeBron James
    drawImage(lebronJames, 55, 80, 300);  // Draw the image of LeBron James
    pause(1.0);  // Pause for 1 second
    lebronJames.makeNegative();  // Apply negative filter to the image
    drawImage(lebronJames, 55, 80, 300);  // Draw the modified image
    pause(1.0);  // Pause for 1 second
  }

  // Method to draw the scene for Kevin Durant
  public void drawKDScene() {
    clear("red");  // Set the background color to red
    setTextHeight(30);  // Set the text height
    setTextColor("black");  // Set text color to black
    setTextStyle(Font.MONO, FontStyle.BOLD);  // Set text style to bold and mono
    drawText("Kevin Durant", 100, 45);  // Draw the text "Kevin Durant"
    ImageFilter kevinDurant = new ImageFilter("kevinDurant.jpg");  // Load the image of Kevin Durant
    drawImage(kevinDurant, 50, 80, 300);  // Draw the image of Kevin Durant
    pause(1.0);  // Pause for 1 second
    kevinDurant.mirrorVertical();  // Apply a vertical mirror effect to the image
    drawImage(kevinDurant, 50, 80, 300);  // Draw the modified image
    pause(1.0);  // Pause for 1 second
  }

  // Method to draw the scene for Anthony Edwards
  public void drawAntScene() {
    clear("navy");  // Set the background color to navy
    setTextHeight(30);  // Set the text height
    setTextColor("white");  // Set text color to white
    setTextStyle(Font.MONO, FontStyle.BOLD);  // Set text style to bold and mono
    drawText("Anthony Edwards", 70, 40);  // Draw the text "Anthony Edwards"
    ImageFilter anthonyEdwards = new ImageFilter("anthonyEdwards.jpg");  // Load the image of Anthony Edwards
    drawImage(anthonyEdwards, 80, 55, 230);  // Draw the image of Anthony Edwards
    pause(1.0);  // Pause for 1 second
    anthonyEdwards.makeBlue();  // Apply a blue tint to the image
    drawImage(anthonyEdwards, 80, 55, 230);  // Draw the modified image
    pause(1.0);  // Pause for 1 second
  }

  // Method to draw the scene for Joel Embiid
  public void drawEmbiidScene() {
    clear("white");  // Set the background color to white
    setTextHeight(30);  // Set the text height
    setTextColor("black");  // Set text color to black
    setTextStyle(Font.MONO, FontStyle.BOLD);  // Set text style to bold and mono
    drawText("Joel Embiid", 100, 45);  // Draw the text "Joel Embiid"
    ImageFilter joelEmbiid = new ImageFilter("joelEmbiid.jpg");  // Load the image of Joel Embiid
    drawImage(joelEmbiid, 55, 80, 300);  // Draw the image of Joel Embiid
    pause(1.0);  // Pause for 1 second
    joelEmbiid.sharpen();  // Apply a sharpening effect to the image
    drawImage(joelEmbiid, 55, 80, 300);  // Draw the modified image
    pause(1.0);  // Pause for 1 second
  }

  // Intro scene method to show the average points and the team photo
  public void drawIntroScene() {
    clear("navy");  // Set the background color to navy

    // Set text style for the intro scene
    setTextHeight(18);
    setTextColor("white"); 
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // Calculate the average points using the calcAveragePoints method
    double averagePoints = calcAveragePoints();

    // Display the average points and other text on screen
    drawText("Team USA: avg ppg per player " + averagePoints, 10, 40);

    // Load and display the team USA photo
    ImageFilter teamUSAPhoto = new ImageFilter("teamUSAPhoto.jpg");
    drawImage(teamUSAPhoto, 30, 100, 350);  // Draw the image of Team USA
    pause(1.0);  // Pause for 1 second
    drawImage(teamUSAPhoto, 30, 100, 350);  // Draw the same image again (or for effect)
    pause(1.0);  // Pause for 1 second
  }
}
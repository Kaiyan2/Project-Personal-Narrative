import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create an instance of the MyStory scene, which contains all the scenes to be drawn
    MyStory scene = new MyStory();

    /* 
     * Define a 2D array for players categorized as "Starters" and "Bench".
     * This will help organize the players and their corresponding positions.
     */
    String[][] players = {
      {"Starters", "Steph Curry", "Anthony Edwards", "Kevin Durant", "Lebron James", "Joel Embiid"},
      {"Bench", "Bam Adebayo", "Devin Booker", "Anthony Davis", "Tyrese Haliburton", "Jrue Holiday", "Jayson Tatum", "Derrick White"}
    };

    /* 
     * Define a 2D array for average points per player (this is just example data).
     * The values could be dynamically generated or retrieved from a database in a real-world application.
     */
    double[][] avgPoints = {
      {14.8, 14.2, 13.8, 12.8, 11.7, 11.2, 8.3, 7.6, 6.0, 5.3, 3.8, 2.7}
    };

    // Load an image of Steph Curry to be used in the scenes
    ImageFilter image = new ImageFilter("stephCurry.jpg");

    // Main sequence of drawing scenes and playing sound effects
    scene.drawIntroScene();  // Draw the introductory scene with team information
    scene.playSound("applause3.wav");  // Play an applause sound after the intro
    scene.drawStephScene();  // Draw the scene for Steph Curry
    scene.playSound("applause3.wav");  // Play an applause sound after Steph Curry scene
    scene.drawLebronScene();  // Draw the scene for LeBron James
    scene.playSound("applause3.wav");  // Play an applause sound after LeBron scene
    scene.drawKDScene();  // Draw the scene for Kevin Durant
    scene.playSound("applause3.wav");  // Play an applause sound after KD scene
    scene.drawEmbiidScene();  // Draw the scene for Joel Embiid
    scene.playSound("applause3.wav");  // Play an applause sound after Embiid scene
    scene.drawAntScene();  // Draw the scene for Anthony Edwards

    // After all the scenes have been drawn and applause sounds have been played,
    // the entire sequence of scenes is displayed in the theater.
    Theater.playScenes(scene);  // Starts the theater and shows all scenes in the correct order
  }
}

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *  This file can be used to draw simple pictures.  Just fill in
 *  the definition of drawPicture with the code that draws your picture.
 */
public class SimpleGraphicsStarter extends Application {

    /**
     * Draws a picture.  The parameters width and height give the size 
     * of the drawing area, in pixels.  
     */
    public void drawPicture(GraphicsContext g, int width, int height) {
    	
        	

    } // end drawPicture()

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public void start(Stage stage) {
        int width = 800;   // The width of the image.  You can modify this value!
        int height = 600;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Graphics"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
    } 

    public static void main(String[] args) {
        launch();
    }

} // end SimpleGraphicsStarter

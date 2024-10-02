package thiagofx.testes;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class ExibirJanela extends Application {

	private CircleInfo[] circleData;
	
	private void drawFrame(GraphicsContext g, int frameNumber, int width, int height) {
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, width, height);
		Random randGen = new Random();
		if (circleData == null) {
			circleData = new CircleInfo[5];
			
			for (int i=0; i < circleData.length; i++) {
				circleData[i] = new CircleInfo(
									randGen.nextInt(width),
									randGen.nextInt(height),
									randGen.nextInt(100));
			}
		}
		
		for (int i=0; i < circleData.length; i++) {
			circleData[i].radius++;
			circleData[i].draw(g);
			
			if (Math.random() < 0.005 || circleData[i].radius > 100) {
				circleData[i] = new CircleInfo(
									randGen.nextInt(width),
									randGen.nextInt(height),
									1 );
			}
		}
	}
	
	public void start(Stage pStage) {
		int width = 600;
		int height = 480;
		
		Canvas canvas = new Canvas(width, height);
		drawFrame(canvas.getGraphicsContext2D(), 0, width, height);
		
		BorderPane root = new BorderPane(canvas);
		root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
		
		Scene scene = new Scene(root);
		
		pStage.setTitle("Animação!!");
		pStage.setScene(scene);
		pStage.show();
		pStage.setResizable(true);
		
		AnimationTimer anim = new AnimationTimer() {
			private int frameNum;
			long previousFrameTime;
			
			public void handle(long time) {
				if(time - previousFrameTime > 0.95e9/60) {
					frameNum++;
					drawFrame(canvas.getGraphicsContext2D(), frameNum, width, height);
					previousFrameTime = time;
				}
			}
		};
		anim.start();
	}
	
	public static void main(String[] args) {
		launch();
	}

}

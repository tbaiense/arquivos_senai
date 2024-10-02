package thiagofx.testes;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class CircleInfo {
	public int radius;
	public int x,y;
	public Color color;
	
	public CircleInfo(int centerX, int centerY, int rad) {
		x = centerX;
		y = centerY;
		radius = rad;
		double red = Math.random();
		double green = Math.random();
		double blue = Math.random();
		
		color = new Color(red, green, blue, 0.4);
	}
	
	public void draw(GraphicsContext g) {
		g.setFill(color);
		g.fillOval(x - radius, y - radius, 2*radius, 2*radius);
		g.setStroke(Color.BLACK);
		g.strokeOval(x - radius, y - radius, 2*radius, 2*radius);
	}
}

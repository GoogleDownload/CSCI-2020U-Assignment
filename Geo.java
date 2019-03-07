import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;


public class Geo extends Application {
	
	//Initializing all variables 
	private double radius = 100.0;
	private Circle c = new Circle(250,250,radius);
	private Random rand = new Random();
	private int a1 = rand.nextInt(360);
	private int a2 = rand.nextInt(360);
	private int a3 = rand.nextInt(360);
	private double x1 = 250 + radius*Math.cos(a1);
	private double y1 = 250 + radius*Math.sin(a1);
	private double x2 = 250 + radius*Math.cos(a2);
	private double y2 = 250 + radius*Math.sin(a2);
	private double x3 = 250 + radius*Math.cos(a3);
	private double y3 = 250 + radius*Math.sin(a3);
	private double Radius = 10.0;
	private Circle[] circle = { new Circle(x1, y1, Radius), new Circle(x2, y2, Radius), new Circle(x3, y3, Radius) };
	private Line line1 = new Line();
	private Line line2 = new Line();
	private Line line3 = new Line();
	private Text[] text = { new Text(), new Text(), new Text() };

	@Override
	public void start(Stage primaryStage) {
		//Adding all elements to window/pane
		Pane pane = new Pane();
		makeLine();
		pane.getChildren().addAll(c, circle[0], circle[1], circle[2], line1, line2, line3, text[0], text[1], text[2]);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 550, 550);
		primaryStage.setResizable(false); //Not allowed to resize window created
		primaryStage.setTitle("Question 3"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		c.setFill(null); //Fills the circle with nothing
		c.setStroke(Color.BLACK); //Updates the lines to black since we made them null earlier
		//Setting the circle colour to red
		circle[0].setFill(Color.RED); 
		circle[1].setFill(Color.RED);
		circle[2].setFill(Color.RED);
		

		//Allows circle 0 to be moved and dragged around the circle
		circle[0].setOnMouseDragged(e -> {
			Point2D redCenter = new Point2D(c.getCenterX(), c.getCenterY());
			Point2D mouse = new Point2D(e.getX(), e.getY());
			Point2D centerToMouse = mouse.subtract(redCenter);
			Point2D centerToNewPoint = centerToMouse.normalize().multiply(c.getRadius());
			Point2D newPoint = centerToNewPoint.add(redCenter);
			circle[0].setCenterX(newPoint.getX());
			circle[0].setCenterY(newPoint.getY());
			
			if(circle[0].contains(e.getX(), e.getY())){
				circle[0].setCenterX(newPoint.getX());
				circle[0].setCenterY(newPoint.getY());
				makeLine();
			}

		});
		
		//Allows circle 1 to be moved and dragged around the circle
		circle[1].setOnMouseDragged(e -> {
			Point2D redCenter = new Point2D(c.getCenterX(), c.getCenterY());
			Point2D mouse = new Point2D(e.getX(), e.getY());
			Point2D centerToMouse = mouse.subtract(redCenter);
			Point2D centerToNewPoint = centerToMouse.normalize().multiply(c.getRadius());
			Point2D newPoint = centerToNewPoint.add(redCenter);
			circle[1].setCenterX(newPoint.getX());
			circle[1].setCenterY(newPoint.getY());
			
			if(circle[1].contains(e.getX(), e.getY())){
				circle[1].setCenterX(newPoint.getX());
				circle[1].setCenterY(newPoint.getY());
				makeLine();
			}

		});
		
		//Allows circle 2 to be moved and dragged around the circle
		circle[2].setOnMouseDragged(e -> {
			Point2D redCenter = new Point2D(c.getCenterX(), c.getCenterY());
			Point2D mouse = new Point2D(e.getX(), e.getY());
			Point2D centerToMouse = mouse.subtract(redCenter);
			Point2D centerToNewPoint = centerToMouse.normalize().multiply(c.getRadius());
			Point2D newPoint = centerToNewPoint.add(redCenter);
			circle[2].setCenterX(newPoint.getX());
			circle[2].setCenterY(newPoint.getY());
			
			if(circle[2].contains(e.getX(), e.getY())){
				circle[2].setCenterX(newPoint.getX());
				circle[2].setCenterY(newPoint.getY());
				makeLine();
			}
		});
	}

	//Makes and updates lines
	private void makeLine() {
		line1.setStartX(circle[0].getCenterX());
		line1.setStartY(circle[0].getCenterY());
		line1.setEndX(circle[1].getCenterX());
		line1.setEndY(circle[1].getCenterY());
		line2.setStartX(circle[0].getCenterX());
		line2.setStartY(circle[0].getCenterY());
		line2.setEndX(circle[2].getCenterX());
		line2.setEndY(circle[2].getCenterY());
		line3.setStartX(circle[1].getCenterX());
		line3.setStartY(circle[1].getCenterY());
		line3.setEndX(circle[2].getCenterX());
		line3.setEndY(circle[2].getCenterY());

		double x = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).distance(circle[1].getCenterX(), circle[1].getCenterY());
		double y = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).distance(circle[0].getCenterX(), circle[0].getCenterY());
		double z = new Point2D(circle[1].getCenterX(), circle[1].getCenterY()).distance(circle[0].getCenterX(), circle[0].getCenterY());
		double[] angle = new double[3];
		
		//Calculates angles
		angle[0] = Math.acos((x * x - y * y - z * z) / (-2 * y * z));
		angle[1] = Math.acos((y * y - x * x - z * z) / (-2 * x * z));
		angle[2] = Math.acos((z * z - y * y - x * x) / (-2 * x * y));

		//Displays angles
		for (int i = 0; i < 3; i++) {
			text[i].setX(circle[i].getCenterX());
			text[i].setY(circle[i].getCenterY() - radius);
			text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
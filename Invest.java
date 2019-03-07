import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Invest extends Application {
	private TextField InvAmount = new TextField(); //Investment amount textfield creation
	private TextField Years = new TextField(); //Number of years textfield creation
	private TextField AnnualInterest = new TextField(); //Annual interest rate textfield creation
	private TextField FutureVal = new TextField(); //Future value textfield creation
	private Button Button = new Button("Calculate"); //Calculate button creation

	@Override
	public void start(Stage primaryStage) {
		//Adjusting the positions of everything in the window/pane
		GridPane pane = new GridPane();
		pane.setVgap(5);
		pane.setHgap(5);
		pane.add(new Label("Investment Amount"), 0, 0);
		pane.add(InvAmount, 1, 0);
		pane.add(new Label("Years"), 0, 1);
		pane.add(Years, 1, 1);
		pane.add(new Label("Annual Interest Rate"), 0, 2);
		pane.add(AnnualInterest, 1, 2);
		pane.add(new Label("Future value"), 0, 3);
		pane.add(FutureVal, 1, 3);
		pane.add(Button, 1, 4);

		// Set UI properties
		pane.setAlignment(Pos.CENTER);
		InvAmount.setAlignment(Pos.BOTTOM_RIGHT);
		Years.setAlignment(Pos.BOTTOM_RIGHT);
		AnnualInterest.setAlignment(Pos.BOTTOM_RIGHT);
		FutureVal.setAlignment(Pos.BOTTOM_RIGHT);
		FutureVal.setEditable(false);
		GridPane.setHalignment(Button, HPos.RIGHT);
		pane.setPadding(new Insets(10, 10, 10, 10));

		// On button press, futureValue() function is called
		Button.setOnAction(e -> futureValue());

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Question 2"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	//Calculate the future value and display it
	public void futureValue() {
		double investmentAmount = Double.parseDouble(InvAmount.getText());
		double years = Double.parseDouble(Years.getText());
		double monthInterestRate = Double.parseDouble(AnnualInterest.getText()) / 12 / 100;

		double futureValue = investmentAmount * Math.pow(1 + monthInterestRate, years * 12);
		FutureVal.setText(String.format("$%.2f", futureValue));
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
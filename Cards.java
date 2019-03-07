import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public class Cards extends Application {
    @Override
    public void start(Stage primaryStage) {
    	//Pulling a random image from the folder containing them
        ArrayList<String> cards = new ArrayList<>();

        for (int i = 0; i < 58; i++) {
            cards.add(String.valueOf(i + 1));
        }

        java.util.Collections.shuffle(cards);

        ImageView img1 = new ImageView(new Image("file:///D:/Year2/SoftwareSys/Assignment/Cards/" + cards.get(0) + ".png"));
        ImageView img2 = new ImageView(new Image("file:///D:/Year2/SoftwareSys/Assignment/Cards/" + cards.get(1) + ".png"));
        ImageView img3 = new ImageView(new Image("file:///D:/Year2/SoftwareSys/Assignment/Cards/" + cards.get(2) + ".png"));

        HBox root = new HBox();

        root.getChildren().add(img1);
        root.getChildren().add(img2);
        root.getChildren().add(img3);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Question 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
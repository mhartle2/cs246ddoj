import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author marchartley
 */
public class Boldness extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
            
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,10,10));

        Label enterRunnable = new Label("Enter Runnable:");
        grid.add(enterRunnable, 0, 0, 70, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 25, 0, 70, 1);//, 5, 1);

        Label runnables = new Label("Runnables");
        grid.add(runnables, 14, 5, 30, 1);
        
        Label runningThreads = new Label("Running Threads");
        grid.add(runningThreads, 64, 5, 30, 1);

        ListView list1 = new ListView();
        grid.add(list1, 0, 6, 40, 10);
        
        ListView list2 = new ListView();
        grid.add(list2, 55, 6, 40, 10);
        
        Button start = new Button("Start");
        grid.add(start, 15, 17, 15, 1);
        
        Button stop = new Button("Stop");
        grid.add(stop, 70, 17, 15, 1);
        
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle("Boldness");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

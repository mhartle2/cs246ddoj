import javafx.application.Application;
import static javafx.application.Application.launch;
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
import javafx.stage.Stage;

/**
 *
 * @author marchartley
 */
public class Boldness extends Application {

    public static Boldness boldness = new Boldness();
    
    private static Stage primaryStage;
    public ListView list1;
    private static ListView<String> list2 = new ListView();
    
    static Boldness getInstance() {

            return boldness;
    }
    
     public Stage getPrimaryStage() {
        return boldness.primaryStage;
    }
    
    boolean shouldBeRunning() {
       
        String thread = Thread.currentThread().getName();
        boolean isRunning = list2.getItems().contains(thread);
        return isRunning;
        
    }
    
    void finished() {
        String thread = Thread.currentThread().getName();
        list2.getItems().remove(thread);
    }
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        this.primaryStage = primaryStage;
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,10,10,10));

        Label enterRunnable = new Label("Enter Runnable:");
        grid.add(enterRunnable, 0, 0, 70, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 25, 0, 70, 1);

        
        
        Label runnables = new Label("Runnables");
        grid.add(runnables, 14, 5, 30, 1);
        
        Label runningThreads = new Label("Running Threads");
        grid.add(runningThreads, 64, 5, 30, 1);

        list1 = new ListView();
        grid.add(list1, 0, 6, 40, 10);
        
        grid.add(list2, 55, 6, 40, 10);
        
        userTextField.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String name = userTextField.getText();
                try {
                    Class runnable = Class.forName("boldness." + name);
                    boolean isReallyRunnable = Runnable.class.isAssignableFrom(runnable);
                
                    if (isReallyRunnable && !list1.getItems().contains(name)) {
                        list1.getItems().add(name);
                        userTextField.clear();
                        userTextField.requestFocus();
                    }
                    else {
                        System.out.println("Class already listed");
                    }
                        
                }
                catch(Exception e) {
                    System.out.println("Not a class name");
                }
            }
        });
        
        Button start = new Button("Start");
        grid.add(start, 15, 17, 15, 1);
        
        start.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
            public void handle(ActionEvent event) {
                //list2.getItems().add(list1.getSelectedItem());
                String name = ("" + list1.getFocusModel().getFocusedItem());
                try {
                    Class runnable = Class.forName("boldness." + name);
                    boolean isReallyRunnable = Runnable.class.isAssignableFrom(runnable);

                    if (isReallyRunnable && list1.getFocusModel().getFocusedItem() != null) {
                        Object o = Class.forName("boldness." + name).newInstance();   
                        Runnable r = (Runnable)o;
                        Thread t = new Thread(r);
                        t.setName(name + t.getName());
                        list2.getItems().add(t.getName());
                        t.start();
                        
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
         
            }
        });
        
        Button stop = new Button("Stop");
        grid.add(stop, 70, 17, 15, 1);
        
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = ("" + list2.getFocusModel().getFocusedItem());
                if (list2.getFocusModel().getFocusedItem() != null) {
                    list2.getItems().remove(name);
                }
            }
        });
        
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle("Threads of Glory");
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

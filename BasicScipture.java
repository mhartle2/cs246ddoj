mport javafx.application.Application;
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

import javafx.stage.Stage;

/**
 *
 * @author Marc Hartley
 */
public class BasicScripture extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       GridPane grid = new GridPane();
            
       
       grid.setAlignment(Pos.TOP_LEFT);
                grid.setHgap(5);
                grid.setVgap(5);
                grid.setPadding(new Insets(10,10,10,10));
                
               // Text scenetitle = new Text("Welcome");
                //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                //grid.add(scenetitle, 0, 0, 2, 1);
                
                Label userName = new Label("Scripture");
                grid.add(userName, 0, 0);
                
                TextField userTextField = new TextField();
                grid.add(userTextField, 0, 1);
                
                Label pw = new Label("Scriptures");
                grid.add(pw, 2, 0);
                
                ListView table = new ListView();
                grid.add(table, 2,1,1,12);
                
               
                
                Button btn = new Button("Add to list");
                HBox hbBtn = new HBox(10);
                grid.add(btn, 1,1);
                
                Button sort = new Button("Sort the list");
                HBox sBtn = new HBox(10);
                grid.add(sort,3,1);
                
                sort.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){ 
                   table.getItems().sort(null);
                   }
                });
                
                Button remove = new Button("Remove selected");
                HBox rmBtn = new HBox(10);
                grid.add(remove, 3,2);
                
                remove.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){ 
                   // how do we remove items from the list
                       //table.getItems().remove(table.getSelectedItem());
                   }
                });
       
       
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String text = userTextField.getText();
                table.getItems().add(text);
                userTextField.clear();
                userTextField.requestFocus();
            }
        });
        
        
        Scene scene = new Scene(grid, 600, 500);
        
        primaryStage.setTitle("Favorite Scriptures Application");
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

package example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField tfa = new TextField();
        TextField tfb = new TextField();
        TextField tfc = new TextField();
        
        
        Button btn = new Button("bestimmen");
 
     
  
        VBox boxa = new VBox();
        
        boxa.getChildren().addAll(tfa, tfb, tfc, btn);
      
        boxa.setAlignment(Pos.CENTER);   //setzt in die Mitte
        boxa.setSpacing(40);
        boxa.setMargin(tfa, new Insets(0,70,0,70));
        boxa.setMargin(tfb, new Insets(0,70,0,70));
        boxa.setMargin(tfc, new Insets(0,70,0,70));
        
        
        
        btn.setOnAction(e -> {
        	int a = Integer.parseInt(tfa.getText());
        	int b = Integer.parseInt(tfb.getText());
        	int c = Integer.parseInt(tfc.getText());
        	
        	if (a == b && b == c) {
				System.out.println("gleichseitig & gleichschenklich");
			}
			else if(a == b || b == c || a == c) {
				System.out.println("gleichschenklich");
			}
			else {
				System.out.println("ungleichseitig");
				
			}
        	});
        
        Scene scene = new Scene(boxa,350,350);
        primaryStage.setScene(scene);
    
        primaryStage.setTitle("Triangle");
        primaryStage.show();
    }
}


package example;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	TextField aTextField = new TextField("1");
        TextField bTextField = new TextField("2");
        TextField cTextField = new TextField("3");

        // Wir verwenden eine GridPane für das Layout und ordnen die Label und Textfelder in diesem Raster an
        GridPane root = new GridPane();

        root.setVgap(20);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);

        root.add(new Text("a"), 0, 0);
        root.add(aTextField, 1,0);
        root.add(new Text("b"), 0, 1);
        root.add(bTextField, 1,1);
        root.add(new Text("c"), 0, 2);
        root.add(cTextField, 1,2);

        Text result = new Text();

        root.add(result, 0,3, 2, 1);

        // Dieser ChangeListener wird für alle drei Textfelder verwendet und aufgerufen, wenn sich der Text in den
        // Textfeldern ändert. Der ChangeListener wird als Lambda-Ausdruck definiert, der implizit konvertiert wird.
        ChangeListener<String> listener = (observableValue, oldValue, newValue) -> {
            try {
                int a = Integer.parseInt(aTextField.getText());
                int b = Integer.parseInt(bTextField.getText());
                int c = Integer.parseInt(cTextField.getText());
                if (a == b && b == c) {
                    result.setText("gleichseitig");
                    System.out.println("gleichseitig");
                } else if (a == b || a == c || b == c) {
                    result.setText("gleichschenklig");
                    System.out.println("gleichschenklig");
                } else {
                    result.setText("ungleichseitig");
                    System.out.println("ungleichseitig");
                }
            } catch (NumberFormatException e) {
                result.setText("ungueltig");
                System.out.println("ungueltig");
            }
        };
        aTextField.textProperty().addListener(listener);
        bTextField.textProperty().addListener(listener);
        cTextField.textProperty().addListener(listener);

        // Wir rufen den ChangeListener einmal initial auf, damit die Ausgabe am Anfang bereits stimmt
        listener.changed(aTextField.textProperty(), aTextField.getText(), aTextField.getText());

        // Größe des Fensters setzen und Fenster anzeigen
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}

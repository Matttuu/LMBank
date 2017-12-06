//Denne klasse bruges til at teste GUI

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    public void start(Stage primaryStage) throws Exception{
        //Indsæt stien til fxml-filen som parameter i getResource for at få vist den pågældende side
        Parent root = FXMLLoader.load(getClass().getResource("GUI/OpretKonto.fxml"));
        primaryStage.setTitle("LMBank GUI");
        primaryStage.setScene(new Scene(root, 1289, 807));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
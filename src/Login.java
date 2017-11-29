import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Login {

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;


    public void Login(ActionEvent event) throws Exception{

        DB_Statements stmts = new DB_Statements();



        try {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getText());


            if (stmts.checkLogin(username, password)) {
                System.out.println("\n>>> Login Success");
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("GUI/Forside.fxml"));
                primaryStage.setTitle("LMBank");
                primaryStage.setScene(new Scene(root, 1289, 807));
                primaryStage.show();

            } else {
                System.out.println("\n>>> Login Failed!");
            }
        } catch (Exception e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl meddelelse");
            alert.setHeaderText("Der opstod en fejl!");
            alert.setContentText("Ooops, der skete en fejl!");

            alert.showAndWait();
        }

    }
}

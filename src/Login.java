import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
                Parent root = FXMLLoader.load(getClass().getResource("forside.fxml"));
                primaryStage.setTitle("LMBank");
                primaryStage.setScene(new Scene(root, 1280, 809));
                primaryStage.show();

            } else {
                System.out.println("\n>>> Login Failed!");
            }
        } catch (Exception e1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }

    }
}

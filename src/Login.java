import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Denne klasse indeholder metoden Login, som er knyttet til login.fxml.
 * Login metoden gør brug af DB_Statements klassen hvor at metoden checkLogin er defineret.
 *
 * @author Daniel,Flenner, Mads, Mathias, Sebastian.
 * @version 1.0
 * @since December 2017
 */

public class Login extends Main {

    // Erklærer variabel
    @FXML
    private TextField txtUsername;

    // Erklærer variabel
    @FXML
    private PasswordField txtPassword;

    // Opretter metode login som tager imod et ActionEvent parameter ved navn event.
    public void Login(ActionEvent event) {

        // Opretter et nyt objekt af klassen DB_Statements
        DB_Statements stmts = new DB_Statements();

        /**
         * Starter en try-catch block som åbner en GUI hvor man kan logge ind, hvis username og password er rigtigt
         * så skifter den over til scenen Forside.fxml
         * Hvis username og password er forkert udskriver den en fejlmeddelelse.
         * Hvis tilfældet er at der skulle ske en helt tredje fejl, f.eks ingen internet adgang eller lign -
         * så bliver der fanget en Exception, og vist en fejlmeddelelse i en alert box.
         */
        try {
            // Erklærer 2 variabler.
            String username = txtUsername.getText();
            String password = new String(txtPassword.getText());


            if (stmts.checkLogin(username, password)) {
                System.out.println("\n>>> Login Success");
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("GUI/Forside.fxml"));
                primaryStage.setTitle("LMBank");
                primaryStage.setScene(new Scene(root, 1289, 807));

                /* Sætter stage i fullscreen, så den passer til alle skærme.
                Dog følger GUI ikke med eftersom det ikke er responsive. */
                // primaryStage.setFullScreen(true);
                primaryStage.show();

            } else {
                System.out.println("\n>>> Login Failed!");

                Alert loginFailed = new Alert(Alert.AlertType.ERROR);
                loginFailed.setTitle("Fejl meddelelse");
                loginFailed.setHeaderText("Der opstod en fejl!");
                loginFailed.setContentText("Du har indtastet forkert brugernavn og adgangskode!");

                loginFailed.showAndWait();
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

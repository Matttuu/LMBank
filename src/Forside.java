import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class Forside {

    /**
     * Denne klasse indeholder metoden logOutAction, som er knyttet til Forside.fxml.
     * logOutAction metoden gør brug af DB_LMBANK klassen hvor at metoden connect metoden er defineret.
     *
     * @author Daniel,Flenner, Mads, Mathias, Sebastian.
     * @version 1.0
     * @since December 2017
     */

    // Erklærer variabel
    @FXML
    private Button logOut;

    // Opretter metode login som tager imod et ActionEvent parameter ved navn event.
    public void logOutAction(ActionEvent event) throws SQLException {


        Connection con = DB_LMBANK.connect();


        /**
         * Starter en try-catch block som lukker applikationen
         * Hvis tilfældet er at der skulle ske en fejl, -
         * så bliver der fanget en Exception, og vist en fejlmeddelelse i en alert box.
         */

        try {
            con.close();
            System.out.println("\n>>> Forbindelsen blev afbrudt som forventet.");
            Stage stage = (Stage) logOut.getScene().getWindow();
            Platform.exit();
        }


        catch (SQLException ex) {
            System.out.println("\n>>> Login Failed!");

            Alert closeFailed = new Alert(Alert.AlertType.ERROR);
            closeFailed.setTitle("Fejl meddelelse");
            closeFailed.setHeaderText("Der opstod en fejl!");
            closeFailed.setContentText("Du har indtastet forkert brugernavn og adgangskode!");

            closeFailed.showAndWait();
        }



    }

}




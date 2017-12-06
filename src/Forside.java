import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class Forside {


    @FXML
    private Button logOut;

    public void logOutAction(ActionEvent event) throws SQLException {


        Connection con = DB_LMBANK.connect();


        try {
            con.close();
            System.out.println("\n>>> Forbindelsen blev afbrudt som forventet.");
            Stage stage = (Stage) logOut.getScene().getWindow();
            stage.close();
        }

        catch (SQLException ex) {
            System.out.println("\n>>> Forbindelsen blev IKKE afbrudt som forventet!");
        }



    }

}




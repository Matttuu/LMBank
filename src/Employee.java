import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Statement;


public class Employee {
    //Statements til at udføre førespørgelser
    private Statement stmt;

    @FXML
    private Button btCreateCustomer;

    @FXML
    private String txtFName;

    @FXML
    private String txtLName;

    public void btCreateCustomer(ActionEvent event) throws Exception{

        DB_Statements stmts = new DB_Statements();

        try{
            String frontName = txtFName.
        }


    }

}

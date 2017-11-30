import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Statement;

/**
 * Employee.java
 * Denne klasse har til formål at afgrænse hvad en medarbejder(Employee obj) har af beføjelser, i forhold til
 * Customer og Admin.
 *
 * @author Daniel, Flenner, Mads, Mathias, Sebastian
 * @version 1.0
 * @since December 2017
 * */

public class Employee {
    //Statements til at udføre førespørgelser
    private Statement stmt;

    @FXML
    private Button btCreateCustomer;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    public void OpretKunde(ActionEvent event) throws Exception{

        DB_Statements stmts = new DB_Statements();

        try{
            String frontName = txtFName.getText();
            String lastName = txtLName.getText();

        }
        catch{

        }


    }

}

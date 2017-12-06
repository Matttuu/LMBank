import java.sql.*;
import java.util.Random;


/**
 * <h1>DB_Statements</h1>
 *
 * DB_Statements klassen skaber en forbindelse til databasen
 *
 * <p>
 *
 *
 * @author Gruppe LilleMads
 * @version 1.0
 * @since   30-11-2017
 */

public class DB_Statements {

    // Declare a Statement
    private static Statement stmt = null;


    // Declare a connection
    private static Connection con = DB_LMBANK.connect();

    // Declare a result set
    private static ResultSet rs = null;

    // Declare a PreparedStatement
    private static PreparedStatement pst = null;



    public Boolean checkLogin(String username, String password){
        boolean check = false;

        String query = "select * from n4_dk_db.Users where userName = (?) and userPassword = (?) ";
        try{

            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            // stmt = con.createStatement();
            // rs = stmt.executeQuery(query);
            while(rs.next()){
                check = true;

            }
            if ( check == false) {

            }
        }
        catch (SQLException e) {

            e.printStackTrace();
            return check;
        }

        return check;
    }

    public void useDB(String DB_Name){
        //statement
        String query = "use " + DB_Name;
        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Using" + DB_Name + "--");
        }
        catch (SQLException ex){
            //handle sql exception
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }
    public void createCustomer(String fName, String lName){ //
        String userName = fName;

        Random r = new Random();
        int low = 1000;
        int high = 9999;
        int userPassword = r.nextInt(high-low) + low;

        //statement
        String query = "insert into Users(userName, userPassword, fname, lname, fk_roles_id) values( '" +
                userName + "', '" +
                userPassword + "', '" +
                fName + "', '" +
                lName + "', '3'";

        try {
            //connection
            stmt = con.createStatement();
            //execute
            stmt.executeUpdate(query);
            System.out.println("\n--Successfully inserted data into Users--");
        }
        catch (SQLException ex){
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

}

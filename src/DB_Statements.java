import java.sql.*;

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
    public void insertData(String tableName, String fName, String lName){ //LALALALALALA
        //statement
        String query = "insert into " + tableName + "(" +
                "myName, " +
                "adress) " +
                "values('Kasper', 'My adress'), " +
                "('Jesper', 'Villavej'), " +
                "('Mogens', 'Slumalle')";
        try {
            //connection
            stmt = con.createStatement();
            //execute
            stmt.executeUpdate(query);
            System.out.println("\n--Successfully inserted data into " + tableName + "--");
        }
        catch (SQLException ex){
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }
}

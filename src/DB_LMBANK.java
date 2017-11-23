import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_LMBANK {

    private static Connection con = null;

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://mysql45.unoeuro.com:3306/";

    private static String user = "n4_dk";

    private static String password = "yoloswag";

    public static Connection connect(){
        System.out.println("\n--Connecting to MySQL JDBC");

        try {
            Class.forName(DRIVER);
            System.out.println("\n--MySQL JDBC Driver registered");

        }

        catch (ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing");
        }

        try {
            con = DriverManager.getConnection(url, user, password);
        }

        catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("\n--Did not connect, try again");
        }

        if (con !=null){
            System.out.println("\n--Connection succesful");

        }

        else {
            System.out.println("\n--failed to connect");
        }
        return con;


    }

}

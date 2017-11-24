/* Denne klasse indeholder de variabler og den metode, vi bruger til at forbinde til projektets database.
Original udgave lavet af Douglas Beaver. Tilrettet af Mads Dideriksen og Daniel Lyck.
1. semesterprojekt, december 2017 */

//Importerer nødvendige klasser
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Opretter klassen "DB_LMBANK" og sætter access modifier til "public"
public class DB_LMBANK {

    //Deklarerer og initialiserer variabler
    private static Connection con = null; //Default er forbindelsen sat til "null"
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://mysql45.unoeuro.com:3306/"; //Databasens online url og port
    private static String user = "n4_dk"; //Username
    private static String password = "yoloswag"; //Password (Hip-hurra for en dårlig kryptering)

    /** Laver en metode kaldet "connect" i klassen "Connection".
    Denne metode forsøger samlet at forbinde til den angivede database **/
    public static Connection connect() {

        //Meddeler, at der forsøges at blive oprettet forbindelse til driveren
        System.out.println("\n>>> Forbinder til MySQL JDBC...");

        /* Try-catch-block der forsøger at registrere driveren.
        Hvis ikke den findes, meddeles dette vha. Exception handling */
        try {
            Class.forName(DRIVER); //Håndterer driveren i metoden "forName"
            System.out.println("\n>>> MySQL JDBC Driver er registreret.");
        }

        catch (ClassNotFoundException ex)   {
            ex.printStackTrace();
            System.out.println("\n>>> MySQL JDBC Driver kunne IKKE findes!");
        }

        /** Try-catch-block der forsøger at forbinde til databasen med brugernavn og kodeord.
        Her anvendes de variabler, der bliver deklareret og initialiseret i starten af koden **/
        try {
            con = DriverManager.getConnection(url, user, password); //Variablen "con" initialiseres med data
        }

        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\n>>> Kunne ikke forbinde, prøv igen!");
        }

        //Hvis "con" kunne initialiseres med korrekt url, user og password meddeles det, at forbindelsen er oprettet
        if (con != null) {
            System.out.println("\n>>> Forbindelsen blev oprettet.");
        }

        //Hvis connection fortsat er "null" fejler forbindelsen, og dette meddeles
        else {
            System.out.println("\n>>> Forbindelsen blev IKKE oprettet!");
        }

        //Metoden returnerer variablen "con"
        return con;

    }

    //Metode til at lukke forbindelsen igen, så databasen ikke overbelastes
    public static Connection closeConnection() {

        try {
            con.close();
            System.out.println("\n>>> Forbindelsen blev afbrudt som forventet.");
        }

        catch (SQLException ex) {
            System.out.println("\n>>> Forbindelsen blev IKKE afbrudt som forventet!");
        }

        return con;

    }

}
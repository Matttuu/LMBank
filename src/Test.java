//Denne klasse bruges til at teste connecteren i DB_LMBANK

public class Test {

    public static void main(String[] args) {

        DB_LMBANK.connect(); //Connecter til databasen
        //DB_LMBANK.closeConnection(); //Lukker forbindelsen igen
        DB_Statements stmt = new DB_Statements();

        stmt.useDB("n4_dk_db");
        stmt.createCustomer("Flemming", "Poulsen");
    }
}

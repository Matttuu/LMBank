//Denne klasse bruges til at teste connecteren i DB_LMBANK

public class Test {

    public static void main(String[] args) {

        DB_LMBANK.connect();
        DB_LMBANK.closeConnection();

    }
}

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection con = new DB_LMBANK().connect();
    }
}

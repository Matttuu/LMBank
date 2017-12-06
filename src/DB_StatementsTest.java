import java.util.Random;

public class DB_StatementsTest {
    public static void main(String[] args) {
        Random r = new Random();
        int low = (int)1000.0;
        int high = (int)999999999.0;
        int accNo = r.nextInt(high-low) + low;
        System.out.println(accNo);
    }
}

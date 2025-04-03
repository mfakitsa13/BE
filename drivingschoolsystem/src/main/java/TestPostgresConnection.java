import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPostgresConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dbase"; 
        String user = "postgres"; 
        String password = "mf13/03/2002"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Σύνδεση επιτυχής με τη βάση δεδομένων!");
            } else {
                System.out.println(" Αποτυχία σύνδεσης!");
            }
        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη σύνδεση!");
            e.printStackTrace();
        }
    }
}

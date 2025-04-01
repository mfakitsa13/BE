import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPostgresConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dbase"; // Άλλαξε το όνομα της βάσης αν χρειάζεται
        String user = "postgres"; // Άλλαξε το όνομα χρήστη
        String password = "mf13/03/2002"; // Άλλαξε τον κωδικό πρόσβασης

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Σύνδεση επιτυχής με τη βάση δεδομένων!");
            } else {
                System.out.println("❌ Αποτυχία σύνδεσης!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Σφάλμα κατά τη σύνδεση!");
            e.printStackTrace();
        }
    }
}
package drivingschoolsystem.services;

import drivingschoolsystem.entities.User;
import drivingschoolsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(String email, String password) {
        String hashedPassword = hashPassword(password);  // 🔹 Κρυπτογράφηση με SHA-256

        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword); // Αποθηκεύουμε το hashed password

        userRepository.save(user); // ✅ Αποθήκευση χρήστη στη βάση
        System.out.println("User created with SHA-256 password: " + hashedPassword);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // 🔹 Μετατροπή του hashed byte array σε HEX string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    
    public boolean login(String email, String rawPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String hashedPassword = hashPassword(rawPassword); // 🔹 Hash το input password
            
            System.out.println("Hashed password from input: " + hashedPassword); // Εκτύπωση του hashed password
            
            if (hashedPassword.equals(user.getPassword())) {  // 🔹 Σύγκριση με DB
                System.out.println("✅ Login successful for: " + email);
                return true;
            } else {
                System.out.println("❌ Password does not match for: " + email);
            }
        } else {
            System.out.println("❌ User not found for email: " + email);
        }
        
        return false;
    }
}
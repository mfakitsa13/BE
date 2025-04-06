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
        String hashedPassword = hashPassword(password);  // Κρυπτογράφηση με SHA-256

        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword); 

        userRepository.save(user); 
        System.out.println("User created with SHA-256 password: " + hashedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            
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
            String hashedPassword = hashPassword(rawPassword); 
            
            System.out.println("Hashed password from input: " + hashedPassword); 
            
            if (hashedPassword.equals(user.getPassword())) { 
                System.out.println(" Login successful for: " + email);
                return true;
            } else {
                System.out.println("Password does not match for: " + email);
            }
        } else {
            System.out.println("User not found for email: " + email);
        }
        
        return false;
    }
}
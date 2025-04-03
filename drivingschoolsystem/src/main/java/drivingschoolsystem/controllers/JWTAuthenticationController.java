package drivingschoolsystem.controllers;

import drivingschoolsystem.entities.User;
import drivingschoolsystem.services.UserService;
import jakarta.annotation.PostConstruct;
import drivingschoolsystem.configuration.HashUtil;
import drivingschoolsystem.configuration.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.102:3000"})
@RestController
@RequestMapping("/api/auth")

public class JWTAuthenticationController {

	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private JWTUtil jwtUtil;

	    @Autowired
	    private UserService userService;

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
	        String email = loginRequest.get("email");
	        String password = loginRequest.get("password");

	        if (userService.login(email, password)) {
	            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
	            String accessToken = jwtUtil.generateToken(userDetails);
	            String refreshToken = jwtUtil.generateRefreshToken(userDetails);
	            
	            System.out.println("accessToken: " + accessToken);
	            System.out.println("refreshToken: " + refreshToken);

	            return ResponseEntity.ok(Map.of("accessToken", accessToken, "refreshToken", refreshToken));
	        }

	        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
	    }
	    
	    @PostMapping("/refresh")
	    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
	        String refreshToken = request.get("refreshToken");

	        if (jwtUtil.isTokenExpired(refreshToken)) {
	            return ResponseEntity.status(401).body(Map.of("error", "Refresh token expired"));
	        }

	        String email = jwtUtil.extractUsername(refreshToken);
	        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
	        String newAccessToken = jwtUtil.generateToken(userDetails);

	        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
	    }
	  
	    @PostConstruct
	    public void init() {
	        System.out.println("JWTAuthenticationController Loaded!");
	    }
}

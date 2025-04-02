Σύστημα Σχολών Οδήγησης

Αυτό το project είναι μια εφαρμογή Spring Boot που επιτρέπει τη διαχείριση σχολών οδήγησης και μαθητών. Υποστηρίζει λειτουργίες όπως αυθεντικοποίηση JWT, διαχείριση χρηστών με κρυπτογράφηση κωδικών(sha-256 hashed), και CRUD λειτουργίες για σχολές οδήγησης και μαθητές.

ΧΑΡΑΚΤΗΡΙΣΤΚΑ
Αυθεντικοποίηση Χρηστών:
-Δημιουργία χρηστών με ασφαλή κρυπτογράφηση κωδικών (SHA-256).
-Δημιουργία και ανανέωση JWT για πρόσβαση στο σύστημα.

Διαχείριση Σχολών Οδήγησης:
-CRUD λειτουργίες για την προσθήκη, ενημέρωση, και διαγραφή σχολών οδήγησης.

Διαχείριση Μαθητών:
-CRUD λειτουργίες για την προσθήκη, ενημέρωση, και διαγραφή μαθητών.

CORS & Caching:
-Ρυθμίσεις CORS για επικοινωνία με frontend εφαρμογές.

Τεχνολογίες που χρησιμοποιήθηκαν:
-Java 17
-Spring Boot
-Spring Security (JWT Authentication)
-JPA / Hibernate για αλληλεπίδραση με τη βάση δεδομένων.
-Lombok για την απλοποίηση του κώδικα (getters/setters, constructors).

Η εφαρμογή τρέχει στο http://localhost:8080.

API Endpoints
Login:
POST /api/auth/login - Αυθεντικοποίηση χρήστη και επιστροφή JWT.

Refresh Token:
POST /api/auth/refresh - Ανανεώστε το JWT token χρησιμοποιώντας το refresh token.

Driving Schools:
GET /api/driving-schools - Λήψη όλων των σχολών οδήγησης.
POST /api/driving-schools - Δημιουργία νέας σχολής οδήγησης.
GET /api/driving-schools/{id} - Λήψη σχολής οδήγησης με ID.
PUT /api/driving-schools/{id} - Ενημέρωση στοιχείων σχολής οδήγησης.
DELETE /api/driving-schools/{id} - Διαγραφή σχολής οδήγησης.

Students:
GET /api/students - Λήψη όλων των μαθητών.
GET /api/students/{id} - Λήψη μαθητή με ID.
POST /api/students - Δημιουργία νέου μαθητή.
PUT /api/students/{id} - Ενημέρωση στοιχείων μαθητή.
DELETE /api/students/{id} - Διαγραφή μαθητή.




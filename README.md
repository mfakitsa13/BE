# Σύστημα Σχολών Οδήγησης

Αυτό το project είναι μια εφαρμογή Spring Boot που επιτρέπει τη διαχείριση σχολών οδήγησης και μαθητών. Υποστηρίζει λειτουργίες όπως αυθεντικοποίηση JWT, διαχείριση χρηστών με κρυπτογράφηση κωδικών (SHA-256 hashed) και CRUD λειτουργίες για σχολές οδήγησης και μαθητές.

## Χαρακτηριστικά

### Αυθεντικοποίηση Χρηστών
- Ασφαλής κρυπτογράφηση κωδικών (SHA-256).
- Δημιουργία και ανανέωση JWT για πρόσβαση στο σύστημα.

### Διαχείριση Σχολών Οδήγησης
- CRUD λειτουργίες για την προσθήκη, ενημέρωση και διαγραφή σχολών οδήγησης.

### Διαχείριση Μαθητών
- CRUD λειτουργίες για την προσθήκη, ενημέρωση και διαγραφή μαθητών.

### CORS
- Ρυθμίσεις CORS για επικοινωνία με frontend εφαρμογή.

## Τεχνολογίες που χρησιμοποιήθηκαν

- **Java 17**
- **Spring Boot**
- **Spring Security** (JWT Authentication)
- **JPA / Hibernate** για αλληλεπίδραση με τη βάση δεδομένων.
- **Lombok** για την απλοποίηση του κώδικα (getters/setters, constructors).

Η εφαρμογή τρέχει στο `http://localhost:8080`.

## API Endpoints

### Authentication

#### Login
```http
POST /api/auth/login
```
Αυθεντικοποίηση χρήστη και επιστροφή JWT.

#### Refresh Token
```http
POST /api/auth/refresh
```
Ανανέωση του JWT token χρησιμοποιώντας το refresh token.

### Driving Schools

#### Get all driving schools
```http
GET /api/driving-schools
```
Λήψη όλων των σχολών οδήγησης.

#### Create a new driving school
```http
POST /api/driving-schools
```
Δημιουργία νέας σχολής οδήγησης.

#### Get a driving school by ID
```http
GET /api/driving-schools/{id}
```
Λήψη σχολής οδήγησης με ID.

#### Update a driving school
```http
PUT /api/driving-schools/{id}
```
Ενημέρωση στοιχείων σχολής οδήγησης.

#### Delete a driving school
```http
DELETE /api/driving-schools/{id}
```
Διαγραφή σχολής οδήγησης.

### Students

#### Get all students
```http
GET /api/students
```
Λήψη όλων των μαθητών.

#### Get a student by ID
```http
GET /api/students/{id}
```
Λήψη μαθητή με ID.

#### Create a new student
```http
POST /api/students
```
Δημιουργία νέου μαθητή.

#### Update a student
```http
PUT /api/students/{id}
```
Ενημέρωση στοιχείων μαθητή.

#### Delete a student
```http
DELETE /api/students/{id}
```
Διαγραφή μαθητή.


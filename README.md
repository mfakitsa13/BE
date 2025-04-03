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

#### Αυθεντικοποίηση χρήστη και επιστροφή JWT
```http
POST /api/auth/login
```

#### Ανανέωση του JWT token χρησιμοποιώντας το refresh token
```http
POST /api/auth/refresh
```

### Driving Schools

#### Λήψη όλων των σχολών οδήγησης
```http
GET /api/driving-schools
```

#### Δημιουργία νέας σχολής οδήγησης

```http
POST /api/driving-schools
```

#### Λήψη σχολής οδήγησης με ID
```http
GET /api/driving-schools/{id}
```

#### Ενημέρωση στοιχείων σχολής οδήγησης
```http
PUT /api/driving-schools/{id}
```

#### Διαγραφή σχολής οδήγησης
```http
DELETE /api/driving-schools/{id}
```

### Students

#### Λήψη όλων των μαθητών
```http
GET /api/students
```

#### Λήψη μαθητή με ID
```http
GET /api/students/{id}
```

#### Δημιουργία νέου μαθητή
```http
POST /api/students
```

#### Ενημέρωση στοιχείων μαθητή
```http
PUT /api/students/{id}
```

#### Διαγραφή μαθητή
```http
DELETE /api/students/{id}
```

#### Delete a student
```http
DELETE /api/students/{id}
```
Διαγραφή μαθητή.


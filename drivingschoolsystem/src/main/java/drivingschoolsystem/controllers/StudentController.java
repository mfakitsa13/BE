package drivingschoolsystem.controllers;

import drivingschoolsystem.entities.Student;
import drivingschoolsystem.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.102:3000"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // Δεν χρειάζεται πλέον το DrivingSchoolRepository
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        System.out.println("🚗 StudentController loaded!");
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Search for students by last name and first name
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String lastName, @RequestParam String firstName) {
        return studentService.searchStudents(lastName, firstName);
    }

    // Create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student) {
        System.out.println("📥 Received Student: " + student);

        // Έλεγχος ότι έχει δοθεί όνομα σχολής (drivingSchoolName) και δεν είναι κενό
        if (student.getDrivingSchoolName() == null || student.getDrivingSchoolName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Δημιουργία του Student με το drivingSchoolName (ως String)
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // Update an existing student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

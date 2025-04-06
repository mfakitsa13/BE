package drivingschoolsystem.services;

import drivingschoolsystem.entities.DrivingSchool;
import drivingschoolsystem.entities.Student;
import drivingschoolsystem.repositories.DrivingSchoolRepository;
import drivingschoolsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

  
    public Student createStudent(Student student) {
        DrivingSchool drivingSchool = drivingSchoolRepository.findByName(student.getDrivingSchoolName());
        
        if (drivingSchool == null) {
            throw new IllegalArgumentException("Driving school with name " + student.getDrivingSchoolName() + " not found.");
        }

        student.setDrivingSchool(drivingSchool);

        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setAfm(updatedStudent.getAfm());
                    existingStudent.setFirstName(updatedStudent.getFirstName());
                    existingStudent.setLastName(updatedStudent.getLastName());
                    existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
                    existingStudent.setDrivingSchoolName(updatedStudent.getDrivingSchoolName());
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}


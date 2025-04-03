package drivingschoolsystem.services;

import drivingschoolsystem.entities.Student;
import drivingschoolsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

   
    public List<Student> getStudentsBySchoolName(String schoolName) {
        return studentRepository.findByDrivingSchoolName(schoolName);
    }


    public Student createStudent(Student student) {
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

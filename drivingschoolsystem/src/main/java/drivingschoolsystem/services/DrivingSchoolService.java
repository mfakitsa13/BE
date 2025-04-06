package drivingschoolsystem.services;


import drivingschoolsystem.entities.DrivingSchool;
import drivingschoolsystem.entities.Student;
import drivingschoolsystem.repositories.DrivingSchoolRepository;
import drivingschoolsystem.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrivingSchoolService {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Autowired
    private StudentRepository studentRepository;
    
    public List<DrivingSchool> getAllDrivingSchools() {
        return drivingSchoolRepository.findAll();
    }

    public Optional<DrivingSchool> getDrivingSchoolById(Integer id) {
        return drivingSchoolRepository.findById(id);
    }
    
        
    public DrivingSchool createDrivingSchool(DrivingSchool drivingSchool) {
        return drivingSchoolRepository.save(drivingSchool);
    }

    public DrivingSchool updateDrivingSchool(Integer id, DrivingSchool updatedSchool) {
        return drivingSchoolRepository.findById(id)
                .map(existingSchool -> {
                    // Ανανέωση των στοιχείων της σχολής
                    String oldSchoolName = existingSchool.getName(); // Αποθηκεύω το παλιό όνομα
                    existingSchool.setName(updatedSchool.getName());
                    existingSchool.setLocation(updatedSchool.getLocation());
                    existingSchool.setPhone(updatedSchool.getPhone());

                    // Αποθηκεύω την ενημερωμένη σχολή
                    DrivingSchool updated = drivingSchoolRepository.save(existingSchool);

                    // Ενημερώνω τους μαθητές για το νέο όνομα σχολής
                    if (!oldSchoolName.equals(updatedSchool.getName())) {
                        List<Student> students = studentRepository.findByDrivingSchoolName(oldSchoolName);
                        for (Student student : students) {
                            student.setDrivingSchoolName(updatedSchool.getName());
                        }
                        studentRepository.saveAll(students); // Ενημέρωση όλων των μαθητών με το νέο όνομα
                    }

                    return updated;
                })
                .orElseThrow(() -> new RuntimeException("Driving School not found"));
    }
    
    
    public void deleteDrivingSchool(Integer id) {
    	Optional<DrivingSchool> drivingSchool = drivingSchoolRepository.findById(id);
        if (drivingSchool.isPresent()) {
            // Βρίσκω τους μαθητές που ανήκουν στη σχολή
            List<Student> students = studentRepository.findByDrivingSchoolName(drivingSchool.get().getName());
            
         // Διαγράφω όλους τους μαθητές της σχολής
            studentRepository.deleteAll(students); 

            // Διαγράφω τη σχολή από τη βάση δεδομένων
            drivingSchoolRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Σχολή με το ID " + id + " δεν βρέθηκε.");
        }
    }
    
}

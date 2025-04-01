package drivingschoolsystem.services;


import drivingschoolsystem.entities.DrivingSchool;
import drivingschoolsystem.repositories.DrivingSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrivingSchoolService {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    public List<DrivingSchool> getAllDrivingSchools() {
        return drivingSchoolRepository.findAll();
    }

    public Optional<DrivingSchool> getDrivingSchoolById(Integer id) {
        return drivingSchoolRepository.findById(id);
    }

    public Optional<DrivingSchool> getDrivingSchoolByName(String name) {
        return drivingSchoolRepository.findByName(name);
    }

    public DrivingSchool createDrivingSchool(DrivingSchool drivingSchool) {
        return drivingSchoolRepository.save(drivingSchool);
    }

    public DrivingSchool updateDrivingSchool(Integer id, DrivingSchool updatedSchool) {
        return drivingSchoolRepository.findById(id)
                .map(existingSchool -> {
                    existingSchool.setName(updatedSchool.getName());
                    existingSchool.setLocation(updatedSchool.getLocation());
                    existingSchool.setPhone(updatedSchool.getPhone());
                    return drivingSchoolRepository.save(existingSchool);
                })
                .orElseThrow(() -> new RuntimeException("Driving School not found"));
    }

    public void deleteDrivingSchool(Integer id) {
        drivingSchoolRepository.deleteById(id);
    }
}

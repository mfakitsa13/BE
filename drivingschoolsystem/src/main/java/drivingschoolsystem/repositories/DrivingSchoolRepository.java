package drivingschoolsystem.repositories;

import drivingschoolsystem.entities.DrivingSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrivingSchoolRepository extends JpaRepository<DrivingSchool, Integer> {
    Optional<DrivingSchool> findByName(String name);
}
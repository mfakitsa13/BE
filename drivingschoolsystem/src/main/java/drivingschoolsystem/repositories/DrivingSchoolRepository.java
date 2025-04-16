package drivingschoolsystem.repositories;

import drivingschoolsystem.entities.DrivingSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrivingSchoolRepository extends JpaRepository<DrivingSchool, Integer> {
    DrivingSchool findByName(String name);
}

package drivingschoolsystem.repositories;

import drivingschoolsystem.entities.DrivingSchool;
import drivingschoolsystem.entities.Student;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByDrivingSchoolName(String schoolName);
}
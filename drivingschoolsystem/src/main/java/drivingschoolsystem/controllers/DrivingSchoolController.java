package drivingschoolsystem.controllers;

import drivingschoolsystem.entities.DrivingSchool;
import drivingschoolsystem.services.DrivingSchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.102:3000"}, allowCredentials = "true")
@RestController
@RequestMapping("/api/driving-schools")
public class DrivingSchoolController {

	private final DrivingSchoolService drivingSchoolService;

    public DrivingSchoolController(DrivingSchoolService drivingSchoolService) {
        this.drivingSchoolService = drivingSchoolService;
        System.out.println("🚗 DrivingSchoolController loaded!");
    }

    @GetMapping
    public List<DrivingSchool> getAllDrivingSchools() {
        return drivingSchoolService.getAllDrivingSchools();
    }
	 

	    @GetMapping("/{id}")
	    public ResponseEntity<DrivingSchool> getDrivingSchoolById(@PathVariable Integer id) {
	        return drivingSchoolService.getDrivingSchoolById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public DrivingSchool createDrivingSchool(@RequestBody DrivingSchool drivingSchool) {
	        return drivingSchoolService.createDrivingSchool(drivingSchool);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DrivingSchool> updateDrivingSchool(@PathVariable Integer id, @RequestBody DrivingSchool updatedSchool) {
	        return ResponseEntity.ok(drivingSchoolService.updateDrivingSchool(id, updatedSchool));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDrivingSchool(@PathVariable Integer id) {
	        drivingSchoolService.deleteDrivingSchool(id);
	        return ResponseEntity.noContent().build();
	    }
}

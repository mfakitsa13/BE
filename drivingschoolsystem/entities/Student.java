package drivingschoolsystem.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.time.LocalDate;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = "afm"))
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @Column(nullable = false, unique = true, length = 9)
    private String afm;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;


    @Column(name = "driving_school_name", nullable = false)
    @JsonProperty("drivingSchoolName")
    private String drivingSchoolName;
    
    public String getDrivingSchoolName() {
        return drivingSchoolName;
    }

    public void setDrivingSchoolName(String drivingSchoolName) {
        this.drivingSchoolName = drivingSchoolName;
    }

    @ManyToOne
    @JoinColumn(name = "driving_school_id", referencedColumnName = "id", nullable = false)
    @JsonProperty("drivingSchool")
    private DrivingSchool drivingSchool;

	public void setDrivingSchool(DrivingSchool drivingSchool) {
		this.drivingSchool = drivingSchool;
	}
    

    public void setId(int id) {
        this.id = id;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", afm='" + afm + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", drivingSchoolName='" + drivingSchoolName + '\'' +
                '}';
    }


}



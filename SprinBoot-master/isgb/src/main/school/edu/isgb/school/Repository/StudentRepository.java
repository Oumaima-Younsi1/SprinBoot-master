package edu.isgb.school.Repository;

import edu.isgb.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findBySchoolIdSchool(Integer schoolId);

    //chargement de l'etudiant et  son adress
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.address WHERE s.idStudent = :id")
    Student findByIdWithAddress(Integer id);
}
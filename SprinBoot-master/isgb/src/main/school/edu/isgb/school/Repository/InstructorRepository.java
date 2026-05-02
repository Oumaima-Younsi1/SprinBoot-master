package edu.isgb.school.Repository;

import edu.isgb.school.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    List<Instructor> findByNameContainingIgnoreCase(String name);

    @Query("SELECT i FROM Instructor i JOIN i.school s WHERE s.idSchool = :schoolId")
    List<Instructor> findBySchoolId(Integer schoolId);

    @Query("SELECT i FROM Instructor i LEFT JOIN FETCH i.courses WHERE i.idInstructor = :id")
    Optional<Instructor> findByIdWithCourses(Integer id);
}

package edu.isgb.school.Repository;

import edu.isgb.school.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByNameContainingIgnoreCase(String name);

    @Query("SELECT c FROM Course c JOIN c.instructors i WHERE i.idInstructor = :instructorId")
    List<Course> findCoursesByInstructorId(Integer instructorId);
}

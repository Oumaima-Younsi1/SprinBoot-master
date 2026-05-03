package edu.isgb.school.SchoolService;

import edu.isgb.school.entities.Course;
import edu.isgb.school.entities.Instructor;
import edu.isgb.school.Repository.CourseRepository;
import edu.isgb.school.Repository.InstructorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;

    public Course findById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course non trouvé"));
    }

    public List<Course> findByInstructor(int instructorId) {
        return courseRepository.findCoursesByInstructorId(instructorId);
    }

    public void addCourseToInstructor(int instructorId, Course course) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor non trouvé"));

        if (course.getInstructors() == null) {
            course.setInstructors(new ArrayList<>());
        }
        course.getInstructors().add(instructor);

        if (instructor.getCourses() == null) {
            instructor.setCourses(new ArrayList<>());
        }
        instructor.getCourses().add(course);

        instructorRepository.save(instructor);
    }
}
package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Course;
import edu.isgb.school.Repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Course> searchByName(@RequestParam String name) {
        return courseRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(@PathVariable Integer instructorId) {
        return courseRepository.findCoursesByInstructorId(instructorId);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id,
                               @RequestBody Course updated) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null) return null;

        course.setName(updated.getName());

        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseRepository.deleteById(id);
    }
}
package edu.isgb.school.TestSchoolController;

import  edu.isgb.school.entities.Course;
import edu.isgb.school.SchoolService.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(@PathVariable int instructorId) {
        return courseService.findByInstructor(instructorId);
    }

    @PostMapping("/instructor/{instructorId}")
    public void addCourseToInstructor(@PathVariable int instructorId,
                                      @RequestBody Course course) {
        courseService.addCourseToInstructor(instructorId, course);
    }
}

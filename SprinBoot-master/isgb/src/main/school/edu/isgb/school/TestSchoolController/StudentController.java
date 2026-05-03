package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Student;
import edu.isgb.school.SchoolService.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/{schoolId}")
    public Student createStudent(@RequestBody Student student,
                                 @PathVariable int schoolId) {
        return studentService.createStudent(student, schoolId);
    }
}

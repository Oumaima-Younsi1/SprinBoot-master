package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Student;
import edu.isgb.school.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/school/{schoolId}")
    public List<Student> getStudentsBySchool(@PathVariable Integer schoolId) {
        return studentRepository.findBySchoolIdSchool(schoolId);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student updated) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) return null;

        student.setName(updated.getName());
        student.setBirthDate(updated.getBirthDate());
        student.setAddress(updated.getAddress());
        student.setSchool(updated.getSchool());

        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }
}
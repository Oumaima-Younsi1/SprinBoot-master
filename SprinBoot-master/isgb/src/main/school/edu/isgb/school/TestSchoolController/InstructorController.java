package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Instructor;
import edu.isgb.school.Repository.InstructorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorRepository instructorRepository;

    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Integer id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/with-courses")
    public Instructor getInstructorWithCourses(@PathVariable Integer id) {
        return instructorRepository.findByIdWithCourses(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Instructor> searchByName(@RequestParam String name) {
        return instructorRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/school/{schoolId}")
    public List<Instructor> getInstructorsBySchool(@PathVariable Integer schoolId) {
        return instructorRepository.findBySchoolId(schoolId);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Integer id,
                                       @RequestBody Instructor updated) {

        Instructor inst = instructorRepository.findById(id).orElse(null);

        if (inst == null) return null;

        inst.setName(updated.getName());
        inst.setCourses(updated.getCourses());
        inst.setSchool(updated.getSchool());

        return instructorRepository.save(inst);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Integer id) {
        instructorRepository.deleteById(id);
    }
}
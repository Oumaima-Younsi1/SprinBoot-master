package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.School;
import edu.isgb.school.Repository.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Integer id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/with-departments")
    public School getSchoolWithDepartments(@PathVariable Integer id) {
        return schoolRepository.findByIdWithDepartments(id).orElse(null);
    }

    @GetMapping("/{id}/with-students")
    public School getSchoolWithStudents(@PathVariable Integer id) {
        return schoolRepository.findByIdWithStudents(id).orElse(null);
    }

    @GetMapping("/search")
    public List<School> searchByName(@RequestParam String name) {
        return schoolRepository.findByNameContainingIgnoreCase(name);
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Integer id,
                               @RequestBody School updated) {

        School school = schoolRepository.findById(id).orElse(null);

        if (school == null) return null;

        school.setName(updated.getName());
        school.setPhone(updated.getPhone());

        return schoolRepository.save(school);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Integer id) {
        schoolRepository.deleteById(id);
    }
}
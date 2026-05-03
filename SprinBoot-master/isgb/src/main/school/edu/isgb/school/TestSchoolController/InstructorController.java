package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Instructor;
import edu.isgb.school.SchoolService.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable int id) {
        return instructorService.findById(id);
    }

    @GetMapping("/search")
    public List<Instructor> searchByName(@RequestParam String name) {
        return instructorService.findByName(name);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }
}

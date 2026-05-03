package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.School;
import edu.isgb.school.SchoolService.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools")
@AllArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable int id) {
        return schoolService.findById(id);
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }
}

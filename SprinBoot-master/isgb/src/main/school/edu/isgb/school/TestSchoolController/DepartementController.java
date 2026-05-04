package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Departement;
import edu.isgb.school.SchoolService.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartementController {

    private final DepartementService departementService;

    @GetMapping
    public List<Departement> getAllDepartements() {
        return departementService.findAll();
    }

    @PostMapping("/{schoolId}")
    public Departement createDepartement(@RequestBody Departement departement,
                                         @PathVariable int schoolId) {
        return departementService.createDepartement(departement, schoolId);
    }
}

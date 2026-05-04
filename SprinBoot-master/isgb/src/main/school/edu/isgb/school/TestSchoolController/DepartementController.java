package isgb.java.Oumi.controller;

import isgb.java.Oumi.Model.Departement;
import isgb.java.Oumi.Service.DepartementService;
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

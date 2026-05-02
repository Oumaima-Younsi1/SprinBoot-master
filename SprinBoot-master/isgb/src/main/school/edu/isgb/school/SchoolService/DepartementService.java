package edu.isgb.school.SchoolService;

import edu.isgb.school.entities.Departement;
import edu.isgb.school.entities.School;
import edu.isgb.school.Repository.DepartmentRepository;
import edu.isgb.school.Repository.SchoolRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepartementService {

    private DepartmentRepository departementRepository;
    private SchoolRepository schoolRepository;

    public Departement createDepartement(Departement d, int schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School non trouvée"));

        d.setSchool(school);
        return departementRepository.save(d);
    }

    public List<Departement> findAll() {
        return departementRepository.findAll();
    }
}

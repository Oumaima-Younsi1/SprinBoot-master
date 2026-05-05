package isgb.java.Oumi.Service;

import isgb.java.Oumi.Model.Departement;
import isgb.java.Oumi.Model.School;
import isgb.java.Oumi.Repository.DepartementRepository;
import isgb.java.Oumi.Repository.SchoolRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepartementService {

    private DepartementRepository departementRepository;
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

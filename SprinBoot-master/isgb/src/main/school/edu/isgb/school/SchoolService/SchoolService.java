package edu.isgb.school.SchoolService;

import edu.isgb.school.entities.School;
import edu.isgb.school.Repository.SchoolRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class SchoolService {

    private SchoolRepository schoolRepository;

    public School createSchool(School school) {
        if (school.getDepartments() != null) {
            school.getDepartments().forEach(d -> d.setSchool(school));
        }
        if (school.getStudents() != null) {
            school.getStudents().forEach(s -> s.setSchool(school));
        }
        if (school.getInstructors() != null) {
            school.getInstructors().forEach(i -> i.setSchool(school));
        }
        return schoolRepository.save(school);
    }

    public School findById(int id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School non trouvée"));
    }
}


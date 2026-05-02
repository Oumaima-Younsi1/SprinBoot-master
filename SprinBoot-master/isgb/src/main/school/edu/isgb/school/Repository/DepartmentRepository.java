package edu.isgb.school.Repository;

import edu.isgb.school.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Integer> {

    List<Departement> findBySchoolIdSchool(Integer schoolId);

    List<Departement> findByNameContainingIgnoreCase(String name);
}

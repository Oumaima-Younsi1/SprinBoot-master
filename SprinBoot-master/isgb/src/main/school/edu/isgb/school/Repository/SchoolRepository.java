package edu.isgb.school.Repository;

import edu.isgb.school.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    Optional<School> findByName(String name);
    List<School> findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM School s LEFT JOIN FETCH s.departments WHERE s.idSchool = :id")
    Optional<School> findByIdWithDepartments(Integer id);

    @Query("SELECT s FROM School s LEFT JOIN FETCH s.students WHERE s.idSchool = :id")
    Optional<School> findByIdWithStudents(Integer id);
}

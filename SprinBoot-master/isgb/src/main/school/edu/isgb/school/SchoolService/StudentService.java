package edu.isgb.school.SchoolService;

import edu.isgb.school.entities.School;
import edu.isgb.school.entities.Student;
import edu.isgb.school.Repository.SchoolRepository;
import edu.isgb.school.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;

    public Student createStudent(Student student, int schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School non trouvée"));

        student.setSchool(school);
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}

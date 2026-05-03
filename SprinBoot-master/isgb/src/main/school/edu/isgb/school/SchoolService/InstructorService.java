package edu.isgb.school.SchoolService;

import edu.isgb.school.entities.Instructor;
import edu.isgb.school.Repository.InstructorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InstructorService {

    private InstructorRepository instructorRepository;

    public Instructor createInstructor(Instructor instructor) {
        if (instructor.getCourses() != null) {
            instructor.getCourses().forEach(course -> {
                if (course.getInstructors() != null &&
                        !course.getInstructors().contains(instructor)) {
                    course.getInstructors().add(instructor);
                }
            });
        }
        return instructorRepository.save(instructor);
    }

    public List<Instructor> findByName(String name) {
        return instructorRepository.findByNameContainingIgnoreCase(name);
    }

    public Instructor findById(int id) {
        return instructorRepository.findByIdWithCourses(id)
                .orElseThrow(() -> new RuntimeException("Instructor non trouvé"));
    }
}
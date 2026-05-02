package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInstructor")
    private Integer idInstructor;
    @Column(name = "Name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "instructor_course",
            joinColumns = @JoinColumn(name = "Instructor_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id")
    )
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "school_Id")
    private School school;
}

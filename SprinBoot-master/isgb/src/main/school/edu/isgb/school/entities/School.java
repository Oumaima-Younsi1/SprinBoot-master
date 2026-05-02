package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="school")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSchool")
    private Integer idSchool;
    @Column(name = "Name")
    private String name;
    @Column(name = "Phone")
    private Integer phone;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Departement> departments;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Instructor> instructors;
}

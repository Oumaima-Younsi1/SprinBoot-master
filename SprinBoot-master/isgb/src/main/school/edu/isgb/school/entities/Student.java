package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdStudent")
    private Integer idStudent;

    @Column(name = "Name")
    private String name;

    @Column(name = "BirthDate")
    private Date birthDate;

    @OneToOne
    private Address address;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}

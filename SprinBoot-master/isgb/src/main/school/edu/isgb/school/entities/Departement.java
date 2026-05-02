package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="department")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDepartment")
    private Integer idDepartment;
    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "school_Id")
    private School school;
}

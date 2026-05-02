package edu.isgb.school.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAddress")
    private Integer idAddress;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;
    @Column(name="PostalCode")
    private String postalCode;

    @OneToOne
    private Student student;
}


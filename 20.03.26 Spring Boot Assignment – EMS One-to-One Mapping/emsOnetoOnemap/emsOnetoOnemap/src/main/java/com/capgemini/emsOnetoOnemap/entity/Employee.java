package com.capgemini.emsOnetoOnemap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String designation;
    private double salary;
    private LocalDate dateOfJoining;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", referencedColumnName = "id")
    private Address address;
}
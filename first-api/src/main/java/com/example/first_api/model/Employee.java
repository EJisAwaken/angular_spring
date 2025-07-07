package com.example.first_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "employee")
@Entity
@Getter
@Setter
public class Employee {
    @Id
    private int idEmp;

    private String nom;

    private String prenom;

    @Column(unique = true)
    private String matricule;

    private String poste;

    @Column(name = "is_deleted")
    private Boolean isDeleted=false;
}
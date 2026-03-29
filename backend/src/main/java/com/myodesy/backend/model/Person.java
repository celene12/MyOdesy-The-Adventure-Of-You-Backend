package com.myodesy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "maestro_persona")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer personId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String firstName;

    @Column(name = "apellido", nullable = false, length = 100)
    private String lastName;

    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private SystemUser systemUser;

    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDateTime.now();
    }

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public Integer getPersonId()             { return personId; }
    public String  getFirstName()            { return firstName; }
    public void    setFirstName(String n)    { this.firstName = n; }
    public String  getLastName()             { return lastName; }
    public void    setLastName(String a)     { this.lastName = a; }
    public LocalDateTime getRegistrationDate() { return registrationDate; }
}
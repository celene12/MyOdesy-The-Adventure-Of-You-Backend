package com.myodesy.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_sistema")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer userId;

    @Column(name = "correo", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "nombre_usuario", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "contrasena", nullable = false)
    private String password;

    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;

    // Relationship with Person
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Person person;

    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDateTime.now();
    }

    public SystemUser() {}

    public Integer       getUserId()            { return userId; }
    public String        getEmail()             { return email; }
    public void          setEmail(String e)     { this.email = e; }
    public String        getUsername()          { return username; }
    public void          setUsername(String u)  { this.username = u; }
    public String        getPassword()          { return password; }
    public void          setPassword(String p)  { this.password = p; }
    public LocalDateTime getRegistrationDate() { return registrationDate; }
    public Person        getPerson()           { return person; }
    public void          setPerson(Person p)   { this.person = p; }
}
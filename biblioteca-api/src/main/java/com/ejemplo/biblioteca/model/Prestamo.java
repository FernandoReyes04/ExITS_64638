package com.ejemplo.biblioteca.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Column(name = "fecha_prestamo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    public Prestamo() {
    }

    public Prestamo(Libro libro, Persona persona, Date fechaPrestamo) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        if (fechaPrestamo == null) {
            throw new IllegalArgumentException("La fecha de préstamo no puede ser nula");
        }
        this.libro = libro;
        this.persona = persona;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}

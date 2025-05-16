package com.ejemplo.biblioteca.dto;

import java.util.Date;

/**
 * Data Transfer Object for Prestamo entity
 */
public class PrestamoDTO {
    private Long id;
    private Long libroId;
    private String tituloLibro;
    private String autorLibro;
    private Long personaId;
    private String nombrePersona;
    private Date fechaPrestamo;

    // Default constructor
    public PrestamoDTO() {
    }

    // Constructor with all fields
    public PrestamoDTO(Long id, Long libroId, String tituloLibro, String autorLibro, 
                      Long personaId, String nombrePersona, Date fechaPrestamo) {
        this.id = id;
        this.libroId = libroId;
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.personaId = personaId;
        this.nombrePersona = nombrePersona;
        this.fechaPrestamo = fechaPrestamo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
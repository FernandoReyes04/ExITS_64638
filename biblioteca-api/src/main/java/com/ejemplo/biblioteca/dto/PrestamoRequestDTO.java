package com.ejemplo.biblioteca.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * Data Transfer Object for creating a new loan
 * Contains the person ID and a list of book IDs to be loaned
 */
public class PrestamoRequestDTO {
    @NotNull(message = "El ID de la persona es obligatorio")
    private Long personaId;

    @NotNull(message = "La lista de IDs de libros es obligatoria")
    @Size(min = 1, message = "Debe incluir al menos un libro")
    private List<Long> librosIds;

    // Default constructor
    public PrestamoRequestDTO() {
    }

    // Constructor with all fields
    public PrestamoRequestDTO(Long personaId, List<Long> librosIds) {
        this.personaId = personaId;
        this.librosIds = librosIds;
    }

    // Getters and Setters
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public List<Long> getLibrosIds() {
        return librosIds;
    }

    public void setLibrosIds(List<Long> librosIds) {
        this.librosIds = librosIds;
    }
}

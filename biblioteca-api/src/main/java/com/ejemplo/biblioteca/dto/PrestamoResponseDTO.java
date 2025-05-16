package com.ejemplo.biblioteca.dto;

import java.util.List;
import java.util.ArrayList;

/**
 * Data Transfer Object for loan creation response
 * Contains the created loans and information about unavailable books
 */
public class PrestamoResponseDTO {
    private List<PrestamoDTO> prestamosCreados;
    private List<String> librosNoDisponibles;
    private String mensaje;

    // Default constructor
    public PrestamoResponseDTO() {
        this.prestamosCreados = new ArrayList<>();
        this.librosNoDisponibles = new ArrayList<>();
    }

    // Constructor with all fields
    public PrestamoResponseDTO(List<PrestamoDTO> prestamosCreados, List<String> librosNoDisponibles, String mensaje) {
        this.prestamosCreados = prestamosCreados;
        this.librosNoDisponibles = librosNoDisponibles;
        this.mensaje = mensaje;
    }

    // Getters and Setters
    public List<PrestamoDTO> getPrestamosCreados() {
        return prestamosCreados;
    }

    public void setPrestamosCreados(List<PrestamoDTO> prestamosCreados) {
        this.prestamosCreados = prestamosCreados;
    }

    public List<String> getLibrosNoDisponibles() {
        return librosNoDisponibles;
    }

    public void setLibrosNoDisponibles(List<String> librosNoDisponibles) {
        this.librosNoDisponibles = librosNoDisponibles;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
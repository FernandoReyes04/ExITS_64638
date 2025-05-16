package com.ejemplo.biblioteca.mapper;

import com.ejemplo.biblioteca.dto.LibroDTO;
import com.ejemplo.biblioteca.dto.PersonaDTO;
import com.ejemplo.biblioteca.dto.PrestamoDTO;
import com.ejemplo.biblioteca.model.Libro;
import com.ejemplo.biblioteca.model.Persona;
import com.ejemplo.biblioteca.model.Prestamo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for mapping between entities and DTOs
 */
public class EntityDTOMapper {

    // Persona mappings
    public static PersonaDTO toPersonaDTO(Persona persona) {
        if (persona == null) {
            return null;
        }
        return new PersonaDTO(
                persona.getId(),
                persona.getNombre(),
                persona.getCorreo()
        );
    }

    public static Persona toPersonaEntity(PersonaDTO dto) {
        if (dto == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setId(dto.getId());
        persona.setNombre(dto.getNombre());
        persona.setCorreo(dto.getCorreo());
        return persona;
    }

    public static List<PersonaDTO> toPersonaDTOList(List<Persona> personas) {
        return personas.stream()
                .map(EntityDTOMapper::toPersonaDTO)
                .collect(Collectors.toList());
    }

    // Libro mappings
    public static LibroDTO toLibroDTO(Libro libro) {
        if (libro == null) {
            return null;
        }
        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.isDisponible()
        );
    }

    public static Libro toLibroEntity(LibroDTO dto) {
        if (dto == null) {
            return null;
        }
        Libro libro = new Libro();
        libro.setId(dto.getId());
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setDisponible(dto.isDisponible());
        return libro;
    }

    public static List<LibroDTO> toLibroDTOList(List<Libro> libros) {
        return libros.stream()
                .map(EntityDTOMapper::toLibroDTO)
                .collect(Collectors.toList());
    }

    // Prestamo mappings
    public static PrestamoDTO toPrestamoDTO(Prestamo prestamo) {
        if (prestamo == null) {
            return null;
        }
        try {
            // Verificar que el libro y la persona no sean nulos
            if (prestamo.getLibro() == null) {
                throw new IllegalArgumentException("El libro del préstamo es nulo");
            }
            if (prestamo.getPersona() == null) {
                throw new IllegalArgumentException("La persona del préstamo es nula");
            }

            return new PrestamoDTO(
                    prestamo.getId(),
                    prestamo.getLibro().getId(),
                    prestamo.getLibro().getTitulo(),
                    prestamo.getLibro().getAutor(),
                    prestamo.getPersona().getId(),
                    prestamo.getPersona().getNombre(),
                    prestamo.getFechaPrestamo()
            );
        } catch (Exception e) {
            System.out.println("Error al convertir Prestamo a DTO: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al convertir préstamo a DTO: " + e.getMessage(), e);
        }
    }

    public static List<PrestamoDTO> getPrestamoDTOList(List<Prestamo> prestamos) {
        return prestamos.stream()
                .map(EntityDTOMapper::toPrestamoDTO)
                .collect(Collectors.toList());
    }
}

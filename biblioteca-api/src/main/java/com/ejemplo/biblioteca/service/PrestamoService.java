package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.dto.PrestamoDTO;
import com.ejemplo.biblioteca.dto.PrestamoRequestDTO;
import com.ejemplo.biblioteca.dto.PrestamoResponseDTO;
import com.ejemplo.biblioteca.mapper.EntityDTOMapper;
import com.ejemplo.biblioteca.model.Libro;
import com.ejemplo.biblioteca.model.Persona;
import com.ejemplo.biblioteca.model.Prestamo;
import com.ejemplo.biblioteca.repository.LibroRepository;
import com.ejemplo.biblioteca.repository.PersonaRepository;
import com.ejemplo.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Transactional
    public PrestamoResponseDTO crearPrestamos(PrestamoRequestDTO prestamoRequestDTO) {
        try {
            System.out.println("Buscando persona con ID: " + prestamoRequestDTO.getPersonaId());
            Optional<Persona> personaOpt = personaRepository.findById(prestamoRequestDTO.getPersonaId());
            if (!personaOpt.isPresent()) {
                throw new RuntimeException("Persona con ID " + prestamoRequestDTO.getPersonaId() + " no encontrada");
            }

            Persona persona = personaOpt.get();
            System.out.println("Persona encontrada: " + persona.getNombre());
            List<PrestamoDTO> prestamosCreados = new ArrayList<>();
            Date fechaActual = new Date();

            // Lista para almacenar los libros no disponibles
            List<String> librosNoDisponibles = new ArrayList<>();

            for (Long libroId : prestamoRequestDTO.getLibrosIds()) {
                System.out.println("Buscando libro con ID: " + libroId);
                Optional<Libro> libroOpt = libroRepository.findById(libroId);
                if (!libroOpt.isPresent()) {
                    throw new RuntimeException("Libro con ID " + libroId + " no encontrado");
                }

                Libro libro = libroOpt.get();
                System.out.println("Libro encontrado: " + libro.getTitulo() + ", disponible: " + libro.isDisponible());

                // Verificar disponibilidad del libro
                if (!libro.isDisponible()) {
                    // Agregar a la lista de libros no disponibles
                    librosNoDisponibles.add("Libro ID " + libroId + " (" + libro.getTitulo() + ")");
                    continue; // Saltar este libro y continuar con el siguiente
                }

                libro.setDisponible(false);
                libroRepository.save(libro);
                System.out.println("Libro marcado como no disponible");

                Prestamo prestamo = new Prestamo(libro, persona, fechaActual);
                System.out.println("Guardando préstamo...");
                Prestamo prestamoGuardado = prestamoRepository.save(prestamo);
                System.out.println("Préstamo guardado con ID: " + prestamoGuardado.getId());
                prestamosCreados.add(EntityDTOMapper.toPrestamoDTO(prestamoGuardado));
            }

            // Crear el objeto de respuesta
            PrestamoResponseDTO responseDTO = new PrestamoResponseDTO();
            responseDTO.setPrestamosCreados(prestamosCreados);
            responseDTO.setLibrosNoDisponibles(librosNoDisponibles);

            // Establecer el mensaje apropiado según el resultado
            if (librosNoDisponibles.isEmpty()) {
                responseDTO.setMensaje("Todos los préstamos fueron creados exitosamente");
            } else if (prestamosCreados.isEmpty()) {
                responseDTO.setMensaje("No se pudo crear ningún préstamo. Todos los libros solicitados no están disponibles");
            } else {
                responseDTO.setMensaje("Se crearon " + prestamosCreados.size() + " préstamos. " + 
                                      librosNoDisponibles.size() + " libros no estaban disponibles");
                System.out.println("Algunos libros no estaban disponibles: " + String.join(", ", librosNoDisponibles));
                System.out.println("Se crearon " + prestamosCreados.size() + " préstamos exitosamente");
            }

            return responseDTO;
        } catch (Exception e) {
            System.out.println("Error en crearPrestamos: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al crear préstamo: " + e.getMessage(), e);
        }
    }

    public List<PrestamoDTO> obtenerPrestamosPorPersona(Long personaId) {
        List<Prestamo> prestamos = prestamoRepository.findByPersonaId(personaId);
        return EntityDTOMapper.getPrestamoDTOList(prestamos);
    }

    public List<PrestamoDTO> obtenerTodosLosPrestamos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        return EntityDTOMapper.getPrestamoDTOList(prestamos);
    }

    @Transactional
    public void eliminarPrestamo(Long id) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(id);
        if (prestamoOpt.isPresent()) {
            Prestamo prestamo = prestamoOpt.get();
            Libro libro = prestamo.getLibro();
            libro.setDisponible(true);
            libroRepository.save(libro);
            prestamoRepository.deleteById(id);
        }
    }
}

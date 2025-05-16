package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.dto.PrestamoDTO;
import com.ejemplo.biblioteca.dto.PrestamoRequestDTO;
import com.ejemplo.biblioteca.dto.PrestamoResponseDTO;
import com.ejemplo.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<?> crearPrestamos(@RequestBody PrestamoRequestDTO prestamoRequestDTO) {
        try {
            // Validación manual de los campos requeridos
            if (prestamoRequestDTO.getPersonaId() == null) {
                return ResponseEntity.badRequest().body("Error: El ID de la persona es obligatorio");
            }

            if (prestamoRequestDTO.getLibrosIds() == null || prestamoRequestDTO.getLibrosIds().isEmpty()) {
                return ResponseEntity.badRequest().body("Error: Debe incluir al menos un libro");
            }

            System.out.println("Recibida solicitud de préstamo: " + prestamoRequestDTO.getPersonaId() + 
                              ", libros: " + prestamoRequestDTO.getLibrosIds());

            // Obtener la respuesta del servicio
            PrestamoResponseDTO respuesta = prestamoService.crearPrestamos(prestamoRequestDTO);

            // Si no se crearon préstamos, devolver un error
            if (respuesta.getPrestamosCreados().isEmpty()) {
                return ResponseEntity.badRequest().body(respuesta);
            }

            // Si hay libros no disponibles, agregar un encabezado de advertencia
            if (!respuesta.getLibrosNoDisponibles().isEmpty()) {
                return ResponseEntity.ok()
                    .header("X-Prestamo-Warning", "Algunos libros no estaban disponibles")
                    .body(respuesta);
            }

            // Si todo salió bien, devolver la respuesta exitosa
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            System.out.println("Error al crear préstamo: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> obtenerTodosLosPrestamos() {
        List<PrestamoDTO> prestamos = prestamoService.obtenerTodosLosPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
        try {
            prestamoService.eliminarPrestamo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

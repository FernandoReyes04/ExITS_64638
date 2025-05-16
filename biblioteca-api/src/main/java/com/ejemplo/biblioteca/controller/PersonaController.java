package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.dto.PersonaDTO;
import com.ejemplo.biblioteca.dto.PrestamoDTO;
import com.ejemplo.biblioteca.service.PersonaService;
import com.ejemplo.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<PersonaDTO> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @PostMapping
    public PersonaDTO crearPersona(@RequestBody PersonaDTO personaDTO) {
        return personaService.crearPersona(personaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.obtenerPersonaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
        PersonaDTO personaActualizada = personaService.actualizarPersona(id, personaDTO);
        if (personaActualizada != null) {
            return ResponseEntity.ok(personaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        try {
            personaService.eliminarPersona(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/prestamos")
    public ResponseEntity<List<PrestamoDTO>> obtenerPrestamosPorPersona(@PathVariable Long id) {
        List<PrestamoDTO> prestamos = prestamoService.obtenerPrestamosPorPersona(id);
        return ResponseEntity.ok(prestamos);
    }
}

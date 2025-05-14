package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.model.Prestamo;
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
    public ResponseEntity<Prestamo> crearPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo nuevoPrestamo = prestamoService.crearPrestamo(prestamo);
        return ResponseEntity.ok(nuevoPrestamo);
    }

    @GetMapping("/persona/{personaId}")
    public ResponseEntity<List<Prestamo>> obtenerPrestamosPorPersona(@PathVariable Long personaId) {
        List<Prestamo> prestamos = prestamoService.obtenerPrestamosPorPersona(personaId);
        return ResponseEntity.ok(prestamos);
    }
}
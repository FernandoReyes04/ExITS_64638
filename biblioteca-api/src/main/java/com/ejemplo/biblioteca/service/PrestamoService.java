package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Prestamo;
import com.ejemplo.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public Prestamo crearPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> obtenerPrestamosPorPersona(Long personaId) {
        return prestamoRepository.findByPersonaId(personaId);
    }

    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
}
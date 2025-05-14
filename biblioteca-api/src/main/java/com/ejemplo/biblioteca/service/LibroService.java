package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Libro;
import com.ejemplo.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizado) {
        libroActualizado.setId(id);
        return libroRepository.save(libroActualizado);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.dto.LibroDTO;
import com.ejemplo.biblioteca.mapper.EntityDTOMapper;
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

    public List<LibroDTO> obtenerTodosLosLibros() {
        List<Libro> libros = libroRepository.findAll();
        return EntityDTOMapper.toLibroDTOList(libros);
    }

    public Optional<LibroDTO> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .map(EntityDTOMapper::toLibroDTO);
    }

    public LibroDTO crearLibro(LibroDTO libroDTO) {
        Libro libro = EntityDTOMapper.toLibroEntity(libroDTO);
        Libro libroGuardado = libroRepository.save(libro);
        return EntityDTOMapper.toLibroDTO(libroGuardado);
    }

    public LibroDTO actualizarLibro(Long id, LibroDTO libroDTO) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroDTO.getTitulo());
                    libro.setAutor(libroDTO.getAutor());
                    libro.setDisponible(libroDTO.isDisponible());
                    Libro libroActualizado = libroRepository.save(libro);
                    return EntityDTOMapper.toLibroDTO(libroActualizado);
                }).orElse(null);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}

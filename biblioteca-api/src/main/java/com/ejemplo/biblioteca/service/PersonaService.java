package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Persona;
import com.ejemplo.biblioteca.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Long id, Persona nuevaPersona) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(nuevaPersona.getNombre());
                    persona.setCorreo(nuevaPersona.getCorreo());
                    return personaRepository.save(persona);
                }).orElse(null);
    }


    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.dto.PersonaDTO;
import com.ejemplo.biblioteca.mapper.EntityDTOMapper;
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

    public List<PersonaDTO> obtenerTodasLasPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return EntityDTOMapper.toPersonaDTOList(personas);
    }

    public Optional<PersonaDTO> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id)
                .map(EntityDTOMapper::toPersonaDTO);
    }

    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        Persona persona = EntityDTOMapper.toPersonaEntity(personaDTO);
        Persona personaGuardada = personaRepository.save(persona);
        return EntityDTOMapper.toPersonaDTO(personaGuardada);
    }

    public PersonaDTO actualizarPersona(Long id, PersonaDTO personaDTO) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaDTO.getNombre());
                    persona.setCorreo(personaDTO.getCorreo());
                    Persona personaActualizada = personaRepository.save(persona);
                    return EntityDTOMapper.toPersonaDTO(personaActualizada);
                }).orElse(null);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}

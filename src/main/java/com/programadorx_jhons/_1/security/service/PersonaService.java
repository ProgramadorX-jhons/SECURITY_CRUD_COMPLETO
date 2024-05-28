package com.programadorx_jhons._1.security.service;

import com.programadorx_jhons._1.security.model.Persona;
import com.programadorx_jhons._1.security.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaService implements PersonaIMPL {
    @Autowired
    private PersonaRepo data;


    @Override
    public List<Persona> listar() {
        return data.findAll();
    }

    @Override
    public Optional<Persona> listarId(Long id) {
        return data.findById(id);
    }

    @Override
    public Long save(Persona persona) {
        Persona savedPersona = data.save(persona);
        return savedPersona.getId();
    }

    @Override
    public void delete(Long id) {
        data.deleteById(id);
    }
}

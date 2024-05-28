package com.programadorx_jhons._1.security.service;

import com.programadorx_jhons._1.security.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaIMPL {

    public List<Persona> listar();
    public Optional<Persona> listarId(Long id);
    Long save(Persona persona);
    public void delete(Long id);

}

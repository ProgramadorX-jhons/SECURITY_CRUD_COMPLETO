package com.programadorx_jhons._1.security.repository;

import com.programadorx_jhons._1.security.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo extends JpaRepository<Persona, Long> {
}

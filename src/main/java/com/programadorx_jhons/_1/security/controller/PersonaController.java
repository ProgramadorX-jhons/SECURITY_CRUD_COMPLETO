package com.programadorx_jhons._1.security.controller;

import com.programadorx_jhons._1.security.model.Persona;
import com.programadorx_jhons._1.security.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private PersonaService service;

    @RequestMapping("/listar")
    public String listar(Model model){
        List<Persona> personas=service.listar();
        model.addAttribute("personas",personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona",new Persona());
        return "form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("persona") @Validated Persona persona, Model model){
        service.save(persona);
        return "redirect:/listar";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona",persona.orElse(null));
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        service.delete(id);
        return "redirect:/listar";
    }
}

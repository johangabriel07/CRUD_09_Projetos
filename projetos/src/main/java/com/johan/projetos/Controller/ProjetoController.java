package com.johan.projetos.controllers;

import com.johan.projetos.models.ProjetoModel;
import com.johan.projetos.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ProjetoModel criarProjeto(@RequestBody ProjetoModel projeto) { return projetoService.criarProjeto(projeto); }

    @GetMapping
    public List<ProjetoModel> listarProjetos() { return projetoService.findAll(); }

    @GetMapping("/{id}")
    public Optional<ProjetoModel> buscarProjetoPorId(@PathVariable Long id) { return projetoService.buscarProjetoPorId(id); }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id) { projetoService.deletarProjeto(id); }
}
package com.johan.projetos.controllers;

import com.johan.projetos.models.ProjetoModel;
import com.johan.projetos.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;
    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel){

        ProjetoModel request = projetoService.criarProjeto(projetoModel);

        URI uri = URI.create("/projetos/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }


    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> request = projetoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public void buscarProjetoPorId(@PathVariable Long id){
        projetoService.buscarProjetoPorId(id);

    }

}
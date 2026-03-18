package com.johan.projetos.services;

import com.johan.projetos.models.ProjetoModel;
import com.johan.projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoModel criarProjeto(ProjetoModel projeto) { return projetoRepository.save(projeto); }

    public List<ProjetoModel> findAll() { return projetoRepository.findAll(); }

    public Optional<ProjetoModel> buscarProjetoPorId(Long id) { return projetoRepository.findById(id); }

    public void deletarProjeto(Long id) { projetoRepository.deleteById(id); }
}
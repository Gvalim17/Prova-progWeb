package com.senac.projetoarquivo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoarquivo.entity.Projeto;
import com.senac.projetoarquivo.services.ProjetoService;

@RestController
@RequestMapping("api/projeto")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjetos(){
        List<Projeto> projetos = projetoService.getAllProjetos();
        if(projetos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projetos);
    }

    @GetMapping(value = "/obterProjetoPorId/{projetoId}")    
    public ResponseEntity<Optional<Projeto>> getProjetoporId(@PathVariable Integer projetoId){
        Optional<Projeto> projeto = projetoService.getProjetoById(projetoId);
        if(projeto.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projeto);
    }


    @PutMapping("/atualizarStatus/{projetoId}/{novoStatus}")
    public void atualizarStatus(@PathVariable int projetoId,@PathVariable int novoStatus) {
        projetoService.atualizarStatus(projetoId, novoStatus);
    }



    
}


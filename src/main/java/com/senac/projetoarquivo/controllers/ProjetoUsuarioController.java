package com.senac.projetoarquivo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoarquivo.entity.ProjetoUsuario;
import com.senac.projetoarquivo.services.ProjetoUsuarioService;


@RestController
@RequestMapping("api/projetousuario")
public class ProjetoUsuarioController {

    private final ProjetoUsuarioService projetoUsuarioService;

    public ProjetoUsuarioController(ProjetoUsuarioService projetoUsuarioService) {
        this.projetoUsuarioService = projetoUsuarioService;
    }

    @GetMapping
    public ResponseEntity<List<ProjetoUsuario>> getAllProjetoUsuarios(){
        List<ProjetoUsuario> projetoUsuarios = projetoUsuarioService.getAllProjetoUsuarios();
        if(projetoUsuarios.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projetoUsuarios);
    }

    @GetMapping(value = "obterProjetoUsuarioPorId/{projetoUsuarioId}")    
    public ResponseEntity<Optional<ProjetoUsuario>> getProjetoUsuarioporId(@PathVariable Integer projetoUsuarioId){
        Optional<ProjetoUsuario> projetoUsuario = projetoUsuarioService.getProjetoUsuarioById(projetoUsuarioId);
        if(projetoUsuario.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projetoUsuario);
    }
    
    @PostMapping("/associarProjetoAoUsuario/{usuarioId}/{projetoId}")
    public ResponseEntity<String> associarProjetoAoUsuario(@PathVariable int usuarioId, @PathVariable int projetoId) {   
        try {
            projetoUsuarioService.associarProjetoAoUsuario(usuarioId, projetoId);
            return ResponseEntity.status(HttpStatus.OK).body("Projeto associado ao usuário com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao associar projeto ao usuário: " + e.getMessage());
        }
    }
}

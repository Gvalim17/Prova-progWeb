package com.senac.projetoarquivo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoarquivo.entity.Usuario;
import com.senac.projetoarquivo.services.UsuarioService;


@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        if(usuarios.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "obterUsuarioPorId/{usuarioId}")    
    public ResponseEntity<Optional<Usuario>> getUsuarioporId(@PathVariable Integer usuarioId){
        Optional<Usuario> usuario = usuarioService.getUsuarioById(usuarioId);
        if(usuario.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuario);
    }

}

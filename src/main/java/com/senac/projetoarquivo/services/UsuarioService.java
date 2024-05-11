package com.senac.projetoarquivo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoarquivo.entity.Usuario;
import com.senac.projetoarquivo.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository _usuarioRepository) {
		this.usuarioRepository = _usuarioRepository;
	}

	@Transactional
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Optional<Usuario> getUsuarioById(int id){
        return usuarioRepository.findById(id);
    }


}

package com.senac.projetoarquivo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoarquivo.entity.Projeto;
import com.senac.projetoarquivo.entity.ProjetoUsuario;
import com.senac.projetoarquivo.entity.Usuario;
import com.senac.projetoarquivo.repository.ProjetoUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoUsuarioService {
    
    @Autowired
    private ProjetoUsuarioRepository projetoUsuarioRepository;
    
    public ProjetoUsuarioService(ProjetoUsuarioRepository _projetoUsuarioRepository) {
		this.projetoUsuarioRepository = _projetoUsuarioRepository;
	}

	@Transactional
    public List<ProjetoUsuario> getAllProjetoUsuarios(){
        return projetoUsuarioRepository.findAll();
    }

    @Transactional
    public Optional<ProjetoUsuario> getProjetoUsuarioById(int id){
        return projetoUsuarioRepository.findById(id);
    }

        @Transactional
    public void associarProjetoAoUsuario(int usuarioId, int projetoId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);

        Projeto projeto = new Projeto();
        projeto.setId(projetoId);

        ProjetoUsuario projetoUsuario = new ProjetoUsuario();
        projetoUsuario.setUsuario(usuario);
        projetoUsuario.setProjeto(projeto);
        projetoUsuario.setStatus(1);

        projetoUsuarioRepository.save(projetoUsuario);
    }

}

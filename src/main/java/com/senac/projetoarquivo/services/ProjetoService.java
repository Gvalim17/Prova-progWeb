package com.senac.projetoarquivo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoarquivo.entity.Projeto;
import com.senac.projetoarquivo.repository.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;
    
    public ProjetoService(ProjetoRepository _projetoRepository) {
		this.projetoRepository = _projetoRepository;
	}

	@Transactional
    public List<Projeto> getAllProjetos(){
        return projetoRepository.findAll();
    }

    @Transactional
    public Optional<Projeto> getProjetoById(int id){
        return projetoRepository.findById(id);
    }

    @Transactional
    public void atualizarStatus(int id, int status) {
        Projeto projeto = projetoRepository.findById(id).orElse(null);
            projeto.setStatus(status);
            projetoRepository.save(projeto);
    }



    
}

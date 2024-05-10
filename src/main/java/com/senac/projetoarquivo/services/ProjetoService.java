package com.senac.projetoarquivo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.projetoarquivo.entity.Projeto;
import com.senac.projetoarquivo.repository.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    
    public ProjetoService(ProjetoRepository _projetoRepository) {
		this.projetoRepository = _projetoRepository;
	}

	@Transactional
    public List<Projeto> getAllProjetos(){
        return projetoRepository.findAll();
    }

    @Transactional
    public Optional<Projeto> getProjetoById(long id){
        return projetoRepository.findById(id);
    }

    
}

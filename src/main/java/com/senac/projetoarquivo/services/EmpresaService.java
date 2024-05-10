package com.senac.projetoarquivo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senac.projetoarquivo.controllers.dto.response.EmpresaDtoResponse;
import com.senac.projetoarquivo.controllers.dto.response.EmpresaDtoResponse2;
import com.senac.projetoarquivo.entity.Empresa;
import com.senac.projetoarquivo.repository.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    
    
    public EmpresaService(EmpresaRepository _empresaRepository) {
		this.empresaRepository = _empresaRepository;
	}

	@Transactional
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

    @Transactional
    public List<EmpresaDtoResponse> getAllEmpresasSemProjetos(){
        List<Empresa> listEmpresas = empresaRepository.findAll();
        if (listEmpresas.isEmpty()) {
            return null;
        }
        List<EmpresaDtoResponse> listaEmpresasSemProjeto = new ArrayList<EmpresaDtoResponse>();
        for (int i=0; i<listEmpresas.size(); i++){
            EmpresaDtoResponse response = new EmpresaDtoResponse();
            response.setId(listEmpresas.get(i).getId());
            response.setNome(listEmpresas.get(i).getNome());
            listaEmpresasSemProjeto.add(response);
        }

        return listaEmpresasSemProjeto;
    }
    
    @Transactional
    public List<EmpresaDtoResponse2> getAllEmpresasComProjetos(){
        List<Empresa> listEmpresas = empresaRepository.findAll();
        if (listEmpresas.isEmpty()) {
            return null;
        }
        List<EmpresaDtoResponse2> listaEmpresasComProjeto = new ArrayList<EmpresaDtoResponse2>();
        for (int i=0; i<listEmpresas.size(); i++){
            EmpresaDtoResponse2 response = new EmpresaDtoResponse2();
            response.setNome(listEmpresas.get(i).getNome());
            response.setProjetos(listEmpresas.get(i).getProjetos());
            listaEmpresasComProjeto.add(response);
        }

        return listaEmpresasComProjeto;
    }
	
	@Transactional
    public Optional<Empresa> getEmpresaById(long id){
        return empresaRepository.findById(id);
    }
	
	@Transactional
    public Optional<Empresa> obterEmpresaPorId(long id){
        return empresaRepository.buscarEmpresaPorId(id);
    }
}

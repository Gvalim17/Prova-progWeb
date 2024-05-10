package com.senac.projetoarquivo.controllers.dto.response;

import java.util.Set;

import com.senac.projetoarquivo.entity.Projeto;

public class EmpresaDtoResponse2 {

	private String nome;
	private Set<Projeto> projetos;

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
}

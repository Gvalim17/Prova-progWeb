package com.senac.projetoarquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.projetoarquivo.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto,Long>{
    
}

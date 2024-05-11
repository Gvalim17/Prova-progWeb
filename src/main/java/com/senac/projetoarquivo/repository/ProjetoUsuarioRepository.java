package com.senac.projetoarquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.projetoarquivo.entity.ProjetoUsuario;

@Repository
public interface ProjetoUsuarioRepository extends JpaRepository<ProjetoUsuario, Integer>{

}

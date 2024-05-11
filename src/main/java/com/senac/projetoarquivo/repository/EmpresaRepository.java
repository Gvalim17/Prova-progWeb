package com.senac.projetoarquivo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.projetoarquivo.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa,Integer>{
	@Query(value = "SELECT * FROM empresa WHERE empresa_id = :id", nativeQuery = true)
	Optional <Empresa> buscarEmpresaPorId(int id);
}

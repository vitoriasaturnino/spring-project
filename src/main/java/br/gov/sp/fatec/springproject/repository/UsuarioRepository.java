package br.gov.sp.fatec.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springproject.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
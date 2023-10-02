package br.gov.sp.fatec.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springproject.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{
    
}
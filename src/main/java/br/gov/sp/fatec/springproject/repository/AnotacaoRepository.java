package br.gov.sp.fatec.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springproject.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
}
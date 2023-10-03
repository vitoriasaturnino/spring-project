package br.gov.sp.fatec.springproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "aut_id")
  private Long id;

  @Column(name = "aut_nome")
  private String nome;

  @ManyToMany(mappedBy = "autorizacoes")
  @JsonIgnore
  private List<Usuario> usuarios;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
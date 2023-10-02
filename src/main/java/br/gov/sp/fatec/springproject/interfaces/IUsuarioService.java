package br.gov.sp.fatec.springproject.interfaces;

import java.util.List;

import br.gov.sp.fatec.springproject.entity.Anotacao;
import br.gov.sp.fatec.springproject.entity.Autorizacao;

import br.gov.sp.fatec.springproject.entity.Usuario;

public interface IUsuarioService {
  public Usuario getById(Long id);
  public Usuario createUser(Usuario usuario);
  public List<Usuario> getAllUsers();
  public void associaAutorizacao(Long idUsuario, Long idAutorizacao);
  public Autorizacao novaAutorizacao(Autorizacao autorizacao);
  public Anotacao novaAnotacao(Anotacao anotacao);
}
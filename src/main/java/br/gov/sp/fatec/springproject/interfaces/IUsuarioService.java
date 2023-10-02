package br.gov.sp.fatec.springproject.interfaces;

import java.util.List;

import br.gov.sp.fatec.springproject.entity.Usuario;

public interface IUsuarioService {
  public Usuario getById(Long id);
  public Usuario createUser(Usuario usuario);
  public List<Usuario> getAllUsers();
}
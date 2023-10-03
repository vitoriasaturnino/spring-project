package br.gov.sp.fatec.springproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springproject.entity.Autorizacao;
import br.gov.sp.fatec.springproject.entity.Usuario;
import br.gov.sp.fatec.springproject.exception.UsuarioNaoEncontradoException;
import br.gov.sp.fatec.springproject.repository.UsuarioRepository;
import br.gov.sp.fatec.springproject.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepo;

  @Transactional
    public Usuario novoUsuarioAutorizacao(String nome,
        String senha, String nomeAutorizacao) {
    Usuario usuario = new Usuario(nome, senha);
    Optional<Autorizacao> autOp = autRepo.findByNome(nomeAutorizacao);
    Autorizacao autorizacao;

    if(autOp.isEmpty()) {
      autorizacao = new Autorizacao();
      autorizacao.setNome(nomeAutorizacao);
      autRepo.save(autorizacao);
    } else {
      autorizacao = autOp.get();
    }
    usuario.setAutorizacoes(new ArrayList<Autorizacao>());
    usuario.getAutorizacoes().add(autorizacao);
    
    return usuarioRepo.save(usuario);
  }

  public Usuario createUser(Usuario usuario) {
    if(usuario == null ||
        usuario.getNome() == null ||
        usuario.getSenha() == null) {
      throw new IllegalArgumentException("Nome e senha inválidos!");
    }
    return usuarioRepo.save(usuario);
  }
  public List<Usuario> getAllUsers() {
    return usuarioRepo.findAll();
  }
}
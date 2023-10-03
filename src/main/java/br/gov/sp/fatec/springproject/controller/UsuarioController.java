package br.gov.sp.fatec.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springproject.entity.Usuario;
import br.gov.sp.fatec.springproject.interfaces.IUsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

  @Autowired
  private IUsuarioService service;

  @GetMapping
  public List<Usuario> getAllUsers() {
    return service.getAllUsers();
  }
  @GetMapping(value = "/{usuario}")
  public Usuario getById(@PathVariable("usuario") Long id) {
    return service.getById(id);
  }

  @PostMapping
  public Usuario createUser(@RequestBody Usuario usuario) {
    return service.createUser(usuario);
  }
}
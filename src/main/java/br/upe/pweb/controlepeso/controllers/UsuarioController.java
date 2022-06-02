package br.upe.pweb.controlepeso.controllers;

import br.upe.pweb.controlepeso.models.Usuario;
import br.upe.pweb.controlepeso.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }



}

package br.upe.pweb.controlepeso.services;

import br.upe.pweb.controlepeso.models.Usuario;
import br.upe.pweb.controlepeso.repositories.IUsuarioRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Transactional(readOnly = false)
    public Usuario save(Usuario usuario) {
        if(usuario == null){
            throw new RuntimeException("Usuario não pode ser nulo");
        }
        usuario.setId(null);

        if(StringUtils.hasLength(usuario.getNome()) ||
                StringUtils.hasLength(usuario.getEmail()) ||
                usuario.getAltura() <= 0  ||
                usuario.getGenero() == null ||
                usuario.getPesoInicial() <= 0 ||
                usuario.getPesoFinal() <= 0 ||
                usuario.getDataFinal() == null) {
            throw new RuntimeException("Informe os campos de preenchimento obrigatório");
        }

        if(usuarioRepo.findByEmail(usuario.getEmail()) != null){
            throw new RuntimeException("Email já cadastrado");
        }

        usuario.setDataInicial(LocalDate.now());
        return usuarioRepo.save(usuario);
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepo.findById(id).get();
    }

    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }


    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioAtual = usuarioRepo.findById(id).get();
        usuarioAtual.setAltura(usuario.getAltura());
        usuarioAtual.setDataFinal(usuario.getDataFinal());
        usuarioAtual.setDataInicial(usuario.getDataInicial());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setGenero(usuario.getGenero());
        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setPesoFinal(usuario.getPesoFinal());
        usuarioAtual.setPesoInicial(usuario.getPesoInicial());
        return usuarioRepo.save(usuarioAtual);
    }
}

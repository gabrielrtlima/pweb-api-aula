package br.upe.pweb.controlepeso.repositories;

import br.upe.pweb.controlepeso.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

}

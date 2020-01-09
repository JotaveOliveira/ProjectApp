package br.com.IHelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.IHelp.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

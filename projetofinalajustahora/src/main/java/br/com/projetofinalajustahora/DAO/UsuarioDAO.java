package br.com.projetofinalajustahora.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinalajustahora.beans.Usuario;



public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	Usuario findByRacfAndSenha(String racf,String senha);
	

	
}

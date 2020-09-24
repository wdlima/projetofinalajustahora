package br.com.projetofinalajustahora.DAO;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinalajustahora.beans.Ocorrencia;



public interface OcorrenciaDAO extends CrudRepository<Ocorrencia, Integer> {
	ArrayList<Ocorrencia> findAllByStatus(int tipo);
	

}

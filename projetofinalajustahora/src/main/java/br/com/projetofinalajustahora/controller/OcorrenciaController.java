package br.com.projetofinalajustahora.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinalajustahora.DAO.OcorrenciaDAO;
import br.com.projetofinalajustahora.beans.Ocorrencia;

@CrossOrigin("*")
@RestController
public class OcorrenciaController {

	@Autowired
	private OcorrenciaDAO dao;


	@GetMapping("/ocorrencias")
	public ResponseEntity<ArrayList<Ocorrencia>> getAllOcorrencias(){
		ArrayList<Ocorrencia> lista = (ArrayList<Ocorrencia>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}


	@GetMapping("/ocorrencias/{tipo}")
	public ResponseEntity<ArrayList<Ocorrencia>> getOcorrencia(@PathVariable int tipo){
		ArrayList<Ocorrencia> resultado = (ArrayList<Ocorrencia>) dao.findAllByStatus(tipo);
		if (resultado.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resultado);
	}

	@PostMapping("/atualizarocorrencia")
	public ResponseEntity<Ocorrencia> gravar(@RequestBody Ocorrencia ocorrencia){
		try {
			dao.save(ocorrencia);
			return ResponseEntity.ok(ocorrencia);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}


	}

}
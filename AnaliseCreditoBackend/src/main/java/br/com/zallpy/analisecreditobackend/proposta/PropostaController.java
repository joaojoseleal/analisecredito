package br.com.zallpy.analisecreditobackend.proposta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zallpy.analisecreditobackend.exceptions.AnaliseCreditoException;
import br.com.zallpy.analisecreditobackend.pessoa.Pessoa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/proposta")
@Api(value = "Propostas")
public class PropostaController {
	
	@Autowired
	private PropostaService propostaService;
	
	@ApiOperation(value = "Salva uma proposta de crédito.")
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@RequestBody Pessoa pessoa) {
		try {
			propostaService.save(pessoa);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (AnaliseCreditoException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@ApiOperation(value = "Recupera todas as propostas cadastradas.")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proposta>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(propostaService.findAll());
	}
	
	@ApiOperation(value = "Deleta uma proposta de crédito.")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			propostaService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}

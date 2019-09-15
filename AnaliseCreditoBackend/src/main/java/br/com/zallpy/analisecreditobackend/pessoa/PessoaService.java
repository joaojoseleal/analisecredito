package br.com.zallpy.analisecreditobackend.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa save(Pessoa pessoa) {
		Pessoa pessoaExiste = pessoaRepository.findByCpf(pessoa.getCpf()).orElse(null);
		if (pessoaExiste != null) {
			pessoa.setId(pessoaExiste.getId());
		}
		return pessoaRepository.save(pessoa);
	}

}

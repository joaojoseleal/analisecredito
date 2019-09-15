package br.com.zallpy.analisecreditobackend.pessoa;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

	Optional<Pessoa> findByCpf(String cpf);

}

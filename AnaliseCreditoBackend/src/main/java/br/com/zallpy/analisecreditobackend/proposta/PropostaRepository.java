package br.com.zallpy.analisecreditobackend.proposta;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends MongoRepository<Proposta, String>{
	
}

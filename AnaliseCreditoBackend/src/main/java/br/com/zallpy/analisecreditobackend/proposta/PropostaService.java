package br.com.zallpy.analisecreditobackend.proposta;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zallpy.analisecreditobackend.exceptions.AnaliseCreditoException;
import br.com.zallpy.analisecreditobackend.pessoa.Pessoa;
import br.com.zallpy.analisecreditobackend.pessoa.PessoaService;
import br.com.zallpy.analisecreditobackend.proposta.enums.LimiteEnum;
import br.com.zallpy.analisecreditobackend.proposta.enums.ResultadoAnaliseEnum;
import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class PropostaService {

	private static final String RESULTADO_ANALISE_MODEL = "resultadoAnaliseModel.model";
	private static final String LIMITE_MODEL = "limiteModel.model";
	private static final String DATASET_WEKA = "analiseCredito.arff";
	
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PropostaRepository propostaRepository;

	public Proposta gerarProposta(Pessoa pessoa) {
		try {
			Proposta proposta = new Proposta();
			IBk ibkResultadoAnaliseModel = (IBk) getModel(RESULTADO_ANALISE_MODEL);
			IBk ibkLimiteModel = (IBk) getModel(LIMITE_MODEL);
			Instance instance = pessoa.getInstanceWekaByDataSet(getDataSourceWeka(DATASET_WEKA));
			Double resultadoAnaliseModel = ibkResultadoAnaliseModel.classifyInstance(instance);
			Double resultadoLimiteModel = ibkLimiteModel.classifyInstance(instance);
			proposta.setResultadoAnalise(ResultadoAnaliseEnum.values()[resultadoAnaliseModel.intValue()]);
			proposta.setLimite(LimiteEnum.values()[resultadoLimiteModel.intValue()]);
			proposta.setPessoa(pessoa);
			return proposta;
		} catch (Exception e) {
			throw new AnaliseCreditoException("Ocorreu um erro durante a predição da proposta.");
		}
	}

	public void save(Pessoa pessoa) {
		pessoa = pessoaService.save(pessoa);
		propostaRepository.save(gerarProposta(pessoa));
	}
	
	public void delete(String propostaId) {
		propostaRepository.deleteById(propostaId);
	}
	
	public List<Proposta> findAll() {
		return propostaRepository.findAll();
	}

	private Instances getDataSourceWeka(String name) {
		try {
			DataSource ds = new DataSource(new FileInputStream("src/main/resources/" + name));
			Instances instances = ds.getDataSet();
			instances.setClassIndex(instances.numAttributes() - 2);
			return instances;
		} catch (Exception e) {
			throw new AnaliseCreditoException(
					"Ocorreu um erro ao abrir o banco de dados de treinamento.", e);
		}
	}

	private Classifier getModel(String name) {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(
					"src/main/resources/models/" + name));
			Classifier cls = (Classifier) oos.readObject();
			oos.close();
			return cls;
		} catch (Exception e) {
			throw new AnaliseCreditoException(
					"Ocorreu um erro ao abrir o classificador de análise de crédito.", e);
		}

	}

}

package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.entity.Relacionamento;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.repository.RelacionamentoRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class RelacionamentoService {

	@Autowired
	RelacionamentoRepository repository;

	public void salvarRelacionamento(Solicitacao solicitacao) {
		Relacionamento relacionamento = new Relacionamento();
		relacionamento.setIdPerfil(solicitacao.getIdPerfil());
		relacionamento.setIdPerfilRelacionamento(solicitacao.getIdPerfilSolicitacao());
		relacionamento.setDtRelacionamento(new Date());
		Relacionamento relacionamentoInverso = new Relacionamento();
		relacionamentoInverso.setIdPerfil(solicitacao.getIdPerfilSolicitacao());
		relacionamentoInverso.setIdPerfilRelacionamento(solicitacao.getIdPerfil());
		relacionamentoInverso.setDtRelacionamento(new Date());
		repository.save(relacionamento);
		repository.save(relacionamentoInverso);
	}

	public List<Perfil> getAllFriends(Perfil idPerfil) {
		return repository.findByIdPerfil(idPerfil.getIdPerfil());
	}

	public List<BigDecimal> getIdFromAllFriends(Perfil perfil) {
		return repository.findIdPerfilByIdPerfilAllFriends(perfil.getIdPerfil());
	}
}

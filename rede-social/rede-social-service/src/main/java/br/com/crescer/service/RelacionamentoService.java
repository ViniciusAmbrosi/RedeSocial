package br.com.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Relacionamento;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.repository.RelacionamentoRepository;

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

    public List<BigDecimal> getIdFromAllFriends(Perfil perfil) {
        List<Relacionamento> relashionships = repository.findByIdPerfil_idPerfilEquals(perfil.getIdPerfil());
        return getProfilesIdsFromRelationships(relashionships);
    }
    
    public List<Perfil> getAllFriends(Perfil idPerfil) {
        List<Relacionamento> relashionships = repository.findByIdPerfil_idPerfilEquals(idPerfil.getIdPerfil());
        return this.getProfilesFromRelationships(relashionships);
    }
    
    private List<Perfil> getProfilesFromRelationships (List<Relacionamento> relashionships){
    	List<Perfil> friends = new ArrayList<Perfil>();
    	for(Relacionamento relashionship : relashionships){
    		friends.add(relashionship.getIdPerfilRelacionamento());
    	}
    	return friends;
    }
    
    private List<BigDecimal> getProfilesIdsFromRelationships (List<Relacionamento> relashionships){
    	List<BigDecimal> friendsIds = new ArrayList<BigDecimal>();
    	for(Relacionamento relashionship : relashionships){
    		friendsIds.add(relashionship.getIdPerfilRelacionamento().getIdPerfil());
    	}
    	return friendsIds;
    }
}

package br.com.crescer.service;

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
		relacionamento.setPerfil(solicitacao.getPerfil());
		relacionamento.setPerfilRelacionamento(solicitacao.getPerfilSolicitacao());
		relacionamento.setDataInicio(new Date());
		Relacionamento relacionamentoInverso = new Relacionamento();
		relacionamentoInverso.setPerfil(solicitacao.getPerfilSolicitacao());
		relacionamentoInverso.setPerfilRelacionamento(solicitacao.getPerfil());
		relacionamentoInverso.setDataInicio(new Date());
		repository.save(relacionamento);
		repository.save(relacionamentoInverso);
	}

    public List<Long> getIdFromAllFriends(Perfil perfil) {
        List<Relacionamento> relashionships = repository.findByPerfil_IdEquals(perfil.getId());
        return getProfilesIdsFromRelationships(relashionships);
    }
    
    public List<Perfil> getAllFriends(Long id) {
        List<Relacionamento> relashionships = repository.findByPerfil_IdEquals(id);
        return this.getProfilesFromRelationships(relashionships);
    }
    
    private List<Perfil> getProfilesFromRelationships (List<Relacionamento> relashionships){
    	List<Perfil> friends = new ArrayList<Perfil>();
    	for(Relacionamento relashionship : relashionships){
    		friends.add(relashionship.getPerfilRelacionamento());
    	}
    	return friends;
    }
    
    private List<Long> getProfilesIdsFromRelationships (List<Relacionamento> relashionships){
    	List<Long> friendsIds = new ArrayList<Long>();
    	for(Relacionamento relashionship : relashionships){
    		friendsIds.add(relashionship.getPerfilRelacionamento().getId());
    	}
    	return friendsIds;
    }
}

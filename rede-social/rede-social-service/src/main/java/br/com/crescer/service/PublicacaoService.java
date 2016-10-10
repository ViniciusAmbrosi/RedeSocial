package br.com.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.repository.PublicacaoRepository;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PublicacaoService {

    @Autowired
    PublicacaoRepository repository;

//    public PublicacaoConteudo getPublicacaoes(Perfil perfil) {
//        return repository.findByIdPerfil(perfil.getIdPerfil());
//    }

    public List<PublicacaoConteudo> getPublicacaoesFromFriends(List<Perfil> perfil) {
    	List<BigDecimal> idPerfil = new ArrayList<BigDecimal>();
    	for(Perfil perfilAux : perfil){
    		idPerfil.add(perfilAux.getIdPerfil());
    	}
        return repository.fingByIdPerfil(idPerfil);
    }
}

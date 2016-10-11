package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Publicacao;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.repository.PublicacaoConteudoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PublicacaoConteudoService {

    @Autowired
    PublicacaoConteudoRepository repository;

    public void inserir(PublicacaoConteudo conteudo) {
        repository.save(conteudo);
    }
    
    public List<PublicacaoConteudo> getPublicacaoesFromFriends(List<Perfil> perfis) {
        return repository.findAllByIdPublicacao_idPerfilInOrderByIdPublicacao_dtPublicacaoDesc(perfis);
    }
    
//    public PublicacaoConteudo getPublicacaoes(Perfil perfil) {
//        return repository.findPublicacoesUsuario(perfil);
//    }
}

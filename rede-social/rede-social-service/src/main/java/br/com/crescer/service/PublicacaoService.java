package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.repository.PublicacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PublicacaoService {

    @Autowired
    PublicacaoRepository repository;

    public PublicacaoConteudo getPublicacaoes(Perfil perfil) {
        return repository.findPublicacoesUsuario(perfil);
    }

    public List<PublicacaoConteudo> getPublicacaoesFromFriends(List<Perfil> perfil) {
        return repository.findPublicacoesFriends(perfil);
    }
}

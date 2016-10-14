package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.repository.PublicacaoConteudoRepository;
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
    
    public List<PublicacaoConteudo> getPublicacaoesFromUsers(List<Perfil> perfis) {
        return repository.findAllByPublicacao_PerfilInOrderByPublicacao_dataDesc(perfis);
    }
    
    public List<PublicacaoConteudo> getUserPosts(Long id) {
        return repository.findAllByPublicacao_Perfil_idEquals(id);
    }
}

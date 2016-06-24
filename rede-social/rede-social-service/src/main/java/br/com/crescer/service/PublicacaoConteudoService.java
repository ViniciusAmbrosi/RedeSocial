package br.com.crescer.service;

import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.repository.PublicacaoConteudoRepository;
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

}

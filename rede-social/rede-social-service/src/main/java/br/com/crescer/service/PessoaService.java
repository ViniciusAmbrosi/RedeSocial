package br.com.crescer.service;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa getPessoa(Long id) {
        return repository.findOne(id);
    }
}

package br.com.crescer.service;

import br.com.crescer.repository.RelacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class RelacionamentoService {

    @Autowired
    RelacionamentoRepository repository;
    
    
}

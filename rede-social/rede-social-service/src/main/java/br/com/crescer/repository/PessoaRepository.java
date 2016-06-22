package br.com.crescer.repository;

import br.com.crescer.entity.Pessoa;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, BigDecimal>{
    
}

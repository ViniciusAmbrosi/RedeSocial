package br.com.crescer.repository;

import br.com.crescer.entity.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

}

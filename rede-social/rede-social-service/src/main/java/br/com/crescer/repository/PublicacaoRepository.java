package br.com.crescer.repository;

import br.com.crescer.entity.Publicacao;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PublicacaoRepository extends PagingAndSortingRepository<Publicacao, Long> {


}

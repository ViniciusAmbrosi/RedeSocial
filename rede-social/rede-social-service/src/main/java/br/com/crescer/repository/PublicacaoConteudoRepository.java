package br.com.crescer.repository;

import br.com.crescer.entity.PublicacaoConteudo;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PublicacaoConteudoRepository extends PagingAndSortingRepository<PublicacaoConteudo, BigDecimal> {
    
}

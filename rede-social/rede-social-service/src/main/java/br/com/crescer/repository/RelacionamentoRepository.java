package br.com.crescer.repository;

import br.com.crescer.entity.Relacionamento;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface RelacionamentoRepository extends PagingAndSortingRepository<Relacionamento, BigDecimal>{

}

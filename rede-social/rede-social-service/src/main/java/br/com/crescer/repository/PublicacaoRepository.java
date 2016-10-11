package br.com.crescer.repository;

import br.com.crescer.entity.Publicacao;
import br.com.crescer.entity.PublicacaoConteudo;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PublicacaoRepository extends PagingAndSortingRepository<Publicacao, BigDecimal> {


}

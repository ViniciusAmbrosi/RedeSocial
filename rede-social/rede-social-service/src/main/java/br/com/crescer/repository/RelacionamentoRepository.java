package br.com.crescer.repository;

import br.com.crescer.entity.Relacionamento;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface RelacionamentoRepository extends PagingAndSortingRepository<Relacionamento, BigDecimal> {

    public List<Relacionamento> findByIdPerfilOrIdPerfilRelacionamento(BigDecimal idPerfil, BigDecimal idPerfilSolicitado);

    public List<Relacionamento> findByIdPerfil_idPerfilEquals(BigDecimal idPerfil);
}

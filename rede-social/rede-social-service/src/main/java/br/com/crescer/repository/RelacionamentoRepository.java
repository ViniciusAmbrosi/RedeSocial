package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.entity.Relacionamento;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author vinicius.ambrosi
 */
public interface RelacionamentoRepository extends PagingAndSortingRepository<Relacionamento, BigDecimal> {

    public List<Relacionamento> findByIdPerfilOrIdPerfilRelacionamento(BigDecimal idPerfil, BigDecimal idPerfilSolicitado);

    public List<Perfil> findByIdPerfil(BigDecimal idPerfil);

    public List<BigDecimal> findIdPerfilByIdPerfilAllFriends(BigDecimal idPerfil);
}

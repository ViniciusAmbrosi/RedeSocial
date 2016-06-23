package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import java.math.BigDecimal;
import java.util.List;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface SolicitacaoRepository extends PagingAndSortingRepository<Solicitacao, BigDecimal> {

    public List<Solicitacao> findByIdPerfilSolicitacao(Perfil bd);

    @Query(value = "SELECT * FROM SOLICITACAO S WHERE S.ID_PERFIL = ?1 AND S.ID_PERFIL_SOLICITACAO = ?2", nativeQuery = true)
    public Solicitacao validarExistencia(BigDecimal idPerfil, BigDecimal idPerfilSolicitacao);
}

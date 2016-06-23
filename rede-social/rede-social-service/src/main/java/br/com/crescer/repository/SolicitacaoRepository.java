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

    public List<Solicitacao> findByIdPerfilSolicitacaoAndTpStatusSolicitacao(Perfil bd, String tipo);

    public Solicitacao findOneByIdPerfilAndIdPerfilSolicitacaoAndTpStatusSolicitacaoNotLike(Perfil perfil, Perfil perfilSolicitado, String tipo);
//    select s from solicitacao s where s.idPerfil.id = :
//    @Query(value = "SELECT * FROM SOLICITACAO S WHERE S.IDPERFIL. = ?1 AND S.ID_PERFIL_SOLICITACAO = ?2", nativeQuery = true)
//    public Solicitacao validarExistencia(@BigDecimal idPerfil, BigDecimal idPerfilSolicitacao);
}

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

    public Solicitacao findOneByIdPerfilAndIdPerfilSolicitacaoAndTpStatusSolicitacaoNotLike(Perfil perfil, Perfil perfilSolicitado, String reprovado);

    public Object findOneByIdPerfilSolicitacaoAndIdPerfilAndTpStatusSolicitacaoNotLike(Perfil idPerfil, Perfil idPerfilSolicitacao, String reprovado);
}

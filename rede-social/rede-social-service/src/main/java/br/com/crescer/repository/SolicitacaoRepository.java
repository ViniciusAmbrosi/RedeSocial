package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface SolicitacaoRepository extends PagingAndSortingRepository<Solicitacao, Long> {

    public List<Solicitacao> findByPerfilSolicitacaoAndTipoStatus(Perfil bd, String tipo);

    public Solicitacao findOneByPerfilAndPerfilSolicitacaoAndTipoStatusNotLike(Perfil perfil, Perfil perfilSolicitado, String reprovado);

    public Object findOneByPerfilSolicitacaoAndPerfilAndTipoStatusNotLike(Perfil perfil, Perfil perfilSolicitacao, String reprovado);
}

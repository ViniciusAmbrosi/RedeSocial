package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Publicacao;
import br.com.crescer.entity.PublicacaoConteudo;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author vinicius.ambrosi
 */
public interface PublicacaoRepository extends PagingAndSortingRepository<Publicacao, BigDecimal> {

    @Query("SELECT pc FROM PublicacaoConteudo pc JOIN pc.idPublicacao pu WHERE pu.idPerfil = :perfil ORDER BY pu.dtPublicacao DESC")
    PublicacaoConteudo findPublicacoesUsuario(@Param("perfil") Perfil perfis);

    @Query("SELECT pc FROM PublicacaoConteudo pc JOIN pc.idPublicacao pu WHERE pu.idPerfil IN :perfis ORDER BY pu.dtPublicacao DESC")
    List<PublicacaoConteudo> findPublicacoesFriends(@Param("perfis") List<Perfil> perfis);
}

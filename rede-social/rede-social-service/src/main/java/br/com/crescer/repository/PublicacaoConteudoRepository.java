package br.com.crescer.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;

/**
 * @author vinicius.ambrosi
 */
public interface PublicacaoConteudoRepository extends PagingAndSortingRepository<PublicacaoConteudo, BigDecimal> {
    
	public List<PublicacaoConteudo> findAllByIdPublicacao_idPerfilInOrderByIdPublicacao_dtPublicacaoDesc(List<Perfil> perfisId);
	
//    @Query("SELECT pc FROM PublicacaoConteudo pc JOIN pc.idPublicacao pu WHERE pu.idPerfil = :perfil ORDER BY pu.dtPublicacao DESC")
//    public PublicacaoConteudo findPublicacoesUsuario(@Param("perfil") Perfil perfis);
	//TODO: implementar busca de publicações do usuario
}

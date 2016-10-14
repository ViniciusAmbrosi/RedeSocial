package br.com.crescer.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;

/**
 * @author vinicius.ambrosi
 */
public interface PublicacaoConteudoRepository extends PagingAndSortingRepository<PublicacaoConteudo, Long> {
    
	public List<PublicacaoConteudo> findAllByPublicacao_PerfilInOrderByPublicacao_dataDesc(List<Perfil> perfis);
	
	public List<PublicacaoConteudo> findAllByPublicacao_Perfil_idEquals(Long id);
}

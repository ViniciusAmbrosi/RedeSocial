package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, BigDecimal> {

    Perfil findOneByDsEmail(String email);

    List<Perfil> findByPessoaIdPessoa_idPessoaNotInAndPessoaIdPessoa_nmPessoaContainingIgnoreCase(Collection<BigDecimal> amigos, String filtro);
    
    List<Perfil> findByPessoaIdPessoa_idPessoaNotIn(Collection<BigDecimal> amigos);
}

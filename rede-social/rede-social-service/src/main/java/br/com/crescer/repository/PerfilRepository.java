package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, Long> {

    Perfil findOneByEmail(String email);

    List<Perfil> findByPessoa_idNotInAndPessoa_nomeContainingIgnoreCase(Collection<Long> amigos, String filtro);
    
    List<Perfil> findByPessoa_idNotIn(Collection<Long> amigos);
}

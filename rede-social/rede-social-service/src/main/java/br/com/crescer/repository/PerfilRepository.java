package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author vinicius.ambrosi
 */
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, Long>{
    Perfil findOneByDsEmail(String email);
}

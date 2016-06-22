package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author vinicius.ambrosi
 */
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, BigDecimal>{
    Perfil findOneByDsEmail(String email);
}

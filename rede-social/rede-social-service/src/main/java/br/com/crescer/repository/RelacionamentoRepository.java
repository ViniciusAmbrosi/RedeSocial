package br.com.crescer.repository;

import br.com.crescer.entity.Relacionamento;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vinicius.ambrosi
 */
public interface RelacionamentoRepository extends PagingAndSortingRepository<Relacionamento, Long> {

    public List<Relacionamento> findByPerfil_IdOrPerfilRelacionamento_Id(Long id, Long idPerfilSolicitado);

    public List<Relacionamento> findByPerfil_IdEquals(Long id);
}

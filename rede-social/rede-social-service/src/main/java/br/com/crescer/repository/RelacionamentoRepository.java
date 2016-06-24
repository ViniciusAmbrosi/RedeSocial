package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.entity.Relacionamento;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author vinicius.ambrosi
 */
public interface RelacionamentoRepository extends PagingAndSortingRepository<Relacionamento, BigDecimal> {

    public List<Relacionamento> findByIdPerfilOrIdPerfilRelacionamento(BigDecimal idPerfil, BigDecimal idPerfilSolicitado);

    @Query("SELECT pe FROM Relacionamento res JOIN res.idPerfilRelacionamento pe WHERE res.idPerfil = :idPerfil")
    public List<Perfil> findAllFriends(@Param("idPerfil") Perfil idPerfil);

    @Query("SELECT pe.pessoaIdPessoa.idPessoa FROM Relacionamento res JOIN res.idPerfil pe WHERE res.idPerfil = :idPerfil")
    public List<BigDecimal> findIdAllFriends(@Param("idPerfil") Perfil idPerfil);
}

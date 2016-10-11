package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PerfilRepository;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PerfilService {

    @Autowired
    PerfilRepository repository;

    public Perfil findOneByEmail(String email) {
        return repository.findOneByDsEmail(email);
    }

    public Perfil getPerfil(BigDecimal bd) {
        return repository.findOne(bd);
    }

    public List<Perfil> getNotFriendsByName(Collection<BigDecimal> amigos, String filtro) {
        return repository.findByPessoaIdPessoa_idPessoaNotInAndPessoaIdPessoa_nmPessoaContainingIgnoreCase(amigos, filtro);
    }
    
    public List<Perfil> getNotFriends(Collection<BigDecimal> amigos){
        return repository.findByPessoaIdPessoa_idPessoaNotIn(amigos);
    }

    public void inserir(Perfil perfil) {
        repository.save(perfil);
    }
    
}

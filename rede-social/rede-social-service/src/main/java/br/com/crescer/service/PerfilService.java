package br.com.crescer.service;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.crescer.entity.Perfil;
import br.com.crescer.repository.PerfilRepository;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PerfilService {

    @Autowired
    PerfilRepository repository;

    public Perfil findOneByEmail(String email) {
        return repository.findOneByEmail(email);
    }

    public Perfil getPerfil(Long bd) {
        return repository.findOne(bd);
    }

    public List<Perfil> getNotFriendsByName(Collection<Long> amigos, String filtro) {
        return repository.findByPessoa_idNotInAndPessoa_nomeContainingIgnoreCase(amigos, filtro);
    }
    
    public List<Perfil> getNotFriends(Collection<Long> amigos){
        return repository.findByPessoa_idNotIn(amigos);
    }

    public void inserir(Perfil perfil) {
        repository.save(perfil);
    }
    
}

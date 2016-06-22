package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PerfilRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class PerfilService {

    @Autowired
    PerfilRepository repository;

    public Perfil findOneByEmail(String email){
        return repository.findOneByDsEmail(email);
    }
    
    public Perfil getPerfil (BigDecimal bd){
        return repository.findOne(bd);
    }
    
//    public Iterable<Usuario> findAll() {
//        return repository.findAll();
//    }
//
//    public Usuario save(Usuario p) {
//        return repository.save(p);
//    }
//
//    public void delete(Long id) {
//        repository.delete(id);
//    }
//
//    public Perfil findById(BigDecimal id) {
//        return repository.findOne(id);
//    }

    public void inserir(Perfil perfil) {
        repository.save(perfil);
    }
}

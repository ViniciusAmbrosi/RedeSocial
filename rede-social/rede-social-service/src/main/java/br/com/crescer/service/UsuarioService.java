package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class UsuarioService {

    @Autowired
    PerfilRepository repository;

    public Perfil findOneByEmail(String email){
        return repository.findOneByDsEmail(email);
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
//    public Usuario findById(Long id) {
//        return repository.findOne(id);
//    }

    public void inserir(Perfil perfil) {
        repository.save(perfil);
    }
}

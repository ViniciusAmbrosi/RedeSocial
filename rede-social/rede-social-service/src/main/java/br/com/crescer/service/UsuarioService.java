package br.com.crescer.service;

import br.com.crescer.entity.Usuario;
import br.com.crescer.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class UsuarioService {

//    @Autowired
//    UsuarioRepository repository;

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

    public Usuario findByEmail(String email) {
        return UsuarioRepository.findByEmail(email);
    }
}

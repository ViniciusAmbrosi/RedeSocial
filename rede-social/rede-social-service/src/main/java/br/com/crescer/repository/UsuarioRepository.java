package br.com.crescer.repository;

import br.com.crescer.entity.Usuario;


/**
 * @author vinicius.ambrosi
 */
public class UsuarioRepository  {

    public static Usuario findByEmail(String email){
        Usuario p = new Usuario();
        p.setEmail("marotao");
        p.setSenha("marotao");
        return p;
    };
    
}

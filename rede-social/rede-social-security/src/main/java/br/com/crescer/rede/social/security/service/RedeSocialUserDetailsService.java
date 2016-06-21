package br.com.crescer.rede.social.security.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.UsuarioService;
import br.com.crescer.social.security.enumeration.SocialRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class RedeSocialUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService usuarioServico;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }
        Perfil perfil = usuarioServico.findOneByEmail(email);
        return new UserModel(perfil.getDsEmail(), perfil.getDsSenha(), 
                SocialRoles.valuesToList(), perfil.getPessoaIdPessoa().getNmPessoa());
    }
}

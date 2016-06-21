package br.com.crescer.rede.social.security.service;

import br.com.crescer.entity.Usuario;
import br.com.crescer.service.UsuarioService;
import br.com.crescer.social.security.enumeration.SocialRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        Usuario p = usuarioServico.findByEmail(email);
        return new User(p.getEmail(), new BCryptPasswordEncoder().encode(p.getSenha()), SocialRoles.valuesToList());
    }
}

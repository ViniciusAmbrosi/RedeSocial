package br.com.crescer.rede.social.security.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.social.security.enumeration.SocialRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class RedeSocialUserDetailsService implements UserDetailsService {

    @Autowired
    PerfilService usuarioServico;

    @Override
    public UserModel loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }
        Perfil perfil = usuarioServico.findOneByEmail(email);
        Pessoa pessoa = perfil.getPessoaIdPessoa();
        return new UserModel(perfil.getDsEmail(), perfil.getDsSenha(), 
                SocialRoles.valuesToList(), pessoa.getNmPessoa(), pessoa.getIdPessoa(), 
                perfil.getDsEmail(), pessoa.getDtNascPessoa(), pessoa.getTpSexoPessoa());
    }
}

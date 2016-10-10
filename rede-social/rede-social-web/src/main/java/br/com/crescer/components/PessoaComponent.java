package br.com.crescer.components;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import br.com.crescer.entity.Perfil;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;

@Component
public class PessoaComponent {

    private static final String EMAIL = "email";
    private static final String NOME = "nome";
    private static final String ID_PERFIL = "idPerfil";
    private static final String ID_PESSOA = "idPessoa";
    private static final String OUTRO_PERFIL = "outroPerfil";
	
	@Autowired
	PerfilService servicePerfil;
	
	public void createTabelaPessoa(BigDecimal idPerfil, Model model){
        final UserModel usuarioLogado;
        usuarioLogado = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		final Perfil perfil; 
		perfil = servicePerfil.getPerfil(idPerfil);
		
		final boolean outroPerfil; 
		outroPerfil = idPerfil.equals(usuarioLogado.getId());
		
		model.addAttribute(EMAIL, perfil.getDsEmail());
		model.addAttribute(NOME, perfil.getPessoaIdPessoa().getNmPessoa());
		model.addAttribute(ID_PERFIL, perfil.getIdPerfil());
		model.addAttribute(ID_PESSOA, perfil.getPessoaIdPessoa().getIdPessoa());
		model.addAttribute(OUTRO_PERFIL, outroPerfil);
	}
}

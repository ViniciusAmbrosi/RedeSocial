package br.com.crescer.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.PublicacaoService;
import br.com.crescer.service.RelacionamentoService;

/**
 * @author vinicius.ambrosi
 */

@Component
public class PublicacaoComponent {

	@Autowired
	PerfilService servicePerfil;
	
	@Autowired
	RelacionamentoService serviceRelacionamento;
	
	@Autowired
	PublicacaoService servicePublicacao;
	
	public void createPublicacoes(Model model){
        UserModel usuarioLogado
		        = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Perfil usuario = servicePerfil.getPerfil(usuarioLogado.getId());
		//TODO: revisar lógica para buscar posts de amigos e usuario
		List<Perfil> amigos = serviceRelacionamento.getAllFriends(usuario);
		amigos.add(usuario);
		List<PublicacaoConteudo> publicacoesAmigos = servicePublicacao.getPublicacaoesFromFriends(amigos);
		model.addAttribute("publicacao", new PublicacaoConteudo());
		model.addAttribute("publicacoesAmigos", publicacoesAmigos);
	}

}

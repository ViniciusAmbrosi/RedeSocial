package br.com.crescer.components;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PublicacaoConteudoService;
import br.com.crescer.service.RelacionamentoService;
import br.com.crescer.extensions.UserModelExtensions;

/**
 * @author vinicius.ambrosi
 */

@Component
public class PublicacaoComponent {

	private static final String PUBLICACAO = "publicacao";
	private static final String PUBLICACOES = "publicacoesAmigos";
	
	@Autowired
	RelacionamentoService serviceRelacionamento;
	
	@Autowired
	PublicacaoConteudoService servicePublicacaoConteudo;
	
	public void createPublicacoes(Model model){
        final UserModel usuarioLogado;
        usuarioLogado = UserModelExtensions.getUsuarioLogado();
        
		final List<Perfil> usuarios;
		usuarios = serviceRelacionamento.getAllFriends(usuarioLogado.getId());
		usuarios.add(UserModelExtensions.fromModel(usuarioLogado));
		
		final List<PublicacaoConteudo> publicacoes;
		publicacoes = servicePublicacaoConteudo.getPublicacaoesFromUsers(usuarios);
		
		popularPublicacoes(model, publicacoes);
	}
	
	public void createMyProfilePosts(Model model){
        final UserModel usuarioLogado;
        usuarioLogado = UserModelExtensions.getUsuarioLogado();
        
        final List<PublicacaoConteudo> publicacoes;
        publicacoes = servicePublicacaoConteudo.getUserPosts(usuarioLogado.getId());
        
        popularPublicacoes(model, publicacoes);
	}
	
	private void popularPublicacoes(Model model, List<PublicacaoConteudo> publicacoes){
		model.addAttribute(PUBLICACAO, new PublicacaoConteudo());
		model.addAttribute(PUBLICACOES, publicacoes);
	}
}

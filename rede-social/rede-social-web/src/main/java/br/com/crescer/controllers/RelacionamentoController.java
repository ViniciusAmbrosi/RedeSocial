package br.com.crescer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.crescer.components.HeaderComponent;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.service.RelacionamentoService;
import br.com.crescer.service.SolicitacaoService;

/**
 * @author vinicius.ambrosi
 */
@Controller
public class RelacionamentoController {

	@Autowired
	RelacionamentoService serviceRelacionamento;

	@Autowired
	SolicitacaoService serviceSolicitacao;

	@Autowired
	private HeaderComponent componentHeader;

	@RequestMapping(value = "/adicionar/amigo/aceitar", method = RequestMethod.POST)
	public String aceitarAmigo(Long idPerfil, Model model) {
		Solicitacao solicitacao = serviceSolicitacao.getById(idPerfil);
		serviceRelacionamento.salvarRelacionamento(solicitacao);
		serviceSolicitacao.alterarStatusAprovado(solicitacao);
		componentHeader.createHeader(model, idPerfil);
		return "header";
	}

	@RequestMapping(value = "/perfil/amigos", method = RequestMethod.GET)
	public String amigos(Long idPerfil, Model model) {
		List<Perfil> perfis = serviceRelacionamento.getAllFriends(idPerfil);
		model.addAttribute("perfis", perfis);
		return "amigos";
	}
}

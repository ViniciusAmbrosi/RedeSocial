package br.com.crescer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.crescer.components.PublicacaoComponent;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.SolicitacaoService;

/**
 * @author vinicius.ambrosi
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    PessoaController pessoaController; //TODO: refatorar para component
    
    @Autowired
    SolicitacaoService serviceSolicitacao;
    
    @Autowired
    PerfilService servicePerfil;
    
    @Autowired
    HeaderComponent componentHeader;
    
    @Autowired
    PublicacaoComponent componentPublicacao;
    

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        pessoaController.tabelaPessoa(usuarioLogado.getId(), model);
        componentHeader.createHeader(model, usuarioLogado.getId());
        componentPublicacao.createPublicacoes(model);
        return "home";
    }
}

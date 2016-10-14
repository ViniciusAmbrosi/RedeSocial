package br.com.crescer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.crescer.components.HeaderComponent;
import br.com.crescer.components.PessoaComponent;
import br.com.crescer.components.PublicacaoComponent;
import br.com.crescer.extensions.UserModelExtensions;
import br.com.crescer.rede.social.security.model.UserModel;

/**
 * @author vinicius.ambrosi
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HeaderComponent componentHeader;
    
    @Autowired
    private PublicacaoComponent componentPublicacao;
    
    @Autowired
    private PessoaComponent componentPessoa;
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        UserModel usuarioLogado = UserModelExtensions.getUsuarioLogado();
        componentPessoa.createTabelaPessoa(usuarioLogado.getId(), model);
        componentHeader.createHeader(model, usuarioLogado.getId());
        componentPublicacao.createPublicacoes(model);
        return "home";
    }
}

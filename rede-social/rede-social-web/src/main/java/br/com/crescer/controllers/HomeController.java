package br.com.crescer.controllers;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.SolicitacaoService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vinicius.ambrosi
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    PessoaController pessoaController;
    
    @Autowired
    SolicitacaoService serviceSolicitacao;
    
    @Autowired
    PerfilService servicePerfil;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model m) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        pessoaController.tabelaPessoa(usuarioLogado.getId(), m);
        header(usuarioLogado.getId(), m);
        return "home";
    }
    
    public String header(BigDecimal bd, Model m){
        Perfil perfil = servicePerfil.getPerfil(bd);
        List<Solicitacao> solicitacoes = serviceSolicitacao.getSolicitacoes(perfil);
        m.addAttribute("solicitacoes", solicitacoes);
        m.addAttribute("solicitacoesAmizade", solicitacoes.size());
        return "header";
    }
}

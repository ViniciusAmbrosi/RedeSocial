package br.com.crescer.controllers;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.PessoaService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vinicius.ambrosi
 */
@Controller
public class PessoaController {

    @Autowired
    PessoaService servicePessoa;

    @Autowired
    PerfilService servicePerfil;

    @RequestMapping(value = "/home/menu-lateral")
    public String home(Model m) {
        return "lateral-pessoa";
    }

    @RequestMapping(value = "/perfil")
    public String perfil(BigDecimal idPessoa, BigDecimal idPerfil, Model model) {
        Pessoa p = servicePessoa.getPessoa(idPessoa);
        tabelaPessoa(idPerfil, model);
        model.addAttribute("pessoa", p);
        return "perfil";
    }

    public String tabelaPessoa(BigDecimal bd, Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Perfil perfil = servicePerfil.getPerfil(bd);
        boolean outroPerfil = bd.equals(usuarioLogado.getId());
        model.addAttribute("email", perfil.getDsEmail());
        model.addAttribute("nome", perfil.getPessoaIdPessoa().getNmPessoa());
        model.addAttribute("idPerfil", perfil.getIdPerfil());
        model.addAttribute("idPessoa", perfil.getPessoaIdPessoa().getIdPessoa());
        model.addAttribute("outroPerfil", outroPerfil);
        return "home-tabela-pessoa";
    }
}

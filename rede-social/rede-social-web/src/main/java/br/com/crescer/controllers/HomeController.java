package br.com.crescer.controllers;

import br.com.crescer.rede.social.security.model.UserModel;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model m) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        pessoaController.tabelaPessoa(usuarioLogado.getId(), m);
        return "home";
    }
}

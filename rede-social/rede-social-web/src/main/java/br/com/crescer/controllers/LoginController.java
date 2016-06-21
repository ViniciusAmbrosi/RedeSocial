package br.com.crescer.controllers;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vinicius.ambrosi
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(Model m) {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login?logout";
    }

    @RequestMapping(value = "/cadastrar")
    public String cadastrar(Usuario usuario, Model model) {
        model.addAttribute("usuario", usuario == null ? new Usuario() : usuario);
        return "cadastro";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String registrar(Perfil usuario) {
        return "cadastro";
    }
}

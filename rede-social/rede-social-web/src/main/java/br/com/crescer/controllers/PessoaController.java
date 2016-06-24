package br.com.crescer.controllers;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.PessoaService;
import br.com.crescer.service.RelacionamentoService;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
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

    @Autowired
    HeaderComponent component;

    @Autowired
    RelacionamentoService serviceRelacionamento;

    @RequestMapping(value = "/home/menu-lateral")
    public String home(Model m) {
        return "lateral-pessoa";
    }

    @RequestMapping(value = "/perfil")
    public String perfil(BigDecimal idPessoa, BigDecimal idPerfil, Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Pessoa p = servicePessoa.getPessoa(idPessoa);
        tabelaPessoa(idPerfil, model);
        model.addAttribute("pessoa", p);
        component.createHeader(model, usuarioLogado.getId());
        return "perfil";
    }

    public String tabelaPessoa(BigDecimal idPerfil, Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Perfil perfil = servicePerfil.getPerfil(idPerfil);
        boolean outroPerfil = idPerfil.equals(usuarioLogado.getId());
        model.addAttribute("email", perfil.getDsEmail());
        model.addAttribute("nome", perfil.getPessoaIdPessoa().getNmPessoa());
        model.addAttribute("idPerfil", perfil.getIdPerfil());
        model.addAttribute("idPessoa", perfil.getPessoaIdPessoa().getIdPessoa());
        model.addAttribute("outroPerfil", outroPerfil);
        return "home-tabela-pessoa";
    }

    @RequestMapping(value = "/buscar/pessoas/nome")
    public String buscarPessoasNaoConhecidasPorNome(String nome, Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BigDecimal> amigos = serviceRelacionamento.getIdFromAllFriends(servicePerfil.getPerfil(usuarioLogado.getId()));
        amigos.add(new BigDecimal(0));
        List<Perfil> notFriends = servicePerfil.getNotFriendsByName(amigos, nome);
        model.addAttribute("usuarios", notFriends);
        return "resultado-busca-perfil";
    }

    @RequestMapping(value = "/buscar/pessoas")
    public String buscarPessoasNaoConhecidas(Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BigDecimal> amigos = serviceRelacionamento.getIdFromAllFriends(servicePerfil.getPerfil(usuarioLogado.getId()));
        amigos.add(new BigDecimal(0));
        List<Perfil> notFriends = servicePerfil.getNotFriends(amigos);
        model.addAttribute("usuarios", notFriends);
        return "resultado-busca-perfil";
    }
}

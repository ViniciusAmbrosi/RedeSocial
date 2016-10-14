package br.com.crescer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.crescer.components.HeaderComponent;
import br.com.crescer.components.PessoaComponent;
import br.com.crescer.components.PublicacaoComponent;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.extensions.UserModelExtensions;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.PessoaService;
import br.com.crescer.service.RelacionamentoService;

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
    RelacionamentoService serviceRelacionamento;
    
    @Autowired
    private PessoaComponent componentPessoa;
    
    @Autowired
    private HeaderComponent componentHeader;
    
    @Autowired
    private PublicacaoComponent componentPublicacao;
    
    @RequestMapping(value = "/home/menu-lateral")
    public String home(Model m) {
        return "lateral-pessoa";
    }
    
    @RequestMapping(value = "/perfil")
    public String perfil(Long idPessoa, Long idPerfil, Model model) {
        UserModel usuarioLogado = UserModelExtensions.getUsuarioLogado();
        Pessoa usuario = servicePessoa.getPessoa(idPessoa);
        model.addAttribute("pessoa", usuario);
        componentPessoa.createTabelaPessoa(idPerfil, model);
        componentHeader.createHeader(model, usuarioLogado.getId());
        componentPublicacao.createMyProfilePosts(model);
        return "perfil";
    }

    public String tabelaPessoa(Long idPerfil, Model model) {
    	componentPessoa.createTabelaPessoa(idPerfil, model);
        return "home-tabela-pessoa";
    }

    @RequestMapping(value = "/buscar/pessoas/nome")
    public String buscarPessoasNaoConhecidasPorNome(String nome, Model model) {
        UserModel usuarioLogado = UserModelExtensions.getUsuarioLogado();
        List<Long> amigos = serviceRelacionamento.getIdFromAllFriends(servicePerfil.getPerfil(usuarioLogado.getId()));
        amigos.add(usuarioLogado.getId());
        List<Perfil> notFriends = servicePerfil.getNotFriendsByName(amigos, nome);
        model.addAttribute("usuarios", notFriends);
        return "resultado-busca-perfil";
    }

    @RequestMapping(value = "/buscar/pessoas")
    public String buscarPessoasNaoConhecidas(Model model) {
        UserModel usuarioLogado = UserModelExtensions.getUsuarioLogado();
        List<Long> amigos = serviceRelacionamento.getIdFromAllFriends(servicePerfil.getPerfil(usuarioLogado.getId()));
        amigos.add(usuarioLogado.getId());
        List<Perfil> notFriends = servicePerfil.getNotFriends(amigos);
        model.addAttribute("usuarios", notFriends);
        return "resultado-busca-perfil";
    }
}

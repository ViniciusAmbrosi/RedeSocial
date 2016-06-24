package br.com.crescer.controllers;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Publicacao;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.PublicacaoConteudoService;
import br.com.crescer.service.PublicacaoService;
import br.com.crescer.service.RelacionamentoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vincius.ambrosi
 */
@Controller
public class PublicacaoController {

    @Autowired
    PublicacaoService servicePublicacao;

    @Autowired
    PublicacaoConteudoService serviceConteudo;

    @Autowired
    RelacionamentoService serviceRelacionamento;

    @Autowired
    PerfilService servicePerfil;

    @RequestMapping(value = "/publicacoes/publicar", method = RequestMethod.POST)
    public String publlicar(String post, Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PublicacaoConteudo conteudo = new PublicacaoConteudo();
        conteudo.setConteudo(post);
        conteudo.setIdPublicacao(new Publicacao());
        conteudo.getIdPublicacao().setDtPublicacao(new Date());
        conteudo.getIdPublicacao().setTpPublicacao("POST");
        conteudo.getIdPublicacao().setIdPerfil(servicePerfil.getPerfil(usuarioLogado.getId()));
        serviceConteudo.inserir(conteudo);
        getPublicacoesTimeline(model);
        return "publicacoes";
    }

//    @RequestMapping(value = "/publicacoes", method = RequestMethod.GET)
//    public String getPublicacoesPerfil(Model model) {
//        return "publicacoes";
//    }
    @RequestMapping(value = "/timeline", method = RequestMethod.GET)
    public String getPublicacoesTimeline(Model model) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Perfil usuario = servicePerfil.getPerfil(usuarioLogado.getId());
        List<Perfil> amigos = serviceRelacionamento.getAllFriends(usuario);
        amigos.add(usuario);
        List<PublicacaoConteudo> publicacoesAmigos = servicePublicacao.getPublicacaoesFromFriends(amigos);
        model.addAttribute("publicacao", new PublicacaoConteudo());
        model.addAttribute("publicacoesAmigos", publicacoesAmigos);
        return "publicacoes";
    }
}

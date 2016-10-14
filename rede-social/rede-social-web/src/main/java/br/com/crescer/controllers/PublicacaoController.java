package br.com.crescer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.crescer.components.PublicacaoComponent;
import br.com.crescer.entity.PublicacaoConteudo;
import br.com.crescer.extensions.PublicacaoConteudoExtensions;
import br.com.crescer.extensions.UserModelExtensions;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.PublicacaoConteudoService;

/**
 * @author vincius.ambrosi
 */
@Controller
public class PublicacaoController {

    @Autowired
    PublicacaoConteudoService servicePublicacaoConteudo;

    @Autowired
    PerfilService servicePerfil;
    
    @Autowired
    private PublicacaoComponent componentPublicacao;

    @RequestMapping(value = "/publicacoes/publicar", method = RequestMethod.POST)
    public String publlicar(String post, Model model) {
        UserModel usuarioLogado = UserModelExtensions.getUsuarioLogado();
        PublicacaoConteudo conteudo = PublicacaoConteudoExtensions.generatePublicacao(post);
        conteudo.getPublicacao().setPerfil(UserModelExtensions.fromModel(usuarioLogado));
        servicePublicacaoConteudo.inserir(conteudo);
        componentPublicacao.createPublicacoes(model);
        return "publicacoes";
    }

    @RequestMapping(value = "/timeline", method = RequestMethod.GET)
    public String getPublicacoesTimeline(Model model) {
    	componentPublicacao.createPublicacoes(model);
        return "publicacoes";
    }
}

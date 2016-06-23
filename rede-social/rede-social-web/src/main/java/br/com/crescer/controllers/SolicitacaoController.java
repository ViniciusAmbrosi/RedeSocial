package br.com.crescer.controllers;

import br.com.crescer.entity.Solicitacao;
import br.com.crescer.rede.social.security.model.UserModel;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.SolicitacaoService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vinicius.ambrosi
 */
@Controller
public class SolicitacaoController {

    @Autowired
    SolicitacaoService serviceSolicitacao;

    @Autowired
    PerfilService servicePerfil;
    
    @Autowired 
    private HeaderComponent component;

    @ResponseBody
    @RequestMapping(value = "/adicionar/amigo", method = RequestMethod.POST)
    private BigDecimal cadastrarSolicitacao(BigDecimal id, Model m) {
        UserModel usuarioLogado
                = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setIdPerfil(servicePerfil.getPerfil(usuarioLogado.getId()));
        solicitacao.setIdPerfilSolicitacao(servicePerfil.getPerfil(id));
        solicitacao.setTpStatusSolicitacao("PENDENTE");
        if (serviceSolicitacao.validaExistencia(solicitacao)) {
            serviceSolicitacao.inserir(solicitacao);
            return id;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @RequestMapping(value = "/adicionar/amigo/rejeitar", method = RequestMethod.POST)
    private String rejeitarAmigo(BigDecimal idPerfil, Model model){
        Solicitacao solicitacao = serviceSolicitacao.getById(idPerfil);
        serviceSolicitacao.alterarStatusRejeitado(solicitacao);
        component.createHeader(model, idPerfil);
        return "header";
    }
}

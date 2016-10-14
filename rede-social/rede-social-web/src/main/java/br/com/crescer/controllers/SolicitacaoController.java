package br.com.crescer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.crescer.components.HeaderComponent;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.extensions.SolicitacaoExtensions;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.SolicitacaoService;

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
    private HeaderComponent componentHeader;

    @ResponseBody
    @RequestMapping(value = "/adicionar/amigo", method = RequestMethod.POST)
    private Long cadastrarSolicitacao(Long id, Model m) {
    	Solicitacao solicitacao = SolicitacaoExtensions.criarSolicitacaoPendente();
    	solicitacao.setPerfilSolicitacao(servicePerfil.getPerfil(id));
        if (serviceSolicitacao.validaExistencia(solicitacao)) {
            serviceSolicitacao.inserir(solicitacao);
            return id;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @RequestMapping(value = "/adicionar/amigo/rejeitar", method = RequestMethod.POST)
    private String rejeitarAmigo(Long idPerfil, Model model) {
        Solicitacao solicitacao = serviceSolicitacao.getById(idPerfil);
        serviceSolicitacao.alterarStatusRejeitado(solicitacao);
        componentHeader.createHeader(model, idPerfil);
        return "header";
    }
}

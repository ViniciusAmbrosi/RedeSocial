package br.com.crescer.controllers;

import br.com.crescer.entity.Solicitacao;
import br.com.crescer.service.RelacionamentoService;
import br.com.crescer.service.SolicitacaoService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vinicius.ambrosi
 */
@Controller 
public class RelacionamentoController {

    @Autowired 
    private HeaderComponent component;
    
    @Autowired
    RelacionamentoService serviceRelacionamento;
    
    @Autowired
    SolicitacaoService serviceSolicitacao;
    
    @RequestMapping(value = "/adicionar/amigo/aceitar", method = RequestMethod.POST)
    public String aceitarAmigo(BigDecimal idPerfil, Model model) {
        Solicitacao solicitacao = serviceSolicitacao.getById(idPerfil);
        serviceRelacionamento.salvarRelacionamento(solicitacao);
        serviceSolicitacao.alterarStatusAprovado(solicitacao);
        component.createHeader(model, idPerfil);
        return "header";
    }
}

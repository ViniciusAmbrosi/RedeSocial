package br.com.crescer.components;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.service.PerfilService;
import br.com.crescer.service.SolicitacaoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * @author vinicius.ambrosi
 */
@Component
public class HeaderComponent {

    private static final String SOLICITACOES = "solicitacoes";
    private static final String SOLICITACOES_AMIZADE = "solicitacoesAmizade";

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private SolicitacaoService solicitacaoService;

    public void createHeader(Model model, Long idPefil) {
        final Perfil perfil;
        perfil = perfilService.getPerfil(idPefil);
        
        final List<Solicitacao> list;
        list = solicitacaoService.getSolicitacoes(perfil);

        model.addAttribute(SOLICITACOES, list);
        model.addAttribute(SOLICITACOES_AMIZADE, list.size());
    }

}


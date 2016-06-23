package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.repository.SolicitacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vinicius.ambrosi
 */
@Service
public class SolicitacaoService {

    @Autowired
    SolicitacaoRepository repository;

    public void inserir(Solicitacao solicitacao) {
        repository.save(solicitacao);
    }

    public void alterarStatus(Solicitacao solicitacao) {
        repository.save(solicitacao);
    }

    public List<Solicitacao> getSolicitacoes(Perfil bd) {
        return repository.findByIdPerfilSolicitacao(bd);
    }
    
    public boolean validaExistencia(Solicitacao solicitacao){
        Solicitacao s = repository.validarExistencia(solicitacao.getIdPerfil().getIdPerfil(), solicitacao.getIdPerfilSolicitacao().getIdPerfil());
        return s == null;
    }
}

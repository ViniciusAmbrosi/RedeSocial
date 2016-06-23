package br.com.crescer.service;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Solicitacao;
import br.com.crescer.repository.SolicitacaoRepository;
import java.math.BigDecimal;
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
    
    public Solicitacao getById(BigDecimal bd){
        return repository.findOne(bd);
    }

    public void alterarStatusAprovado(Solicitacao solicitacao) {
        solicitacao.setTpStatusSolicitacao("APROVADO");
        repository.save(solicitacao);
    }
    
    public void alterarStatusRejeitado(Solicitacao solicitacao) {
        solicitacao.setTpStatusSolicitacao("REJEITADO");
        repository.save(solicitacao);
    }

    public List<Solicitacao> getSolicitacoes(Perfil bd) {
        return repository.findByIdPerfilSolicitacaoAndTpStatusSolicitacao(bd, "PENDENTE");
    }

    public boolean validaExistencia(Solicitacao solicitacao) {
        try {
            return null == repository.findOneByIdPerfilAndIdPerfilSolicitacaoAndTpStatusSolicitacaoNotLike
        (solicitacao.getIdPerfil(), solicitacao.getIdPerfilSolicitacao(), "REPROVADO");
        } catch (Exception e) {
        }
        return false;
    }
}

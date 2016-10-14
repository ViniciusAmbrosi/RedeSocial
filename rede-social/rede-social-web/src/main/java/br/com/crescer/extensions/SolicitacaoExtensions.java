package br.com.crescer.extensions;

import br.com.crescer.entity.Solicitacao;
import br.com.crescer.rede.social.security.model.UserModel;

public class SolicitacaoExtensions {

	public static Solicitacao criarSolicitacaoPendente(){
        UserModel usuarioLogado = UserModelExtensions.getUsuarioLogado();
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setPerfil(UserModelExtensions.fromModel(usuarioLogado));
        solicitacao.setTpStatusSolicitacao("PENDENTE");
        return solicitacao;
	}
}

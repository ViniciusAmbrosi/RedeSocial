package br.com.crescer.extensions;

import java.util.Date;
import br.com.crescer.entity.Publicacao;
import br.com.crescer.entity.PublicacaoConteudo;

public class PublicacaoConteudoExtensions {
	
	public static PublicacaoConteudo generatePublicacao(String post){
        PublicacaoConteudo conteudo = new PublicacaoConteudo();
        conteudo.setConteudo(post);
        conteudo.setPublicacao(new Publicacao());
        conteudo.getPublicacao().setData(new Date());
        conteudo.getPublicacao().setTipo("POST");
        return conteudo;
	}
}

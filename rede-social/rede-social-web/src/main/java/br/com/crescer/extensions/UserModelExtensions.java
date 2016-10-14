package br.com.crescer.extensions;

import org.springframework.security.core.context.SecurityContextHolder;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Pessoa;
import br.com.crescer.rede.social.security.model.UserModel;

public class UserModelExtensions{
	
	public static Perfil fromModel(UserModel model){
		Perfil perfil = new Perfil(model.getId());
		Pessoa pessoa = new Pessoa(model.getIdPessoa());
		
		pessoa.setNome(model.getFullName());
		pessoa.setSexo(model.getSexo());
		pessoa.setDataNascimento(model.getDataNasc());
		
		perfil.setEmail(model.getEmail());
		perfil.setPessoa(pessoa);
		
		return perfil;
	}
	
	public static UserModel getUsuarioLogado(){
		return (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}

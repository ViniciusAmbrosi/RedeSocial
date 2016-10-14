
package br.com.crescer.rede.social.security.model;

import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author vinicius.ambrosi
 */

public class UserModel extends User{

	private static final long serialVersionUID = 1L;
	
	private String fullName;
    private Long id;
    private String email;
    private Date dataNasc;
    private String sexo;
    private Long idPessoa;
    
    public UserModel(String username, String password,
        Collection<? extends GrantedAuthority> authorities, String fullName, Long id,
            String email, Date datNasc, String sexo, Long idPessoa) {
        super(username, password, authorities);
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.sexo = sexo;
        this.idPessoa = idPessoa;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}

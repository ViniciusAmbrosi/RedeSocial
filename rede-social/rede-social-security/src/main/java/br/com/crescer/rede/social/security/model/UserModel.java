
package br.com.crescer.rede.social.security.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author vinicius.ambrosi
 */

public class UserModel extends User{
    
    private String fullName;
    private BigDecimal id;
    private String email;
    private Date dataNasc;
    private String sexo;
    
    public UserModel(String username, String password,
            Collection<? extends GrantedAuthority> authorities, String fullName, BigDecimal id,
            String email, Date datNasc, String sexo) {
        super(username, password, authorities);
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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
    
    
}

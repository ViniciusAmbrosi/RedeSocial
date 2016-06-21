
package br.com.crescer.rede.social.security.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author vinicius.ambrosi
 */
public class UserModel extends User{
    
    private String fullName;
    
    public UserModel(String username, String password, Collection<? extends GrantedAuthority> authorities, String fullName) {
        super(username, password, authorities);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
}

package br.com.crescer.rede.social.security.configuration;

import br.com.crescer.rede.social.security.service.RedeSocialUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author vinicius.ambrosi
 */
@Configuration
public class RedeSocialWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RedeSocialUserDetailsService redeSocialUserDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/registrar", "/cadastrar", "/css/**", "/js/**", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .permitAll().and().csrf().disable();
    }

    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(redeSocialUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}

package br.com.crescer.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "PERFIL")
@XmlRootElement
public class Perfil implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Publicacao> publicacoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Relacionamento> relacionamentos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Solicitacao> solicitacoes;

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERFIL")
    @SequenceGenerator(name = "SEQ_PERFIL", sequenceName = "SEQ_PERFIL", allocationSize = 1)
    @Column(name = "ID_PERFIL")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String senha;
    
    @JoinColumn(name = "PESSOA_ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Pessoa pessoa;

    public Perfil() {
    }

    public Perfil(Long idPerfil) {
        this.id = idPerfil;
    }

    public Perfil(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @XmlTransient
    public List<Relacionamento> getRelacionamentos() {
        return relacionamentos;
    }

    public void setRelacionamentos(List<Relacionamento> relacionamentos) {
        this.relacionamentos = relacionamentos;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    @XmlTransient
    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

}

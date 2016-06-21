/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil"),
    @NamedQuery(name = "Perfil.findByDsEmail", query = "SELECT p FROM Perfil p WHERE p.dsEmail = :dsEmail"),
    @NamedQuery(name = "Perfil.findByDsSenha", query = "SELECT p FROM Perfil p WHERE p.dsSenha = :dsSenha")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERFIL")
    private BigDecimal idPerfil;
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String dsSenha;
    @JoinColumn(name = "PESSOA_ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @ManyToOne(optional = false)
    private Pessoa pessoaIdPessoa;

    public Perfil() {
    }

    public Perfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(BigDecimal idPerfil, String dsEmail, String dsSenha) {
        this.idPerfil = idPerfil;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
    }

    public BigDecimal getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public Pessoa getPessoaIdPessoa() {
        return pessoaIdPessoa;
    }

    public void setPessoaIdPessoa(Pessoa pessoaIdPessoa) {
        this.pessoaIdPessoa = pessoaIdPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}

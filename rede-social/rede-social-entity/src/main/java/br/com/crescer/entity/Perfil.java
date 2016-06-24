/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil"),
    @NamedQuery(name = "Perfil.findByDsEmail", query = "SELECT p FROM Perfil p WHERE p.dsEmail = :dsEmail"),
    @NamedQuery(name = "Perfil.findByDsSenha", query = "SELECT p FROM Perfil p WHERE p.dsSenha = :dsSenha")})
public class Perfil implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<Publicacao> publicacaoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<Relacionamento> relacionamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfilRelacionamento")
    private List<Relacionamento> relacionamentoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<Solicitacao> solicitacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfilSolicitacao")
    private List<Solicitacao> solicitacaoList1;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERFIL")
    @SequenceGenerator(name = "SEQ_PERFIL", sequenceName = "SEQ_PERFIL", allocationSize = 1)
    @Column(name = "ID_PERFIL")
    private BigDecimal idPerfil;
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String dsSenha;
    @JoinColumn(name = "PESSOA_ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
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

    @XmlTransient
    public List<Relacionamento> getRelacionamentoList() {
        return relacionamentoList;
    }

    public void setRelacionamentoList(List<Relacionamento> relacionamentoList) {
        this.relacionamentoList = relacionamentoList;
    }

    @XmlTransient
    public List<Relacionamento> getRelacionamentoList1() {
        return relacionamentoList1;
    }

    public void setRelacionamentoList1(List<Relacionamento> relacionamentoList1) {
        this.relacionamentoList1 = relacionamentoList1;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList() {
        return solicitacaoList;
    }

    public void setSolicitacaoList(List<Solicitacao> solicitacaoList) {
        this.solicitacaoList = solicitacaoList;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList1() {
        return solicitacaoList1;
    }

    public void setSolicitacaoList1(List<Solicitacao> solicitacaoList1) {
        this.solicitacaoList1 = solicitacaoList1;
    }

    @XmlTransient
    public List<Publicacao> getPublicacaoList() {
        return publicacaoList;
    }

    public void setPublicacaoList(List<Publicacao> publicacaoList) {
        this.publicacaoList = publicacaoList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dream
 */
@Entity
@Table(name = "PUBLICACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacao.findAll", query = "SELECT p FROM Publicacao p"),
    @NamedQuery(name = "Publicacao.findByIdPublicacao", query = "SELECT p FROM Publicacao p WHERE p.idPublicacao = :idPublicacao"),
    @NamedQuery(name = "Publicacao.findByDtPublicacao", query = "SELECT p FROM Publicacao p WHERE p.dtPublicacao = :dtPublicacao"),
    @NamedQuery(name = "Publicacao.findByTpPublicacao", query = "SELECT p FROM Publicacao p WHERE p.tpPublicacao = :tpPublicacao")})
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Column(name = "ID_PUBLICACAO")
    private BigDecimal idPublicacao;
    @Basic(optional = false)
    @Column(name = "DT_PUBLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPublicacao;
    @Basic(optional = false)
    @Column(name = "TP_PUBLICACAO")
    private String tpPublicacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPublicacao")
    private List<PublicacaoConteudo> publicacaoconteudoList;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public Publicacao() {
    }

    public Publicacao(BigDecimal idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public Publicacao(BigDecimal idPublicacao, Date dtPublicacao, String tpPublicacao) {
        this.idPublicacao = idPublicacao;
        this.dtPublicacao = dtPublicacao;
        this.tpPublicacao = tpPublicacao;
    }

    public BigDecimal getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(BigDecimal idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public Date getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(Date dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getTpPublicacao() {
        return tpPublicacao;
    }

    public void setTpPublicacao(String tpPublicacao) {
        this.tpPublicacao = tpPublicacao;
    }

    @XmlTransient
    public List<PublicacaoConteudo> getPublicacaoconteudoList() {
        return publicacaoconteudoList;
    }

    public void setPublicacaoconteudoList(List<PublicacaoConteudo> publicacaoconteudoList) {
        this.publicacaoconteudoList = publicacaoconteudoList;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacao != null ? idPublicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.idPublicacao == null && other.idPublicacao != null) || (this.idPublicacao != null && !this.idPublicacao.equals(other.idPublicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Publicacao[ idPublicacao=" + idPublicacao + " ]";
    }

}

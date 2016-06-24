/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dream
 */
@Entity
@Table(name = "PUBLICACAOCONTEUDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublicacaoConteudo.findAll", query = "SELECT p FROM PublicacaoConteudo p"),
    @NamedQuery(name = "PublicacaoConteudo.findByIdPublicacaoConteudo", query = "SELECT p FROM PublicacaoConteudo p WHERE p.idPublicacaoConteudo = :idPublicacaoConteudo"),
    @NamedQuery(name = "PublicacaoConteudo.findByConteudo", query = "SELECT p FROM PublicacaoConteudo p WHERE p.conteudo = :conteudo")})
public class PublicacaoConteudo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLICACAO_CONTEUDO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO_CONTEUDO", sequenceName = "SEQ_PUBLICACAO_CONTEUDO", allocationSize = 1)
    @Column(name = "ID_PUBLICACAO_CONTEUDO")
    private BigDecimal idPublicacaoConteudo;
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;
    @JoinColumn(name = "ID_PUBLICACAO", referencedColumnName = "ID_PUBLICACAO")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Publicacao idPublicacao;

    public PublicacaoConteudo() {
    }

    public PublicacaoConteudo(BigDecimal idPublicacaoConteudo) {
        this.idPublicacaoConteudo = idPublicacaoConteudo;
    }

    public PublicacaoConteudo(BigDecimal idPublicacaoConteudo, String conteudo) {
        this.idPublicacaoConteudo = idPublicacaoConteudo;
        this.conteudo = conteudo;
    }

    public BigDecimal getIdPublicacaoConteudo() {
        return idPublicacaoConteudo;
    }

    public void setIdPublicacaoConteudo(BigDecimal idPublicacaoConteudo) {
        this.idPublicacaoConteudo = idPublicacaoConteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Publicacao getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Publicacao idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacaoConteudo != null ? idPublicacaoConteudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacaoConteudo)) {
            return false;
        }
        PublicacaoConteudo other = (PublicacaoConteudo) object;
        if ((this.idPublicacaoConteudo == null && other.idPublicacaoConteudo != null) || (this.idPublicacaoConteudo != null && !this.idPublicacaoConteudo.equals(other.idPublicacaoConteudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Publicacaoconteudo[ idPublicacaoConteudo=" + idPublicacaoConteudo + " ]";
    }

}

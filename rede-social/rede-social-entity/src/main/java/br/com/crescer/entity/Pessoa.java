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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "PESSOA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdPessoa", query = "SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "Pessoa.findByNmPessoa", query = "SELECT p FROM Pessoa p WHERE p.nmPessoa = :nmPessoa"),
    @NamedQuery(name = "Pessoa.findByDtNascPessoa", query = "SELECT p FROM Pessoa p WHERE p.dtNascPessoa = :dtNascPessoa"),
    @NamedQuery(name = "Pessoa.findByTpSexoPessoa", query = "SELECT p FROM Pessoa p WHERE p.tpSexoPessoa = :tpSexoPessoa")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private BigDecimal idPessoa;
    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nmPessoa;
    @Basic(optional = false)
    @Column(name = "DT_NASC_PESSOA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascPessoa;
    @Basic(optional = false)
    @Column(name = "TP_SEXO_PESSOA")
    private String tpSexoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaIdPessoa")
    private List<Perfil> perfilList;

    public Pessoa() {
    }

    public Pessoa(BigDecimal idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(BigDecimal idPessoa, String nmPessoa, Date dtNascPessoa, String tpSexoPessoa) {
        this.idPessoa = idPessoa;
        this.nmPessoa = nmPessoa;
        this.dtNascPessoa = dtNascPessoa;
        this.tpSexoPessoa = tpSexoPessoa;
    }

    public BigDecimal getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(BigDecimal idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public Date getDtNascPessoa() {
        return dtNascPessoa;
    }

    public void setDtNascPessoa(Date dtNascPessoa) {
        this.dtNascPessoa = dtNascPessoa;
    }

    public String getTpSexoPessoa() {
        return tpSexoPessoa;
    }

    public void setTpSexoPessoa(String tpSexoPessoa) {
        this.tpSexoPessoa = tpSexoPessoa;
    }

    @XmlTransient
    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Pessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}

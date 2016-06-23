package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "RELACIONAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacionamento.findAll", query = "SELECT r FROM Relacionamento r"),
    @NamedQuery(name = "Relacionamento.findByIdRelacionamento", query = "SELECT r FROM Relacionamento r WHERE r.idRelacionamento = :idRelacionamento"),
    @NamedQuery(name = "Relacionamento.findByDtRelacionamento", query = "SELECT r FROM Relacionamento r WHERE r.dtRelacionamento = :dtRelacionamento")})
public class Relacionamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RELACIONAMENTO")
    @SequenceGenerator(name = "SEQ_RELACIONAMENTO", sequenceName = "SEQ_RELACIONAMENTO", allocationSize = 1)
    @Column(name = "ID_RELACIONAMENTO")
    private BigDecimal idRelacionamento;
    @Basic(optional = false)
    @Column(name = "DT_RELACIONAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRelacionamento;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @JoinColumn(name = "ID_PERFIL_RELACIONAMENTO", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil idPerfilRelacionamento;

    public Relacionamento() {
    }

    public Relacionamento(BigDecimal idRelacionamento) {
        this.idRelacionamento = idRelacionamento;
    }

    public Relacionamento(BigDecimal idRelacionamento, Date dtRelacionamento) {
        this.idRelacionamento = idRelacionamento;
        this.dtRelacionamento = dtRelacionamento;
    }

    public BigDecimal getIdRelacionamento() {
        return idRelacionamento;
    }

    public void setIdRelacionamento(BigDecimal idRelacionamento) {
        this.idRelacionamento = idRelacionamento;
    }

    public Date getDtRelacionamento() {
        return dtRelacionamento;
    }

    public void setDtRelacionamento(Date dtRelacionamento) {
        this.dtRelacionamento = dtRelacionamento;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil getIdPerfilRelacionamento() {
        return idPerfilRelacionamento;
    }

    public void setIdPerfilRelacionamento(Perfil idPerfilRelacionamento) {
        this.idPerfilRelacionamento = idPerfilRelacionamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelacionamento != null ? idRelacionamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacionamento)) {
            return false;
        }
        Relacionamento other = (Relacionamento) object;
        if ((this.idRelacionamento == null && other.idRelacionamento != null) || (this.idRelacionamento != null && !this.idRelacionamento.equals(other.idRelacionamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Relacionamento[ idRelacionamento=" + idRelacionamento + " ]";
    }
    
}

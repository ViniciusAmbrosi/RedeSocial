package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "SOLICITACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findByIdSolicitacao", query = "SELECT s FROM Solicitacao s WHERE s.idSolicitacao = :idSolicitacao"),
    @NamedQuery(name = "Solicitacao.findByTpStatusSolicitacao", query = "SELECT s FROM Solicitacao s WHERE s.tpStatusSolicitacao = :tpStatusSolicitacao")})
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITACAO")
    @SequenceGenerator(name = "SEQ_SOLICITACAO", sequenceName = "SEQ_SOLICITACAO", allocationSize = 1)
    @Column(name = "ID_SOLICITACAO")
    private BigDecimal idSolicitacao;
    @Basic(optional = false)
    @Column(name = "TP_STATUS_SOLICITACAO")
    private String tpStatusSolicitacao;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @JoinColumn(name = "ID_PERFIL_SOLICITACAO", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil idPerfilSolicitacao;

    public Solicitacao() {
    }

    public Solicitacao(BigDecimal idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Solicitacao(BigDecimal idSolicitacao, String tpStatusSolicitacao) {
        this.idSolicitacao = idSolicitacao;
        this.tpStatusSolicitacao = tpStatusSolicitacao;
    }

    public BigDecimal getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(BigDecimal idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public String getTpStatusSolicitacao() {
        return tpStatusSolicitacao;
    }

    public void setTpStatusSolicitacao(String tpStatusSolicitacao) {
        this.tpStatusSolicitacao = tpStatusSolicitacao;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil getIdPerfilSolicitacao() {
        return idPerfilSolicitacao;
    }

    public void setIdPerfilSolicitacao(Perfil idPerfilSolicitacao) {
        this.idPerfilSolicitacao = idPerfilSolicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitacao != null ? idSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.idPerfil == null && other.idPerfil != null) && (this.idPerfilSolicitacao == null && other.idPerfilSolicitacao != null)
                || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))
                && ((this.idPerfilSolicitacao != null && !this.idPerfilSolicitacao.equals(other.idPerfilSolicitacao)))) {
            return false;
        }
        return !other.getTpStatusSolicitacao().equals(this.getTpStatusSolicitacao()) && !"APROVADA".equals(other.getTpStatusSolicitacao());
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Solicitacao[ idSolicitacao=" + idSolicitacao + " ]";
    }

}

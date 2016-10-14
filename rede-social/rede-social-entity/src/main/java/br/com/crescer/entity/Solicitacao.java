package br.com.crescer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "SOLICITACAO")
@XmlRootElement
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITACAO")
    @SequenceGenerator(name = "SEQ_SOLICITACAO", sequenceName = "SEQ_SOLICITACAO", allocationSize = 1)
    @Column(name = "ID_SOLICITACAO")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "TP_STATUS_SOLICITACAO")
    private String tipoStatus;
    
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil perfil;
    
    @JoinColumn(name = "ID_PERFIL_SOLICITACAO", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil perfilSolicitacao;

    public Solicitacao() {
    }

    public Solicitacao(Long idSolicitacao) {
        this.id = idSolicitacao;
    }

    public Solicitacao(Long idSolicitacao, String tipoStatus) {
        this.id = idSolicitacao;
        this.tipoStatus = tipoStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idSolicitacao) {
        this.id = idSolicitacao;
    }

    public String getTipoStatus() {
        return tipoStatus;
    }

    public void setTpStatusSolicitacao(String tipoStatus) {
        this.tipoStatus = tipoStatus;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfilSolicitacao() {
        return perfilSolicitacao;
    }

    public void setPerfilSolicitacao(Perfil perfilSolicitacao) {
        this.perfilSolicitacao = perfilSolicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.perfil == null && other.perfil != null) && (this.perfilSolicitacao == null && other.perfilSolicitacao != null)
                || (this.perfil != null && !this.perfil.equals(other.perfil))
                && ((this.perfilSolicitacao != null && !this.perfilSolicitacao.equals(other.perfilSolicitacao)))) {
            return false;
        }
        return !other.getTipoStatus().equals(this.getTipoStatus()) && !"APROVADA".equals(other.getTipoStatus());
    }
}

package br.com.crescer.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vinicius.ambrosi
 */
@Entity
@Table(name = "RELACIONAMENTO")
@XmlRootElement
public class Relacionamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RELACIONAMENTO")
    @SequenceGenerator(name = "SEQ_RELACIONAMENTO", sequenceName = "SEQ_RELACIONAMENTO", allocationSize = 1)
    @Column(name = "ID_RELACIONAMENTO")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "DT_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil perfil;
    
    @JoinColumn(name = "ID_PERFIL_RELACIONAMENTO", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil perfilRelacionamento;

    public Relacionamento() {
    }

    public Relacionamento(Long id) {
        this.id = id;
    }

    public Relacionamento(Long id, Date dataInicio) {
        this.id = id;
        this.dataInicio = dataInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfilRelacionamento() {
        return perfilRelacionamento;
    }

    public void setPerfilRelacionamento(Perfil perfilRelacionamento) {
        this.perfilRelacionamento = perfilRelacionamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relacionamento)) {
            return false;
        }
        Relacionamento other = (Relacionamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}

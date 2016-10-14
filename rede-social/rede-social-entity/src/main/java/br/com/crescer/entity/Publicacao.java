package br.com.crescer.entity;

import java.io.Serializable;
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
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Column(name = "ID_PUBLICACAO")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "DT_PUBLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @Basic(optional = false)
    @Column(name = "TP_PUBLICACAO")
    private String tipo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacao")
    private List<PublicacaoConteudo> publicacoes;
    
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil perfil;

    public Publicacao() {
    }

    public Publicacao(Long idPublicacao) {
        this.id = idPublicacao;
    }

    public Publicacao(Long id, Date data, String tipo) {
        this.id = id;
        this.data = data;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idPublicacao) {
        this.id = idPublicacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date dtPublicacao) {
        this.data = dtPublicacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<PublicacaoConteudo> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<PublicacaoConteudo> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}

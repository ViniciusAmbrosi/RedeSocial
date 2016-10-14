package br.com.crescer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 *
 * @author dream
 */
@Entity
@Table(name = "PUBLICACAOCONTEUDO")
@XmlRootElement
public class PublicacaoConteudo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLICACAO_CONTEUDO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO_CONTEUDO", sequenceName = "SEQ_PUBLICACAO_CONTEUDO", allocationSize = 1)
    @Column(name = "ID_PUBLICACAO_CONTEUDO")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @JoinColumn(name = "ID_PUBLICACAO", referencedColumnName = "ID_PUBLICACAO")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Publicacao publicacao;

    public PublicacaoConteudo() {
    }

    public PublicacaoConteudo(Long idPublicacaoConteudo) {
        this.id = idPublicacaoConteudo;
    }

    public PublicacaoConteudo(Long idPublicacaoConteudo, String conteudo) {
        this.id = idPublicacaoConteudo;
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idPublicacaoConteudo) {
        this.id = idPublicacaoConteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PublicacaoConteudo)) {
            return false;
        }
        PublicacaoConteudo other = (PublicacaoConteudo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}

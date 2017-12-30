/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "Bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByIdBitacora", query = "SELECT b FROM Bitacora b WHERE b.idBitacora = :idBitacora"),
    @NamedQuery(name = "Bitacora.findByDetalleCambio", query = "SELECT b FROM Bitacora b WHERE b.detalleCambio = :detalleCambio"),
    @NamedQuery(name = "Bitacora.findByFecha", query = "SELECT b FROM Bitacora b WHERE b.fecha = :fecha")})
public class Bitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBitacora")
    private Integer idBitacora;
    @Size(max = 400)
    @Column(name = "detalleCambio")
    private String detalleCambio;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Usuario_usuario", referencedColumnName = "usuario")
    @ManyToOne
    private Usuario usuariousuario;

    public Bitacora() {
    }

    public Bitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getDetalleCambio() {
        return detalleCambio;
    }

    public void setDetalleCambio(String detalleCambio) {
        this.detalleCambio = detalleCambio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuariousuario() {
        return usuariousuario;
    }

    public void setUsuariousuario(Usuario usuariousuario) {
        this.usuariousuario = usuariousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Bitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}

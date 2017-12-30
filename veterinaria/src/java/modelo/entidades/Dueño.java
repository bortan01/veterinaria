/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "Due\u00f1o")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Due\u00f1o.findAll", query = "SELECT d FROM Due\u00f1o d"),
    @NamedQuery(name = "Due\u00f1o.findByIdDue\u00f1o", query = "SELECT d FROM Due\u00f1o d WHERE d.idDue\u00f1o = :idDue\u00f1o"),
    @NamedQuery(name = "Due\u00f1o.findByNombre", query = "SELECT d FROM Due\u00f1o d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Due\u00f1o.findByTelefono", query = "SELECT d FROM Due\u00f1o d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Due\u00f1o.findByDireccion", query = "SELECT d FROM Due\u00f1o d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Due\u00f1o.findByCorreo", query = "SELECT d FROM Due\u00f1o d WHERE d.correo = :correo")})
public class Dueño implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDue\u00f1o")
    private Integer idDueño;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 25)
    @Column(name = "correo")
    private String correo;
    @OneToMany(mappedBy = "due\u00f1oidDue\u00f1o")
    private List<Mascota> mascotaList;

    public Dueño() {
    }

    public Dueño(Integer idDueño) {
        this.idDueño = idDueño;
    }

    public Integer getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(Integer idDueño) {
        this.idDueño = idDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDueño != null ? idDueño.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dueño)) {
            return false;
        }
        Dueño other = (Dueño) object;
        if ((this.idDueño == null && other.idDueño != null) || (this.idDueño != null && !this.idDueño.equals(other.idDueño))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Due\u00f1o[ idDue\u00f1o=" + idDueño + " ]";
    }
    
}

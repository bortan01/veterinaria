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
@Table(name = "Enfermedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedad.findAll", query = "SELECT e FROM Enfermedad e"),
    @NamedQuery(name = "Enfermedad.findByIdEnfermedad", query = "SELECT e FROM Enfermedad e WHERE e.idEnfermedad = :idEnfermedad"),
    @NamedQuery(name = "Enfermedad.findByNombreEnfermedad", query = "SELECT e FROM Enfermedad e WHERE e.nombreEnfermedad = :nombreEnfermedad"),
    @NamedQuery(name = "Enfermedad.findBySintomas", query = "SELECT e FROM Enfermedad e WHERE e.sintomas = :sintomas")})
public class Enfermedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEnfermedad")
    private Integer idEnfermedad;
    @Size(max = 45)
    @Column(name = "nombreEnfermedad")
    private String nombreEnfermedad;
    @Size(max = 400)
    @Column(name = "sintomas")
    private String sintomas;
    @OneToMany(mappedBy = "enfermedadidEnfermedad")
    private List<Vacunas> vacunasList;

    public Enfermedad() {
    }

    public Enfermedad(Integer idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public Integer getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(Integer idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @XmlTransient
    public List<Vacunas> getVacunasList() {
        return vacunasList;
    }

    public void setVacunasList(List<Vacunas> vacunasList) {
        this.vacunasList = vacunasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnfermedad != null ? idEnfermedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedad)) {
            return false;
        }
        Enfermedad other = (Enfermedad) object;
        if ((this.idEnfermedad == null && other.idEnfermedad != null) || (this.idEnfermedad != null && !this.idEnfermedad.equals(other.idEnfermedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Enfermedad[ idEnfermedad=" + idEnfermedad + " ]";
    }
    
}

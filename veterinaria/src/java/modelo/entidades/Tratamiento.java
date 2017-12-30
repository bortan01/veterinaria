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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "Tratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamiento.findAll", query = "SELECT t FROM Tratamiento t"),
    @NamedQuery(name = "Tratamiento.findByIdTratamiento", query = "SELECT t FROM Tratamiento t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "Tratamiento.findByFechaTratamiento", query = "SELECT t FROM Tratamiento t WHERE t.fechaTratamiento = :fechaTratamiento")})
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTratamiento")
    private Integer idTratamiento;
    @Column(name = "fechaTratamiento")
    @Temporal(TemporalType.DATE)
    private Date fechaTratamiento;
    @JoinColumn(name = "Mascota_idMascota", referencedColumnName = "idMascota")
    @ManyToOne
    private Mascota mascotaidMascota;
    @JoinColumn(name = "Vacuna_idVacuna", referencedColumnName = "idVacuna")
    @ManyToOne
    private Vacunas vacunaidVacuna;

    public Tratamiento() {
    }

    public Tratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Mascota getMascotaidMascota() {
        return mascotaidMascota;
    }

    public void setMascotaidMascota(Mascota mascotaidMascota) {
        this.mascotaidMascota = mascotaidMascota;
    }

    public Vacunas getVacunaidVacuna() {
        return vacunaidVacuna;
    }

    public void setVacunaidVacuna(Vacunas vacunaidVacuna) {
        this.vacunaidVacuna = vacunaidVacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamiento)) {
            return false;
        }
        Tratamiento other = (Tratamiento) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Tratamiento[ idTratamiento=" + idTratamiento + " ]";
    }
    
}

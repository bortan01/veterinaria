/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "Mascota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m"),
    @NamedQuery(name = "Mascota.findByIdMascota", query = "SELECT m FROM Mascota m WHERE m.idMascota = :idMascota"),
    @NamedQuery(name = "Mascota.findByFechaNac", query = "SELECT m FROM Mascota m WHERE m.fechaNac = :fechaNac"),
    @NamedQuery(name = "Mascota.findByNombreMascota", query = "SELECT m FROM Mascota m WHERE m.nombreMascota = :nombreMascota"),
    @NamedQuery(name = "Mascota.findByPeso", query = "SELECT m FROM Mascota m WHERE m.peso = :peso"),
    @NamedQuery(name = "Mascota.findBySexo", query = "SELECT m FROM Mascota m WHERE m.sexo = :sexo"),
    @NamedQuery(name = "Mascota.findByEstado", query = "SELECT m FROM Mascota m WHERE m.estado = :estado")})
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMascota")
    private Integer idMascota;
    @Column(name = "FechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Size(max = 100)
    @Column(name = "nombreMascota")
    private String nombreMascota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "sexo")
    private Boolean sexo;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "due\u00f1o_idDue\u00f1o", referencedColumnName = "idDue\u00f1o")
    @ManyToOne
    private Dueño dueñoidDueño;
    @JoinColumn(name = "Especie_idEspecie", referencedColumnName = "idEspecie")
    @ManyToOne
    private Especie especieidEspecie;
    @OneToMany(mappedBy = "mascotaidMascota")
    private List<Tratamiento> tratamientoList;

    public Mascota() {
    }

    public Mascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Dueño getDueñoidDueño() {
        return dueñoidDueño;
    }

    public void setDueñoidDueño(Dueño dueñoidDueño) {
        this.dueñoidDueño = dueñoidDueño;
    }

    public Especie getEspecieidEspecie() {
        return especieidEspecie;
    }

    public void setEspecieidEspecie(Especie especieidEspecie) {
        this.especieidEspecie = especieidEspecie;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientoList() {
        return tratamientoList;
    }

    public void setTratamientoList(List<Tratamiento> tratamientoList) {
        this.tratamientoList = tratamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Mascota[ idMascota=" + idMascota + " ]";
    }
    
}

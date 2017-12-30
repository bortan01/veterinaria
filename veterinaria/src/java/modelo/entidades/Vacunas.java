/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "Vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v"),
    @NamedQuery(name = "Vacunas.findByIdVacuna", query = "SELECT v FROM Vacunas v WHERE v.idVacuna = :idVacuna"),
    @NamedQuery(name = "Vacunas.findByNombreVacuna", query = "SELECT v FROM Vacunas v WHERE v.nombreVacuna = :nombreVacuna"),
    @NamedQuery(name = "Vacunas.findByDosis", query = "SELECT v FROM Vacunas v WHERE v.dosis = :dosis"),
    @NamedQuery(name = "Vacunas.findByPrecio", query = "SELECT v FROM Vacunas v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vacunas.findByCantidadMax", query = "SELECT v FROM Vacunas v WHERE v.cantidadMax = :cantidadMax")})
public class Vacunas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacuna")
    private Integer idVacuna;
    @Size(max = 2147483647)
    @Column(name = "nombreVacuna")
    private String nombreVacuna;
    @Column(name = "dosis")
    private Integer dosis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "cantidadMax")
    private Integer cantidadMax;
    @JoinColumn(name = "Enfermedad_idEnfermedad", referencedColumnName = "idEnfermedad")
    @ManyToOne
    private Enfermedad enfermedadidEnfermedad;
    @OneToMany(mappedBy = "vacunaidVacuna")
    private List<Tratamiento> tratamientoList;

    public Vacunas() {
    }

    public Vacunas(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(Integer cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public Enfermedad getEnfermedadidEnfermedad() {
        return enfermedadidEnfermedad;
    }

    public void setEnfermedadidEnfermedad(Enfermedad enfermedadidEnfermedad) {
        this.enfermedadidEnfermedad = enfermedadidEnfermedad;
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
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Vacunas[ idVacuna=" + idVacuna + " ]";
    }
    
}

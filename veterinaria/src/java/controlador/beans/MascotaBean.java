package controlador.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Mascota;
import session.beans.MascotaFacade;
import utils.general.AutocompleteBeanEspecie;
import utils.general.AutocompleteBeanDuenio;

@ManagedBean(name = "mascotaBean")
@ViewScoped
public class MascotaBean implements Serializable {

    @Inject
    MascotaFacade mascotaFac;

    @ManagedProperty("#{autocompleteBeanDuenio}")
    AutocompleteBeanDuenio auD;

   @ManagedProperty("#{autocompleteBeanEspecie}")
    AutocompleteBeanEspecie auE;  
    
    Mascota mascotaSeleccionado;
    List<Mascota> listaMascota;
    List<Mascota> MascotaFiltrado;

    @PostConstruct
    public void init() {
        mascotaSeleccionado = new Mascota();
        BuscarClinicas();
    }

    public MascotaBean() {
    }

    public List<Mascota> BuscarClinicas() {
        listaMascota = mascotaFac.findAll();
        return listaMascota;
    }

    public String eliminarDoctor() {
        mascotaFac.remove(mascotaSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "listar_mascota.xhtml?faces-redirect=true";
    }

    public String actualizarDoctor() {
        mascotaFac.edit(mascotaSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "listar_mascota.xhtml?faces-redirect=true";
    }

    public String insertarDoctor() {
        mascotaFac.create(mascotaSeleccionado);
        return "listar_mascota.xhtml?faces-redirect=true";
    }

    public MascotaFacade getMascotaFac() {
        return mascotaFac;
    }

    public void setMascotaFac(MascotaFacade mascotaFac) {
        this.mascotaFac = mascotaFac;
    }

    public Mascota getMascotaSeleccionado() {
        return mascotaSeleccionado;
    }

    public void setMascotaSeleccionado(Mascota mascotaSeleccionado) {
        this.mascotaSeleccionado = mascotaSeleccionado;
    }

    public List<Mascota> getListaMascota() {
        return listaMascota;
    }

    public void setListaMascota(List<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }

    public List<Mascota> getMascotaFiltrado() {
        return MascotaFiltrado;
    }

    public void setMascotaFiltrado(List<Mascota> MascotaFiltrado) {
        this.MascotaFiltrado = MascotaFiltrado;
    }

    public AutocompleteBeanDuenio getAuD() {
        return auD;
    }

    public void setAuD(AutocompleteBeanDuenio auD) {
        this.auD = auD;
    }

    public AutocompleteBeanEspecie getAuE() {
        return auE;
    }

    public void setAuE(AutocompleteBeanEspecie auE) {
        this.auE = auE;
    }
    

}

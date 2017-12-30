package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Vacunas;
import session.beans.VacunasFacade;

@ManagedBean (name = "listaVacunas")
@SessionScoped
public class ListaVacunas implements Serializable{

    @Inject
    VacunasFacade VacunasFacade;
    public List<Vacunas> listaVacunas;
    
    @PostConstruct
    public void init() {
        listaVacunas = llenarLista();
    }
      public List<Vacunas> llenarLista() {
        return VacunasFacade.findAll();
    }
   
    public ListaVacunas() {
    }

    public VacunasFacade getVacunasFacade() {
        return VacunasFacade;
    }

    public void setVacunasFacade(VacunasFacade VacunasFacade) {
        this.VacunasFacade = VacunasFacade;
    }

    public List<Vacunas> getListaVacunas() {
        return listaVacunas;
    }

    public void setListaVacunas(List<Vacunas> listaVacunas) {
        this.listaVacunas = listaVacunas;
    }
    
    
}

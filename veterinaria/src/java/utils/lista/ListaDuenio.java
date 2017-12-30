package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Dueño;
import session.beans.DueñoFacade;

@ManagedBean (name = "listaDuenio")
@SessionScoped
public class ListaDuenio implements Serializable{
    
     @Inject
    DueñoFacade duenioFacade;
    public List<Dueño> listaDuenio;
    
    @PostConstruct
    public void init() {
        listaDuenio = llenarLista();
    }
    public List<Dueño> llenarLista() {
        return duenioFacade.findAll();
    }

    public ListaDuenio() {
    }

    public DueñoFacade getDuenioFacade() {
        return duenioFacade;
    }

    public void setDuenioFacade(DueñoFacade duenioFacade) {
        this.duenioFacade = duenioFacade;
    }

    public List<Dueño> getListaDuenio() {
        return listaDuenio;
    }

    public void setListaDuenio(List<Dueño> listaDuenio) {
        this.listaDuenio = listaDuenio;
    }
    
    
}

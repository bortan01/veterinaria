
package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Tratamiento;
import session.beans.TratamientoFacade;

@ManagedBean (name = "listaTratamiento")
@SessionScoped
public class ListaTratamiento implements Serializable{

    @Inject
    TratamientoFacade TratamietoFacade;
    public List<Tratamiento> listaTratamiento;
    
    @PostConstruct
    public void init() {
        listaTratamiento = llenarLista();
    }

    public List<Tratamiento> llenarLista() {
        return TratamietoFacade.findAll();
    }
    public ListaTratamiento() {
    }

    public TratamientoFacade getTratamietoFacade() {
        return TratamietoFacade;
    }

    public void setTratamietoFacade(TratamientoFacade TratamietoFacade) {
        this.TratamietoFacade = TratamietoFacade;
    }

    public List<Tratamiento> getListaTratamiento() {
        return listaTratamiento;
    }

    public void setListaTratamiento(List<Tratamiento> listaTratamiento) {
        this.listaTratamiento = listaTratamiento;
    }

        
    
}

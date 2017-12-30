package utils.lista;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Especie;
import session.beans.EspecieFacade;

@ManagedBean (name ="listaEspecie")
@SessionScoped
public class ListaEspecie {
@Inject
    EspecieFacade EspecieFac;
    public List<Especie> listaEspecie;
    
    @PostConstruct
    public void init() {
        listaEspecie = llenarLista();
    }
      public List<Especie> llenarLista() {
        return EspecieFac.findAll();
    }
   
    public ListaEspecie() {
    }

    public EspecieFacade getEspecieFac() {
        return EspecieFac;
    }

    public void setEspecieFac(EspecieFacade EspecieFac) {
        this.EspecieFac = EspecieFac;
    }

    public List<Especie> getListaEspecie() {
        return listaEspecie;
    }

    public void setListaEspecie(List<Especie> listaEspecie) {
        this.listaEspecie = listaEspecie;
    }
    
    
}

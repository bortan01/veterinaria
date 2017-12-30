package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Mascota;
import session.beans.MascotaFacade;

@ManagedBean (name = "listaMascota")
@SessionScoped
public class ListaMascota implements Serializable{

   @Inject
    MascotaFacade MascotaFacade;
    public List<Mascota> listaMascota;
    
    @PostConstruct
    public void init() {
        listaMascota = llenarLista();
    }
      public List<Mascota> llenarLista() {
        return MascotaFacade.findAll();
    }
   public ListaMascota() {
    }

    public MascotaFacade getMascotaFacade() {
        return MascotaFacade;
    }

    public void setMascotaFacade(MascotaFacade MascotaFacade) {
        this.MascotaFacade = MascotaFacade;
    }

    public List<Mascota> getListaMascota() {
        return listaMascota;
    }

    public void setListaMascota(List<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }
    
   
}

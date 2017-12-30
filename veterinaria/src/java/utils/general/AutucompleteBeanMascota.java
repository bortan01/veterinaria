package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Mascota;
import utils.lista.ListaMascota;

@ManagedBean (name = "autucompleteBeanMascota")
@SessionScoped

public class AutucompleteBeanMascota implements Serializable{
    @ManagedProperty("#{listaMascota}")
    ListaMascota mascotaData;
    Mascota mascota;
    
    public List<Mascota> completeMascotaDespacho(String query) {
        List<Mascota> allMascota = getMascotaData().getListaMascota();
        List<Mascota> filterDoctor = new ArrayList<Mascota>();
        for (Mascota mascotaSelected : allMascota) {
            if (mascotaSelected.getNombreMascota().toLowerCase().startsWith(query)) {
                filterDoctor.add(mascotaSelected);
            }
        }
        return filterDoctor;
    }
    
    public AutucompleteBeanMascota() {
    }

    public ListaMascota getMascotaData() {
        return mascotaData;
    }

    public void setMascotaData(ListaMascota mascotaData) {
        this.mascotaData = mascotaData;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
}

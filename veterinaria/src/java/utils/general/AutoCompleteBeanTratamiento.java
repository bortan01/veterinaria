package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Tratamiento;
import utils.lista.ListaTratamiento;

@ManagedBean (name = "autoCompleteBeanTratamiento")
@SessionScoped
public class AutoCompleteBeanTratamiento implements Serializable{

     @ManagedProperty("#{listaTratamiento}")
     ListaTratamiento tratamientoData;
    Tratamiento tratamiento;
    
    public List<Tratamiento> completeTratamiento(String query) {
        List<Tratamiento> allTratamiento = getTratamientoData().getListaTratamiento();
        List<Tratamiento> filterDoctor = new ArrayList<Tratamiento>();
        for (Tratamiento TratamientoSelected : allTratamiento) {
            if (TratamientoSelected.getMascotaidMascota().getNombreMascota().toLowerCase().startsWith(query)) {
                filterDoctor.add(TratamientoSelected);
            }
        }
        return filterDoctor;
    }

    public ListaTratamiento getTratamientoData() {
        return tratamientoData;
    }

    public void setTratamientoData(ListaTratamiento tratamientoData) {
        this.tratamientoData = tratamientoData;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
      

    public AutoCompleteBeanTratamiento() {
    }
    
}

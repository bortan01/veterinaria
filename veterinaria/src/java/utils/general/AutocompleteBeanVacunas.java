package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Vacunas;
import utils.lista.ListaVacunas;

@ManagedBean (name = "autocompleteBeanVacunas")
@SessionScoped
public class AutocompleteBeanVacunas implements Serializable{
    
 @ManagedProperty("#{listaVacunas}")
    ListaVacunas VacunaData;
    Vacunas vacunas;
    
    public List<Vacunas> completeCitaDespacho(String query) {
        List<Vacunas> allVacunas = getVacunaData().getListaVacunas();
        List<Vacunas> filterVacuna = new ArrayList<Vacunas>();
        for (Vacunas VacunaSelected : allVacunas) {
            if (VacunaSelected.getNombreVacuna().toLowerCase().startsWith(query)) {
                filterVacuna.add(VacunaSelected);
            }
        }
        return filterVacuna;
    }

    public AutocompleteBeanVacunas() {
    }

    public ListaVacunas getVacunaData() {
        return VacunaData;
    }

    public void setVacunaData(ListaVacunas VacunaData) {
        this.VacunaData = VacunaData;
    }

    public Vacunas getVacunas() {
        return vacunas;
    }

    public void setVacunas(Vacunas vacunas) {
        this.vacunas = vacunas;
    }
    
    
}

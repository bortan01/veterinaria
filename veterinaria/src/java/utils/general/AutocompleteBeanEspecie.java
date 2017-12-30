package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Especie;
import utils.lista.ListaEspecie;

@ManagedBean (name = "autocompleteBeanEspecie")
@SessionScoped
public class AutocompleteBeanEspecie implements Serializable{
    
     @ManagedProperty("#{listaEspecie}")
    ListaEspecie EspecieData;
    Especie especie;
    
    public List<Especie> completeEspecieDespacho(String query) {
        List<Especie> allCita = getEspecieData().getListaEspecie();
        List<Especie> filterEspecie = new ArrayList<Especie>();
        for (Especie EspecieSelected : allCita) {
            if (EspecieSelected.getNombreEspecie().toLowerCase().startsWith(query)) {
                filterEspecie.add(EspecieSelected);
            }
        }
        return filterEspecie;
    }

    public AutocompleteBeanEspecie() {
    
    
    }

    public ListaEspecie getEspecieData() {
        return EspecieData;
    }

    public void setEspecieData(ListaEspecie EspecieData) {
        this.EspecieData = EspecieData;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    
    
}

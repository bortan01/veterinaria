package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Dueño;
import utils.lista.ListaDuenio;

@ManagedBean (name = "autocompleteBeanDuenio")
@SessionScoped
public class AutocompleteBeanDuenio implements Serializable{
    
    
    @ManagedProperty("#{listaDuenio}")
    ListaDuenio DuenioData;
    Dueño duenio;
    
     public List<Dueño> completeDuenioDespacho(String query) {
        List<Dueño> allDuenio = getDuenioData().getListaDuenio();
        List<Dueño> filterDuenio = new ArrayList<Dueño>();
        for (Dueño DuenioSelected : allDuenio) {
            if (DuenioSelected.getNombre().toLowerCase().startsWith(query)) {
                filterDuenio.add(DuenioSelected);
            }
        }
        return filterDuenio;
    }

    public AutocompleteBeanDuenio() {
    }

    public ListaDuenio getDuenioData() {
        return DuenioData;
    }

    public void setDuenioData(ListaDuenio DuenioData) {
        this.DuenioData = DuenioData;
    }

    public Dueño getDuenio() {
        return duenio;
    }

    public void setDuenio(Dueño duenio) {
        this.duenio = duenio;
    }
    
    
}

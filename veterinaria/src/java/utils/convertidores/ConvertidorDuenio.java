package utils.convertidores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import modelo.entidades.Dueño;
import utils.lista.ListaDuenio;

@ManagedBean (name = "ConvertidorDuenio")
@SessionScoped
public class ConvertidorDuenio implements Converter{

    public ConvertidorDuenio() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
            int pos=0;
        if(value != null && value.trim().length() > 0) {
            ListaDuenio  service = (ListaDuenio) context.getExternalContext().getSessionMap().get("listaDuenio");
           for(int i=0; i<service.getListaDuenio().size(); i++){
                if(service.getListaDuenio().get(i).getIdDueño().equals(value))
                    pos=i;
            }
            return service.getListaDuenio().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Dueño) value).getIdDueño());            
        }
        else {
            return null;
        }
    }
    
}

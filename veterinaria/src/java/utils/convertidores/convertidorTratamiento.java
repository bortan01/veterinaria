package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Tratamiento;
import utils.lista.ListaTratamiento;

@FacesConverter ("convertidorTratamiento")
public class convertidorTratamiento implements Converter{

    public convertidorTratamiento() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         int pos=0;
        if(value != null && value.trim().length() > 0) {
            ListaTratamiento  service = (ListaTratamiento) context.getExternalContext().getSessionMap().get("listaTratamiento");
           for(int i=0; i<service.getListaTratamiento().size(); i++){
                if(service.getListaTratamiento().get(i).getIdTratamiento().equals(value))
                    pos=i;
            }
            return service.getListaTratamiento().get(pos);
        }
        else {
            return null;
        } 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Tratamiento) value).getIdTratamiento());            
        }
        else {
            return null;
        }
    }
    
}

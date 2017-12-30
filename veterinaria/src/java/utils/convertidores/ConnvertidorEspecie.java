package utils.convertidores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import modelo.entidades.Especie;
import utils.lista.ListaEspecie;

@ManagedBean (name = "connvertidorEspecie")
@SessionScoped
public class ConnvertidorEspecie implements Converter{

    public ConnvertidorEspecie() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       int pos=0;
        if(value != null && value.trim().length() > 0) {
           ListaEspecie  service = (ListaEspecie) context.getExternalContext().getSessionMap().get("listaEspecie");
           for(int i=0; i<service.getListaEspecie().size(); i++){
                if(service.getListaEspecie().get(i).getIdEspecie().equals(value))
                    pos=i;
            }
            return service.getListaEspecie().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Especie) value).getIdEspecie());            
        }
        else {
            return null;
        }
    }
    
}

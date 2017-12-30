package utils.convertidores;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Mascota;
import utils.lista.ListaMascota;

@FacesConverter ("ConvertidorMascota")


public class ConvertidorMascota implements Converter{

    /**
     * Creates a new instance of ConvertidorMascota
     */
    public ConvertidorMascota() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          int pos=0;
        if(value != null && value.trim().length() > 0) {
            ListaMascota  service = (ListaMascota) context.getExternalContext().getSessionMap().get("listaMascota");
           for(int i=0; i<service.getListaMascota().size(); i++){
                if(service.getListaMascota().get(i).getIdMascota().equals(value))
                    pos=i;
            }
            return service.getListaMascota().get(pos);
        }
        else {
            return null;
        } 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Mascota) value).getIdMascota());            
        }
        else {
            return null;
        }
    }
    
}

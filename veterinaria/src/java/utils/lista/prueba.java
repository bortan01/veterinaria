
package utils.lista;

import java.util.List;
import modelo.entidades.Mascota;

public class prueba {
    public static void main(String[] args) {
        ListaMascota objeto = new ListaMascota();
        List<Mascota> a = objeto.llenarLista();
        
        for (int i = 0; i < a.size(); i++) {
            System.out.println("la mascotata" + a.get(i).getNombreMascota());
        }
    }
    
}

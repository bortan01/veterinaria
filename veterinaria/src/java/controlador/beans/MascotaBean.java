/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Miranda
 */
@ManagedBean (name = "mascotaBean")
@ViewScoped
public class MascotaBean implements Serializable{

    /**
     * Creates a new instance of MascotaBean
     */
    public MascotaBean() {
    }
    
}

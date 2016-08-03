/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entites;

import java.util.List;

/**
 *
 * @author Roberto
 */
public class Usuario {
    
    private int id;
    private String correo;
    private String clave;
    private List<Nodo> nodos;
    private String modoResumen;
    
    public static final String RESUMEN_MODO_ONLINE= "online"; 
    public static final String RESUMEN_MODO_OFFLINE= "offline"; 

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    public String getModoResumen() {
        return modoResumen;
    }

    public void setModoResumen(String modoResumen) {
        this.modoResumen = modoResumen;
    }
    
}

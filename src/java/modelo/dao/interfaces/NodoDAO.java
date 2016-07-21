/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.interfaces;

import java.util.List;
import modelo.entites.Nodo;
import modelo.entites.Usuario;

/**
 *
 * @author Roberto
 */
public interface NodoDAO {
    public Nodo read(int id);
    public List<Nodo> read();
    public List<Nodo> read(Usuario usuario);
}

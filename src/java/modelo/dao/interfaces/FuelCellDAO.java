package modelo.dao.interfaces;

import modelo.entites.FuelCell;
import modelo.entites.Nodo;

/**
 *
 * @author Roberto
 */
public interface FuelCellDAO {

    public FuelCell read(int id);
    public FuelCell read(Nodo nodo);
    
}

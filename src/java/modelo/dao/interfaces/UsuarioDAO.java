
package modelo.dao.interfaces;

import java.util.List;
import modelo.entites.Usuario;

/**
 *
 * @author Roberto
 */
public interface UsuarioDAO {
    public Usuario read(int id);
    public List<Usuario> read();
}

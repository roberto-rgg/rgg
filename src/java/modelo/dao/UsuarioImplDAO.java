package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entites.Usuario;

/**
 *
 * @author Roberto
 */
public class UsuarioImplDAO extends ConnectionDataBase implements modelo.dao.interfaces.UsuarioDAO {

    
    public void create(Usuario entity) {
        Connection c = getConnection();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(int id) {
        Connection conn = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        String sql = "SELECT * FROM ballard.usuario WHERE ballard.usuario.id= ?";
        Usuario usuario = new Usuario();
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery(sql);
            while (resultset.next()) {
                usuario.setId(resultset.getInt(1));
                usuario.setCorreo(resultset.getString(2));
                usuario.setClave(resultset.getString(3));
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultset != null) {
                    resultset.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> read() {
        Connection conn = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList();
        Usuario usuario;
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt(1));
                usuario.setCorreo(resultSet.getString(2));
                usuario.setClave(resultSet.getString(3));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return usuarios;
    }

    public void update(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

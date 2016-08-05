
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.interfaces.NodoDAO;
import modelo.entites.Nodo;
import modelo.entites.Usuario;

/**
 *
 * @author Roberto
 */
public class NodoImplDAO extends ConnectionDataBase implements NodoDAO{
    
    
    @Override
    public Nodo read(int id){
        Connection conn = getConnection();
        
        PreparedStatement preparedStement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM nodo WHERE id = ? " ;
        Nodo nodo = null;
        try {
            preparedStement = conn.prepareStatement(sql);
            preparedStement.setInt(1, id);
            resultSet = preparedStement.executeQuery();
            while (resultSet.next()) {
                nodo = new Nodo();
                nodo.setId(resultSet.getInt(1));
                nodo.setDescripcion(resultSet.getString(2));
                nodo.setIp(resultSet.getString(3));
                nodo.setPuerto(resultSet.getInt(4));
                nodo.setEstado(resultSet.getString(5));
                nodo.setOnline(resultSet.getBoolean(6));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStement != null) {
                    preparedStement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return nodo;
    }
    
    @Override
    public List<Nodo> read(){
        Connection conn = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM nodo";
        List<Nodo> nodos = new ArrayList();
        Nodo nodo;
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nodo = new Nodo();
                nodo.setId(resultSet.getInt(1));
                nodo.setDescripcion(resultSet.getString(2));
                nodo.setIp(resultSet.getString(3));
                nodo.setPuerto(resultSet.getInt(4));
                nodo.setEstado(resultSet.getString(5));
                nodo.setOnline(resultSet.getBoolean(6));
                nodos.add(nodo);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return nodos;
                
    }
    
    @Override
    public List<Nodo> read(Usuario usuario){
        String sql = "SELECT * FROM ballard.nodo WHERE ballard.nodo.usuario_id = " + usuario.getId() + ";";
        return queryGenerica(sql);
    }
    
    private List<Nodo> queryGenerica(String sql){
        Connection conn = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Nodo> nodos = null;
        Nodo nodo;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            nodos = new ArrayList();
            while (resultSet.next()) {
                nodo = new Nodo();
                nodo.setId(resultSet.getInt(1));
                nodo.setDescripcion(resultSet.getString(2));
                nodo.setIp(resultSet.getString(3));
                nodo.setPuerto(resultSet.getInt(4));
                nodo.setEstado(resultSet.getString(5));
                nodo.setOnline(resultSet.getBoolean(6));
                nodos.add(nodo);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(NodoImplDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return nodos;
    }
}

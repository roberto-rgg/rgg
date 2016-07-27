
package snmp;

import java.util.Objects;

/**
 *
 * @author Roberto
 */
public class SnmpObject {
    
    private int id;
    private String oid;
    private String nombre;
    private String valor;

    public SnmpObject(String oid, String nombre, String valor) {
        this.oid = oid;
        this.nombre = nombre;
        this.valor = valor;
    }

    public SnmpObject(String oid, String nombre) {
        this.oid = oid;
        this.nombre = nombre;
    }

    public SnmpObject(int id, String oid, String nombre, String valor) {
        this.id = id;
        this.oid = oid;
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.oid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SnmpObject other = (SnmpObject) obj;
        return Objects.equals(this.oid, other.oid);
    }
    
}

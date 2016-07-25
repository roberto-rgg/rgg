
package snmp;

/**
 *
 * @author Roberto
 */
public class SnmpObject {
    
    private String oid;
    private String nombre;
    private String valor;

    public SnmpObject(String oid, String nombre, String valor) {
        this.oid = oid;
        this.nombre = nombre;
        this.valor = valor;
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
    
}

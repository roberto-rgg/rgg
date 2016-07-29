
package snmp;

/**
 * Enum que contiene las variables oid del sistema ballard con su 
 * respectiva id, descripcion y valor oid definidos en el sistema.
 * 
 * @author Roberto
 */
public enum EnumFuelCell {
    
    SYS_NAME(0, "O.2.37.383.38", "nombre del sistema"),
    SYS_DESCR(1, "O.2.37.383.38", "nombre del sistema"),
    SYS_LOCATION(2, "O.2.37.383.38", "nombre del sistema");

    private final int id;
    private final String oid;
    private final String descripcion;

    EnumFuelCell(int id, String oid, String descripcion) {
        this.id = id;
        this.oid = oid;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getOid() {
        return oid;
    }

    public String getDescripcion() {
        return descripcion;
    }
   
}

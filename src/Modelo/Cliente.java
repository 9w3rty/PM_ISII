package Modelo;

/**
 * @author josek
 * @version 1.0
 * @created 12-oct-2017 17:27:03
 */
public class Cliente extends Persona {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the num_c
     */
    public String getNum_c() {
        return num_c;
    }

    /**
     * @param num_c the num_c to set
     */
    public void setNum_c(String num_c) {
        this.num_c = num_c;
    }
    
    private String nombre;
    private String direccion;
    private String telefono;
    private String dni;
    private String num_c;

    public Cliente() {
    }
    
    public Cliente(String nom, String dir, String tel, String dni, String num_c) {
        nombre=nom;
        direccion=dir;
        telefono=tel;
        this.dni=dni;
        this.num_c=num_c;
    }

}//end Cliente
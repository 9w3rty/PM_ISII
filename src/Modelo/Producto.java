package Modelo;

/**
 * @author josek
 * @version 1.0
 * @created 12-oct-2017 17:27:12
 */
public class Producto {

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
     * @return the m_Cliente
     */
    public Cliente getM_Cliente() {
        return m_Cliente;
    }

    /**
     * @param m_Cliente the m_Cliente to set
     */
    public void setM_Cliente(Cliente m_Cliente) {
        this.m_Cliente = m_Cliente;
    }

    /**
     * @return the m_Receta
     */
    public Receta getM_Receta() {
        return m_Receta;
    }

    /**
     * @param m_Receta the m_Receta to set
     */
    public void setM_Receta(Receta m_Receta) {
        this.m_Receta = m_Receta;
    }

    /**
     * @return the m_Produccion
     */
    public Produccion getM_Produccion() {
        return m_Produccion;
    }

    /**
     * @param m_Produccion the m_Produccion to set
     */
    public void setM_Produccion(Produccion m_Produccion) {
        this.m_Produccion = m_Produccion;
    }

    /**
     * @return the m_Variedad
     */
    public Variedad getM_Variedad() {
        return m_Variedad;
    }

    /**
     * @param m_Variedad the m_Variedad to set
     */
    public void setM_Variedad(Variedad m_Variedad) {
        this.m_Variedad = m_Variedad;
    }

    /**
     * @return the m_Presentacion
     */
    public Presentación getM_Presentacion() {
        return m_Presentacion;
    }

    /**
     * @param m_Presentacion the m_Presentacion to set
     */
    public void setM_Presentacion(Presentación m_Presentacion) {
        this.m_Presentacion = m_Presentacion;
    }

	private String nombre;
        private String codigo;
        
	private Cliente m_Cliente;
	private Receta m_Receta;
	private Produccion m_Produccion;
	private Variedad m_Variedad;
	private Presentación m_Presentacion;

	public Producto(){

	}

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}//end Producto
package Modelo;

/**
 * @author josek
 * @version 1.0
 * @created 12-oct-2017 17:27:07
 */
public class MateriaPrima {

	private  Lote lote;
	private float stockActual;
	private Variedad_MP V;
        private String codigo;
	public Proveedor m_Proveedor;
	public Receta m_Receta;

	public MateriaPrima(){

	}

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public float getStockActual() {
        return stockActual;
    }

    public void setStockActual(float stockActual) {
        this.stockActual = stockActual;
    }

    public Variedad_MP getV() {
        return V;
    }

    public void setV(Variedad_MP V) {
        this.V = V;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}//end Materia Prima
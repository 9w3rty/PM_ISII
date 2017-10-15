/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;
import Modelo.Producto;

/**
 *
 * @author Nelson
 */
public class Gestor_Producto {
    
    public static boolean altaProducto( Producto unProducto ) {
        SQL_Conexión.getInstance().connect();
        String queryAltaProducto="INSERT INTO producto (nbre_p, cod_p) VALUES ( '"+ unProducto.getNombre() +"', '"+unProducto.getCodigo()+"' ) ";
        
        return SQL_Conexión.getInstance().updateQuery(queryAltaProducto);
    }
    
    public void consultar_nombre() {}
    public void consultar_stock() {}
    public void consultar_peso() {}
    public void update_nombre() {}
    public void update_peso() {}
    public void update_producto() {}
    public void update_varieadad() {}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;
import Modelo.Producto;
import java.sql.ResultSet;

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
    
    public static boolean bajaProducto( String codProducto ) {
        SQL_Conexión.getInstance().connect();
        String query = "DELETE FROM producto WHERE cod_p='"+ codProducto +"'";
        
        return SQL_Conexión.getInstance().updateQuery(query);
    }
    
    public static boolean actualizarProducto(String codProducto, Producto nuevoProducto) {
        SQL_Conexión.getInstance().connect();
        
        String query = "UPDATE producto SET nbre_p='" + nuevoProducto.getNombre() + "', cod_p='"+nuevoProducto.getCodigo()+"' WHERE cod_p='"+codProducto+"'";
        
        return SQL_Conexión.getInstance().updateQuery(query);
    }
    
    public static ResultSet getProductos() {
        SQL_Conexión.getInstance().connect();
        ResultSet rs=SQL_Conexión.getInstance().executeQuery("SELECT * FROM producto");
        
        return rs;
    }
    
    public void consultar_nombre() {}
    public void consultar_stock() {}
    public void consultar_peso() {}
    public void update_nombre() {}
    public void update_peso() {}
    public void update_producto() {}
    public void update_varieadad() {}
}

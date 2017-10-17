/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;
import Modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        ResultSet rs = SQL_Conexión.getInstance().executeQuery("SELECT * FROM producto");
        
        return rs;
    }
    
    public static float getPrecio(String codProducto) {
        SQL_Conexión.getInstance().connect();
        String query = "SELECT precio FROM produ_v WHERE cod_p='"+codProducto+"'";
        
        ResultSet rs = SQL_Conexión.getInstance().executeQuery(query);
        
        String precioStr="-1.0";
        
        try {
            while ( rs.next() ) {
                precioStr = rs.getString("precio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Float.parseFloat(precioStr);
    }
    
    public static int getStock(String codProducto) {
        SQL_Conexión.getInstance().connect();
        String query = "SELECT cant_stock FROM stockproductos WHERE cod_p='"+codProducto+"'";
        
        ResultSet rs = SQL_Conexión.getInstance().executeQuery(query);
        
        String cantStr="0";
        
        try {
            while ( rs.next() ) {
                cantStr = rs.getString("cant_stock");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Integer.parseInt(cantStr);
    }
    
    public static boolean restarStockProducto(int cantRestar, String codProducto) {
        int stockActual = 0;
        
        SQL_Conexión.getInstance().connect();
        stockActual = getStock(codProducto);
        
        // Hay Stock
        if ( stockActual > 0 ) {
            stockActual -= cantRestar;
        }
        
        //Actualizacion en la BD
        String query = " UPDATE stockproductos SET cant_stock="+stockActual+" WHERE cod_p='"+codProducto+"' ";
        
        return SQL_Conexión.getInstance().updateQuery(query);
    }
    
    public void consultar_nombre() {}
    public void consultar_stock() {}
    public void consultar_peso() {}
    public void update_nombre() {}
    public void update_peso() {}
    public void update_producto() {}
    public void update_varieadad() {}
}

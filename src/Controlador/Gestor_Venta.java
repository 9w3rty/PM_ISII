/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;

/**
 *
 * @author josek
 */
public class Gestor_Venta {
    
    public static boolean registrarVenta(String nombre, float total, String fecha) {
        
        // SE CONECTA
        SQL_Conexión.getInstance().connect();
        String query = "INSERT INTO venta (imp_total, n_c, fechav) VALUES ( "+total+", '" + nombre + "', '"+fecha+"' )";
        
        boolean exito = SQL_Conexión.getInstance().updateQuery(query);
        
        // CIERRA CONEXIÓN
        SQL_Conexión.getInstance().close();
        
        return exito;
    }
  
}

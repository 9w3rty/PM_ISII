/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;
import Modelo.Cliente;
import java.sql.ResultSet;

/**
 *
 * @author josek
 */
public class Gestor_Cliente {
    
    public static boolean altaCliente( Cliente unCliente ) {
        // SE CONECTA
        SQL_Conexión.getInstance().connect();
        String queryAltaProducto="INSERT INTO cliente (nbre, dire, tel, dni, num_c) VALUES ( '" + unCliente.getNombre() + "', '" + unCliente.getDireccion() + "', '" + unCliente.getTelefono() + "', '" + unCliente.getDni() + "', '" + unCliente.getNum_c() + "' ) ";
        
        boolean exito=SQL_Conexión.getInstance().updateQuery(queryAltaProducto);
        
        System.out.println(queryAltaProducto);
        
        // CIERRA CONEXION
        SQL_Conexión.getInstance().close();
        
        return exito;
    }
    
    public static ResultSet getClientes() {
        // SE CONECTA
        SQL_Conexión.getInstance().connect();
        
        ResultSet rs = SQL_Conexión.getInstance().executeQuery("SELECT * FROM cliente");
        
        // CIERRA CONEXION
        SQL_Conexión.getInstance().close();
        
        return rs;
    }
    
    public static boolean actualizarCliente(String dniCliente, Cliente nuevoCliente) {
        // SE CONECTA
        SQL_Conexión.getInstance().connect();
        
        String query = "UPDATE cliente SET nbre='" + nuevoCliente.getNombre() + "', dire='"+nuevoCliente.getDireccion() + "', tel='" + nuevoCliente.getTelefono() + "' WHERE dni='" + dniCliente + "'";
        
        boolean exito=SQL_Conexión.getInstance().updateQuery(query);
        
        // CIERRA CONEXION
        SQL_Conexión.getInstance().close();
        
        return exito;
    }
    
    public static boolean bajaCliente( String dniCliente ) {
        // SE CONECTA
        SQL_Conexión.getInstance().connect();
        String query = "DELETE FROM cliente WHERE dni='"+ dniCliente +"'";
        
        boolean exito = SQL_Conexión.getInstance().updateQuery(query);
        
        // CIERRA CONEXION
        SQL_Conexión.getInstance().close();
        
        return exito;
    }
}

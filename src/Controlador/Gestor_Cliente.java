/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;
import java.sql.ResultSet;

/**
 *
 * @author josek
 */
public class Gestor_Cliente {
    
    public static ResultSet getClientes() {
        SQL_Conexión.getInstance().connect();
        ResultSet rs=SQL_Conexión.getInstance().executeQuery("SELECT * FROM cliente");
        
        return rs;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexión;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */

/*
    Patrón de Diseño: Singleton
*/

public class SQL_Conexión {
    
    private final String url = "jdbc:postgresql://localhost/PM_ISII";
    private final String user = "postgres"; // Aquí el usuario de la BD
    private final String password = "postgres"; // Aquí el password de la BD    
    private Connection conn;    
    
    // Instancia única por el Singleton
    private static SQL_Conexión INSTANCE;
    
    // El constructor privado evita que se cree el constructor por defecto
    private SQL_Conexión() {}
    
    // Método más usado, devuelve una instancia de la clase, sino existe la crea
    public static SQL_Conexión getInstance() {
        if (INSTANCE == null) INSTANCE = new SQL_Conexión();
        
        return INSTANCE;
    }
    
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    
    //Se conecta con la BD
    public Connection connect() {
        conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
        
        return conn;
    }
    
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQL_Conexión.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Método genérico que devuelve el resultado de una consulta en SQL */
    public ResultSet executeQuery(String query) {
        ResultSet rs=null;
        Statement s=null;
        
        try {
            s=conn.createStatement();
            rs=s.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("Error executeQuery! " + e.getErrorCode());
        }
        
        return rs;
    }
    
    /* Método genérico para realizar las Altas/Bajas y Modificaciones en SQL */
    public boolean updateQuery(String query) {
        boolean exito=false;
        Statement s=null;
        
         try {
            s=conn.createStatement();
            s.executeUpdate(query);
            exito=true;
        }
        catch(SQLException e) {
            System.out.println("Error updateQuery! " + e);
        }
        
        return exito;
    }
}

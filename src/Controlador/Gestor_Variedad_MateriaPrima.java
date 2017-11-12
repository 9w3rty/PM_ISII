/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Conexión.SQL_Conexión;
import Modelo.Variedad_MP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author josek
 */
public class Gestor_Variedad_MateriaPrima {
    
    public static ArrayList<Variedad_MP> traerVariedadesProductos(){
        ArrayList <Variedad_MP> ListaV = new ArrayList<Variedad_MP>();
        
        
         SQL_Conexión.getInstance().connect();
         ResultSet rs;
        
        String queryTraeVariedades= " Select nbre_V, cod_V from Variedad_Producto";
        rs=SQL_Conexión.getInstance().executeQuery(queryTraeVariedades);
        int aux =0;    
        
        try {
            while (rs.next()){
               Variedad_MP auxv= new Variedad_MP();
               auxv.setNombre(rs.getString(1));
               auxv.setCodigo(rs.getString(2));
               ListaV.add(auxv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
                

        
        return ListaV;
    }
}

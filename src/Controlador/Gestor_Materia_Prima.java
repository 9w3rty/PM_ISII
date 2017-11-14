/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Conexión.SQL_Conexión;
import Modelo.MP_ViewModel;
import Modelo.Variedad_MP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nelson
 */
public class Gestor_Materia_Prima {
    public static ArrayList<MP_ViewModel> traerMateriasPrimas(){
         

        
        SQL_Conexión.getInstance().connect();
        ResultSet rs;
        
        
        String queryTraeMPS= "select nbre_vmp, n_lote, cod_mp, stockactual\n" +
"from materia_prima,Lote,variedad_mp\n" +
"where materia_prima.cod_vmp = variedad_mp.cod_vmp and materia_prima.lote = Lote.n_lote";
       
        
        rs=SQL_Conexión.getInstance().executeQuery(queryTraeMPS);
       
        ArrayList <MP_ViewModel> Lista= new ArrayList<MP_ViewModel>();
        try {
            while (rs.next()){
                MP_ViewModel auxv=new MP_ViewModel();
                auxv.setNbre_MP(rs.getString(1));
                
                auxv.setLote(rs.getString(2));
               
                auxv.setCodigo(rs.getString(3));
                
                auxv.setSa(rs.getFloat(4));
               
                Lista.add(auxv);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            
              System.out.println(Lista.size());
              System.out.println(Lista.get(0).getNbre_MP());
              System.out.println(Lista.get(1).getNbre_MP());
              return Lista;       
    }
    
    public void consultar_lote() {}
    public void consultar_stock_actual() {}
    public void consultar_stock_mínimo() {}
    public void update_lote() {}
    public void update_stock_actual() {}
    public void update_stockMínimo() {}
}

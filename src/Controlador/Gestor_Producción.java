/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexión.SQL_Conexión;
import java.sql.ResultSet;

/**
 *
 * @author Nelson
 */
public class Gestor_Producción {
        public static ResultSet consultaProduccionFecha( String fecha ) {
        SQL_Conexión.getInstance().connect();
        String queryConsultaPFecha="Select fecha,vencimiento,cant_pro,lote,nbre_p,nbre_v From produccion, producto,variedad_producto Where fecha='"+fecha+"'and produccion.Cod_P=producto.Cod_P and produccion.Cod_V=variedad_producto.Cod_V";
        
        return SQL_Conexión.getInstance().executeQuery(queryConsultaPFecha);
    }
       public static ResultSet consultaProduccionLote( String Lote ) {
        SQL_Conexión.getInstance().connect();
        String queryConsultaPLote="Select fecha,vencimiento,cant_pro,lote,nbre_p,nbre_v From produccion, producto,variedad_producto Where lote='"+Lote+"'and produccion.Cod_P=producto.Cod_P and produccion.Cod_V=variedad_producto.Cod_V";
        
        return SQL_Conexión.getInstance().executeQuery(queryConsultaPLote);
    }
      
    public void consultar_fecha() {}
    public void consultar_lote() {}
    public void consultar_vencimiento() {}
    public void update_fecha() {}
    public void update_lote() {}
    public void update_vencimiento() {}
}

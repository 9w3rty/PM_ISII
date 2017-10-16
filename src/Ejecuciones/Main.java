/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecuciones;

import Conexión.SQL_Conexión;
import Controlador.Gestor_Producto;
import Modelo.Producto;
import Vista.MenuPrincipal;
import Vista.Principal;

/**
 *
 * @author Nelson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Producto prod = new Producto();
        prod.setNombre("Ravioles");
        prod.setCodigo("RAV001");
                
        Gestor_Producto.altaProducto(prod);
        //Gestor_Producto.bajaProducto("RAV001");
        */
        /*
        Producto nProd = new Producto();
        nProd.setNombre("Frijoles");
        nProd.setCodigo("FRI001");
        
        Gestor_Producto.actualizarProducto("RAV001", nProd);
        */
        
        MenuPrincipal mp = new MenuPrincipal();
        mp.setExtendedState(mp.MAXIMIZED_BOTH);
        mp.setVisible(true);
    }
    
}

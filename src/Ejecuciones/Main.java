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
        
        Producto prod = new Producto();
        prod.setNombre("Ravioles");
        prod.setCodigo("RAV001");
        
        Gestor_Producto.altaProducto(prod);
    }
    
}

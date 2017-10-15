/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author nelson
 */
public class Fecha {

    private String fecha; // Formato: dd/mm/aaaa
    
    public Fecha() {
        Date d = new Date();
        DateFormat dF = DateFormat.getDateInstance();
        String s = dF.format(d);
        this.fecha = s;
    }
    
    public Fecha(String fec) {
        this.fecha = fec;
    }
    
    public void setFecha(String f) {
        this.fecha = f;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public int getDia() {
        return Integer.parseInt(this.getFecha().substring(0, 2));
    }
    
    public int getMes() {
        return Integer.parseInt(this.getFecha().substring(3, 5));
    }
    
    public int getAnio() {
        return Integer.parseInt(this.getFecha().substring(6));     
    }
    
    public static boolean esBisiesto(int anio) {
        boolean bisiesto = false;       
        
        if (anio % 100 == 0 ) {
            if (anio % 400 == 0) {
                bisiesto = true;
            }
        } else {
            if (anio % 4 == 0) {
                bisiesto = true;
            }
        }
        
        return bisiesto;
    }
    
    public static int cantDias(int mes, int anio) {
        int cant;
        
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                cant = 31;
                break;
            case 2:
                if (Fecha.esBisiesto(anio)) {
                    cant = 29;
                } else {
                    cant = 28;
                }
                break;            
            default:
                cant = 30;
                break;
        }
        
        return cant;
    }
}

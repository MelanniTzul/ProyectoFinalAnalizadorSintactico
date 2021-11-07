
package com.mycompany.proyectofinalanalizador.lexico;

/**
 *
 * @author melannitzul
 */
public enum EnumPalabraReservada {
    
    ESCRIBIR ("ESCRIBIR"),
    FIN("FIN"),
    REPETIR("REPETIR"),
    INICIAR("INICIAR"),
    SI("SI"),
    VERDADERO("VERDADERO"),
    FALSO("FALSO"),
    ENTONCES("ENTONCES");
    
    String tipoPalabra;
    
    //Constructor
    private EnumPalabraReservada(String tipoPalabra){  
    this.tipoPalabra=tipoPalabra;
    }
    
    //Funcion get 
    public String getEnumPalabrasReservada(){
    return this.tipoPalabra;
    }
    
}

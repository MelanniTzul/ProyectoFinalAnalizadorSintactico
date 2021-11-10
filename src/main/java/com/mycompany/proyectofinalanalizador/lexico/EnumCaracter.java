
package com.mycompany.proyectofinalanalizador.lexico;

/**
 *
 * @author melannitzul
 */

//Clase de enum caracteres
public enum EnumCaracter {
    MAYOR_QUE ('>'),
    MENOR_QUE('<'),
    COMILLASIMPLE('\''),
    DOSPUNTOS(':'),
    COMA (','),
    PUNTOYCOMA(';'),
    DIAGONAL('/'),  
    SUMA ('+'),
    RESTA ('-'),
    MULTIPLICACION('*'),
    PORCENTAJE('%'),
    PUNTO ('.'),   
    PARENTESISCERRADO ('('),
    PARENTESISABIERTO (')'),
    CORCHETESABIERTO('['),
    CORCHETESCERRADO(']'),
    LLAVESABIERTA('{'),
    LLAVESCERRADA('}'),
    IGUAL('=');
    
   char Caracter;
   
   private EnumCaracter(char CaracterEntrante){
   this.Caracter=CaracterEntrante;  
   }

    public static EnumCaracter getMAYOR_QUE() {
        return MAYOR_QUE;
    }

    public static EnumCaracter getMENOR_QUE() {
        return MENOR_QUE;
    }

    public static EnumCaracter getCOMILLASIMPLE() {
        return COMILLASIMPLE;
    }

    public static EnumCaracter getDOSPUNTOS() {
        return DOSPUNTOS;
    }

    public static EnumCaracter getCOMA() {
        return COMA;
    }

    public static EnumCaracter getPUNTOYCOMA() {
        return PUNTOYCOMA;
    }

    public static EnumCaracter getDIAGONAL() {
        return DIAGONAL;
    }

    public static EnumCaracter getSUMA() {
        return SUMA;
    }

    public static EnumCaracter getRESTA() {
        return RESTA;
    }

    public static EnumCaracter getMULTIPLICACION() {
        return MULTIPLICACION;
    }

    public static EnumCaracter getPORCENTAJE() {
        return PORCENTAJE;
    }

    public static EnumCaracter getPUNTO() {
        return PUNTO;
    }

    public static EnumCaracter getPARENTESISCERRADO() {
        return PARENTESISCERRADO;
    }

    public static EnumCaracter getPARENTESISABIERTO() {
        return PARENTESISABIERTO;
    }

    public static EnumCaracter getCORCHETESABIERTO() {
        return CORCHETESABIERTO;
    }

    public static EnumCaracter getCORCHETESCERRADO() {
        return CORCHETESCERRADO;
    }

    public static EnumCaracter getLLAVESABIERTA() {
        return LLAVESABIERTA;
    }

    public static EnumCaracter getLLAVESCERRADA() {
        return LLAVESCERRADA;
    }

    public static EnumCaracter getIGUAL() {
        return IGUAL;
    }

    public char getCaracter() {
        return Caracter;
    }  
    
}

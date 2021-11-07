
package com.mycompany.proyectofinalanalizador.lexico;

/**
 *
 * @author melannitzul
 */
public enum EnumTipo {
    IDENTIFICADOR ("IDENTIFICADOR: "),
    NUMERO_ENTERO("NÚMERO ENTERO: "),
    LITERAL ("LITERAL: "),
    COMENTARIO ("COMENTARIO: "),
    CARACTERES_ESPECIALES ("CARACTERES ESPECIALES: "),
    PALABRA_RESERVADA ("PALABRA_RESERVADA: ");
    
    String tipo;//Declaramos una palabra para acceder a los enums
    //Constructor de la clase EnumTipo
    private EnumTipo (String tipo){
    this.tipo=tipo;
    }
    
   //Funcion get de la variable tipo
    public String getEnumTipo (){
        return this.tipo;   
    }  
}

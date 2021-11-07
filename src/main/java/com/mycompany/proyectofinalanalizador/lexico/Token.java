
package com.mycompany.proyectofinalanalizador.lexico;

/**
 *
 * @author melannitzul
 */
public class Token {
    
private String texto;
    private String tipo;
    private int fila;
    private int columna;

    public Token(String texto, String tipo, int fila, int columna) {
        this.texto = texto;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }
    
     

    public String getTexto() {
        return texto;
    }

    

    public String getTipo() {
        return tipo;
    }

   

    public int getFila() {
        return fila;
    }

   

    public int getColumna() {
        return columna;
    } 
}

package com.mycompany.proyectofinalanalizador.lexico;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author melannitzul
 */
public class Automata {

    private int[][] matrizAutomata;
    private final int EstadInicial = 0;
    private int EstadoActual = 0;
    private final int[] EstadosAceptacion = {1, 2, 9, 10};//Estados de aceptación de automata
    private String[] LineasTexto;
    private String[] PalabrasTexto;

    //Variables cuando se encuentre un erro o token para saber enque fila va
    private int fila = 1;
    private int columna;
    private JTextArea AreaCargaArchivo;//variable que tendra el texto ingresado
    private ArrayList<Error> errores = new ArrayList<>();//Arraylist para los errores
    private ArrayList<Token> Tokens = new ArrayList<>();//Arraylist para los token
    //Arraylist Enums
    private final EnumTipo InstanciasTipo[] = EnumTipo.values();//Arraylist de enums para acceder a los diferentes tipos de token
    private final EnumPalabraReservada InstanciasPalabraReservada[]=EnumPalabraReservada.values();//Arraylist de enums para acceder a los diferentes tipos de palabras reservadas
    private final EnumCaracter InstanciasCaractere[]=EnumCaracter.values();//Arraylist de enum para acceder a los diferentes tipos de caracteres

//Constructor de la clase Automata 
    public Automata(JTextArea TextoEntrada) {
        this.AreaCargaArchivo = TextoEntrada;
        InicializarMatriz();//Metodo que inicia la matriz
    }

    //Metodo de mi matriz inicializada
    private void InicializarMatriz() {
        //Inicializar matriz y dartle tamaño   
        int filas = 10;
        int columnas = 6;
        //Inicializar Matriz 
        matrizAutomata = new int[filas][columnas];
        matrizAutomata[0][0] = 1;
        matrizAutomata[0][1] = 2;
        matrizAutomata[0][2] = 3;
        matrizAutomata[0][3] = 5;
        matrizAutomata[0][4] = 10;
        matrizAutomata[0][5] = 4;
        matrizAutomata[0][6] = 1;

        matrizAutomata[1][0] = 1;
        matrizAutomata[1][1] = 1;
        matrizAutomata[1][2] = -1;
        matrizAutomata[1][3] = -1;
        matrizAutomata[1][4] = -1;
        matrizAutomata[1][5] = 1;
        matrizAutomata[1][6] = 1;

        matrizAutomata[2][0] = -1;
        matrizAutomata[2][1] = 2;
        matrizAutomata[2][2] = -1;
        matrizAutomata[2][3] = -1;
        matrizAutomata[2][4] = -1;
        matrizAutomata[2][5] = -1;
        matrizAutomata[2][6] = -1;

        matrizAutomata[3][0] = 6;
        matrizAutomata[3][1] = 6;
        matrizAutomata[3][2] = -1;
        matrizAutomata[3][3] = 6;
        matrizAutomata[3][4] = 6;
        matrizAutomata[3][5] = 6;
        matrizAutomata[3][6] = 6;

        matrizAutomata[4][0] = -1;
        matrizAutomata[4][1] = 2;
        matrizAutomata[4][2] = -1;
        matrizAutomata[4][3] = -1;
        matrizAutomata[4][4] = -1;
        matrizAutomata[4][5] = -1;
        matrizAutomata[4][6] = -1;

        matrizAutomata[5][0] = -1;
        matrizAutomata[5][1] = -1;
        matrizAutomata[5][2] = -1;
        matrizAutomata[5][3] = 7;
        matrizAutomata[5][4] = -1;
        matrizAutomata[5][5] = -1;
        matrizAutomata[5][6] = -1;

        matrizAutomata[6][0] = 6;
        matrizAutomata[6][1] = 6;
        matrizAutomata[6][2] = 8;
        matrizAutomata[6][3] = 6;
        matrizAutomata[6][4] = 6;
        matrizAutomata[6][5] = 6;
        matrizAutomata[6][6] = 6;

        matrizAutomata[7][0] = 9;
        matrizAutomata[7][1] = 9;
        matrizAutomata[7][2] = 9;
        matrizAutomata[7][3] = 9;
        matrizAutomata[7][4] = 9;
        matrizAutomata[7][5] = 9;
        matrizAutomata[7][6] = 9;

        matrizAutomata[8][0] = -1;
        matrizAutomata[8][1] = -1;
        matrizAutomata[8][2] = -1;
        matrizAutomata[8][3] = -1;
        matrizAutomata[8][4] = -1;
        matrizAutomata[8][5] = -1;
        matrizAutomata[8][6] = -1;

        matrizAutomata[9][0] = 9;
        matrizAutomata[9][1] = 9;
        matrizAutomata[9][2] = 9;
        matrizAutomata[9][3] = 9;
        matrizAutomata[9][4] = 9;
        matrizAutomata[9][5] = 9;
        matrizAutomata[8][6] = 9;

        matrizAutomata[10][0] = -1;
        matrizAutomata[10][1] = -1;
        matrizAutomata[10][2] = -1;
        matrizAutomata[10][3] = -1;
        matrizAutomata[10][4] = 10;
        matrizAutomata[10][5] = -1;
        matrizAutomata[10][6] = -1;

    }

    //Metodo para descomponer las lineas en palabras
    public void DescomponerLineasPalabras() {
        LineasTexto = AreaCargaArchivo.getText().split("\n");//Cada posicion del arreglo va ser una pasicion de mi texto de entrada
        for (int i = 0; i < LineasTexto.length; i++) {
            if (LineasTexto[i].charAt(0) == '/' && LineasTexto[i].charAt(1) == '/') {
                Tokens.add(new Token(LineasTexto[i], InstanciasTipo[3].getEnumTipo(), fila, columna));
            } else {
                PalabrasTexto = LineasTexto[i].split(" ");//Me permite separar la linea en palabras   
                for (int j = 0; j < PalabrasTexto.length; j++) {
                    AnalizarPalabra(PalabrasTexto[j]);//Enviamos la palabra al meto AnalizarPalabra
                    columna++;
                }
            }

            fila++;
            columna = 0;
        }
    }
    

    //Metodo para analizar cada palabra que tenemos en nuestro tex area
    private void AnalizarPalabra(String PalabraTexto) {
         String Cadena = "";//Para al macenar palabra
         for (int i = PalabrasTexto.length; i < 10; i++) {
             for (int j = 0; j < InstanciasPalabraReservada.length; j++) {
                 if (PalabrasTexto[i].equals(InstanciasPalabraReservada[j].getEnumPalabrasReservada())) {
                     Tokens.add(new Token(PalabrasTexto[i],InstanciasTipo[5].getEnumTipo(),fila,columna));
                 }
                 
             }
        }
         
        char[] CaracteresDePalabra = PalabraTexto.toCharArray();//Convertir una palabra a una cadena de char////h o l a
        for (int i = 0; i < CaracteresDePalabra.length; i++) {
            columna++;
            if (Character.isAlphabetic(CaracteresDePalabra[i])) {
                //Asignamos las pasiones de la matriz a la variable EstadoActual y como empieza desde 0 
                //al entrar en el if se va ir recorriendo y nos dara la posicion del estado de la matriz
                EstadoActual = matrizAutomata[EstadoActual][0];
            } else {
            
            
            }
        
        
        
        
        
        }
        
        

    }

}//llave que finaliza la clase automata

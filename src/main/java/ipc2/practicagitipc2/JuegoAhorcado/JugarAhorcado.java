/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc2.practicagitipc2.JuegoAhorcado;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class JugarAhorcado {
    NodoLetra[] Palabra;
    NodoLetra[] Pantalla;
    String PalabraCompleta;
    Scanner lector = new Scanner(System.in);
    int contFallos = 0;
    boolean Encontrada = false;
    
    String Horca = "===============*\n"
            +      "               |";
    String Tab =   "              ";
    String Cabeza =               " O";
    String BrazoI =               "/";
    String Cuerpo =                 "|";
    String BrazoD =                   ")";
    String PieI =                 "| ";
    String PieD =                    "|";
    
    
    public void IniciarJuego(){
        System.out.println("BIENVENIDO AL JUEGO MEDIEVAL");
        System.out.println("Por favor ingrese la palabra con la que se jugará esta partida");
        PalabraCompleta = lector.nextLine().toUpperCase();
        int longitud = PalabraCompleta.length();
        LimpiarPantalla();
        
        Palabra = new NodoLetra[longitud];
        Pantalla = new NodoLetra[longitud];
        
        for (int i = 0; i < Palabra.length; i++) {
            Palabra[i] = new NodoLetra();
            Pantalla[i] = new NodoLetra();
            Pantalla[i].setContenido("_");
            Palabra[i].setContenido(PalabraCompleta.substring(i, i+1));
        }
            System.out.println("BIENVENIDO ADIVINADOR");
            System.out.println("Tendra que adivinar la palabra escrita por su rival en 6 intentos o menos"); 
        
        while(true){
            System.out.println("En este momento lleva " + contFallos + " fallos");
            DibujarHorca();
            DibujarPalabra();
            System.out.println("");
            System.out.println("Por favor digite una letra o la palabra completa");
            String letra = lector.nextLine().toUpperCase();
            
            
            boolean Acertada = false;
            for (int i = 0; i < Palabra.length; i++) {
                if (letra.equals(Palabra[i].getContenido())) {
                    Pantalla[i].setContenido(Palabra[i].getContenido());
                    Acertada = true;
                } else if (letra.equals(PalabraCompleta)) {
                    Encontrada = true;
                    Acertada = true;
                    break;
                } 
                    
            }
            if (!Acertada) {
                contFallos++;
            }
            Acertada = false;
            
            if (!Encontrada) {
                for (int i = 0; i < Palabra.length; i++) {
                    if (Palabra[i].getContenido().equals(Pantalla[i].getContenido())) {
                        Encontrada = true;
                    } else {
                        Encontrada = false;
                        break;
                    }
                }
            }
            
            LimpiarPantalla();
            
            if (Encontrada) {
                System.out.println("FELICIDADES, HA GANADO EL JUEGO");
                System.out.println("Ha tenido " + contFallos + " fallos");
                break;
            } else if (contFallos >= 6) {
                DibujarHorca();
                System.out.println("HA PERDIDO");
                System.out.println("La palabra era: " + PalabraCompleta);
                break;
            }
        
        }
        
        System.out.println("Enter para continuar");
        lector.nextLine();
        
    }
    
    public void DibujarHorca(){
        System.out.println(Horca);
        System.out.print(Tab);
        if (contFallos >= 1) {
            System.out.println(Cabeza);
        }
        System.out.print(Tab);
        if (contFallos >= 2) {
            System.out.print(BrazoI);
        }
        if (contFallos >= 3) {
            System.out.print(Cuerpo);
        }
        if (contFallos >= 4) {
            System.out.println(BrazoD);
        }
        System.out.print(Tab);
        if (contFallos >= 5) {
            System.out.print(PieI);
        }
        if (contFallos >= 6) {
            System.out.println(PieD);
        }
        System.out.println("");
    }
    
    public void DibujarPalabra(){
        for (int i = 0; i < Pantalla.length; i++) {
            System.out.print(Pantalla[i].getContenido() + " ");
        }
        System.out.println("");
    }
    
    public void LimpiarPantalla(){
        System.out.println("0----------------------------------------------------------------------0");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("0----------------------------------------------------------------------0");
    }
}

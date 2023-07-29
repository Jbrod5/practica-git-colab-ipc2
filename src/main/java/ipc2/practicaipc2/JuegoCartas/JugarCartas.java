/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc2.practicaipc2.JuegoCartas;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class JugarCartas {
    private JugadorCartas Player = new JugadorCartas();
    private Cartas[] jugadas = new Cartas[3];
    Scanner lector = new Scanner(System.in);
    boolean FinPartida = false;
    
    public JugarCartas(){
    
    }
    
    public void IniciarJuego(){
        System.out.println("BIENVENIDO AL JUEGO DE APUESTAS DE 1XBET");
        System.out.println("");
        System.out.println("");
        System.out.println("Por favor digite la cantidad de dinero que usted posee");
        int dinero = lector.nextInt();
        Player.setDinero(dinero);
        System.out.println("");
        System.out.println("");
        
        while(!FinPartida){
            
        }
    }
    
    public void LimpiaPantalla(){
        System.out.println("0----------------------------------------------------------------------0");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("0----------------------------------------------------------------------0");
    }
}

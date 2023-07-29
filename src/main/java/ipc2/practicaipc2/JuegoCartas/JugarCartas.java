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
    int cant = 0;
    boolean FinPartida = false;
    
    public JugarCartas(){
    
    }
    
    public void IniciarJuego(){
        System.out.println("BIENVENIDO AL JUEGO DE APUESTAS DE 1XBET");
        System.out.println("");
        System.out.println("");
        System.out.println("Por favor digite la cantidad de dinero que usted posee");
        int dinero = Integer.parseInt(lector.nextLine());
        Player.setDinero(dinero);
        System.out.println("");
        System.out.println("");
        
        while(!FinPartida){
            LimpiaPantalla();
            jugadas[0] = new Cartas();
            jugadas[0].setSigno();
            jugadas[1] = new Cartas();
            jugadas[1].setSigno();
        
            System.out.println("*-*\n"
                             + "|" + jugadas[0].getSigno() + "|\n"
                             + "*-*");
            System.out.println("");
            System.out.println("*-*\n"
                             + "|" + jugadas[1].getSigno() + "|\n"
                             + "*-*");
            System.out.println("Su dinero actual es: " + Player.getDinero());
        
            while(true){
                System.out.println("¿Desea Apostar? (S/N)");
                String opcion = lector.nextLine();
                if (opcion.toUpperCase().equals("S")) {
                    int prob = Math.abs(jugadas[0].getValor() - jugadas[1].getValor());
                    cant = (13 - prob) + 1;
                    System.out.println("Se apostaran automaticamente " + cant + " monedas");
                    lector.nextLine();
                    Player.setDinero(-cant);
                    EvaluarCartas();
                    break;
                } else if(opcion.equals("N")){
                    break;
                } else {
                    LimpiaPantalla();
                    System.out.println("Opcion Invalida");
                }
            }
        
            if (Player.getDinero()<=0) {
                System.out.println("Se ha quedado sin dinero");
                System.out.println("Fin del juego");
                break;
            }
        }
    }
    
    public void EvaluarCartas(){
        LimpiaPantalla();
        jugadas[2] = new Cartas();
        jugadas[2].setSigno();
        System.out.println(    "*-*\n"
                             + "|" + jugadas[2].getSigno() + "|\n"
                             + "*-*");
        
        if (jugadas[1].getValor() > jugadas[0].getValor()) {
            if (jugadas[2].getValor() <= jugadas[1].getValor() && jugadas[2].getValor()>= jugadas[0].getValor()) {
                System.out.println("HA GANADO");
                System.out.println("Se le acreditaron " + cant + " monedas");
                Player.setDinero(2*cant);
                lector.nextLine();
            } else {
                System.out.println("HA FALLADO");
                System.out.println("Ha perdido su apuesta");
                lector.nextLine();
            }
        } else if (jugadas[0].getValor() > jugadas[1].getValor()){
            if (jugadas[2].getValor() <= jugadas[0].getValor() && jugadas[2].getValor()>= jugadas[1].getValor()) {
                System.out.println("HA GANADO");
                System.out.println("Se le acreditaron " + cant + " monedas");
                Player.setDinero(2*cant);
                lector.nextLine();
            } else {
                System.out.println("HA FALLADO");
                System.out.println("Ha perdido su apuesta");
                lector.nextLine();
            }
        } else {
            if (jugadas[2].getValor() == jugadas[1].getValor()) {
                System.out.println("HA GANADO");
                System.out.println("Se le acreditaron " + cant + " monedas");
                Player.setDinero(2*cant);
                lector.nextLine();
            } else {
                System.out.println("HA FALLADO");
                System.out.println("Ha perdido su apuesta");
                lector.nextLine();
            }
        }
        LimpiaPantalla();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc2.practicaipc2.JuegoCartas;

import ipc2.practicagitipc2.Jugador;

/**
 *
 * @author Usuario
 */
public class JugadorCartas extends Jugador {
    public int Dinero;

    public JugadorCartas() {
    }
    
    public void setDinero(int dinero){
        Dinero += dinero;
    }
    
    public int getDinero(){
        return Dinero;
    }
    
}

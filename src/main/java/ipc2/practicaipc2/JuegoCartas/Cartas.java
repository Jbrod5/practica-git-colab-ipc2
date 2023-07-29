/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc2.practicaipc2.JuegoCartas;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Cartas {
    public String Signo;
    public int Valor;
    public String[] listaSignos = new String[13];

    public Cartas() {
    }
    
    public void setSigno(){
        listaSignos[0] = "A";
        listaSignos[1] = "2";
        listaSignos[2] = "3";
        listaSignos[3] = "4";
        listaSignos[4] = "5";
        listaSignos[5] = "6";
        listaSignos[6] = "7";
        listaSignos[7] = "8";
        listaSignos[8] = "9";
        listaSignos[9] = "10";
        listaSignos[10] = "J";
        listaSignos[11] = "Q";
        listaSignos[12] = "K";
        
        Random Aleatorio = new Random();
        int indice = Aleatorio.nextInt(13);
        Signo = listaSignos[indice];
        Valor = indice+1;
    }
    
    public String getSigno(){
        return Signo;
    }
    
    public int getValor(){
        return Valor;
    }
}

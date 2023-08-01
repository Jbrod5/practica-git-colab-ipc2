package ipc2.basketball;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Basketball {
    
    private int cantidadTurnos; 
    private JugadorBasket jugador1;
    private JugadorBasket jugador2; 
    
    private Scanner scanner; 
    private Random random; 
    
    public Basketball(){
        
        scanner = new Scanner(System.in);
        random = new Random();
        
        do{
            System.out.println("Ingrese la cantidad de turnos que tendra la partida");
            cantidadTurnos = leerNumero(); 
            
        }while(cantidadTurnos<1);
        
        jugador1 = new JugadorBasket( 1);
        jugador2 = new JugadorBasket( 2);
        jugador1.setAdversario(jugador2);
        jugador2.setAdversario(jugador1);
        
    }
    
    public void Juego(){
        
        //ver quien inicia
        if(random.nextInt(100) <= 50){
           // Inicia jugador 1
        }else{
            // Inicia jugador 2, intercambiar jugadores
            JugadorBasket provisional; 
            provisional = jugador1; 
            jugador1 = jugador2; 
            jugador2 = provisional;
        }
    
        //CICLO DE TURNOS
        for (int i = 0; i < cantidadTurnos; i++) {
            
            System.out.println("TURNO " + (i+1));
            System.out.println(jugador1.getNombre() + ": " + jugador1.getPunteo() + " puntos.");
            System.out.println(jugador2.getNombre() + ": " + jugador2.getPunteo() + " puntos.");
            jugador1.lanzamiento(); 
            jugador2.lanzamiento();
            System.out.println(" \n \n \n \n \n \n \n ");
        
        }
        
        //FIN DEL JUEGO
        System.out.println(jugador1.getNombre() + " finaliza con " + jugador1.getPunteo() + " puntos.");
        System.out.println(jugador2.getNombre() + " finaliza con " + jugador2.getPunteo() + " puntos.");
        if(jugador1.getPunteo() > jugador2.getPunteo()){
            System.out.println(jugador1.getNombre() + " HA GANADO LA PARTIDA!");
        }else if(jugador1.getPunteo() < jugador2.getPunteo()){
            System.out.println(jugador2.getNombre() + " HA GANADO LA PARTIDA!");
        }else{
            System.out.println("HA SIDO UN EMPATE");
        }
        
    }
    
    private int leerNumero(){
        int numero = 0; 
        boolean valido = false; 
        
        do{
            try{
                numero = Integer.parseInt(scanner.nextLine());
                valido = true; 
            }catch(Exception e){
                valido = false;
                System.out.println("Elemento ingresado no valido, asegurese de que sea un entero.");
            }    
        }while(!valido);
        
        return numero; 
    }
    
}

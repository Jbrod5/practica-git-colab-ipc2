
package ipc2;

import ipc2.basketball.Basketball;
import ipc2.practicagitipc2.JuegoAhorcado.JugarAhorcado;
import ipc2.practicaipc2.JuegoCartas.JugarCartas;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Juego {
    public void juego(){
        int op; 
        do{
            System.out.println("Bienvenido a la practica colaborativa de Git");
            System.out.println("Integrantes:  Jorge Bravo      - 202131782");
            System.out.println("              Sergio Rodriguez - 202131443");
            System.out.println("");
            System.out.println("Por favor ingrese el juego que desea jugar");
            System.out.println("Ahorcado - - - - - - - - - - - - - - -  1");
            System.out.println("Basquet - - - - - - - - - - - - - - - - 2");
            System.out.println("Cartas - - - - - - - - - - - - - - - -  3");
            System.out.println("Salir - - - - - - - - - - - - - - - - - 0");

            op = leerEntero(); 
            
            switch (op) {
                case 1:
                    JugarAhorcado juego = new JugarAhorcado();
                    juego.IniciarJuego();
                    break;
                case 2:
                    Basketball basketball = new Basketball();
                    basketball.Juego();
                    break; 
                case 3:
                    JugarCartas jugar = new JugarCartas();
                    jugar.IniciarJuego();
                    break; 
            }
        }while(op!= 0);
        
        
    }
    
    private int leerEntero(){
        boolean valido = false; 
        int opcion = 0; 
        Scanner scanner = new Scanner(System.in);
        
        do{
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                valido = true; 
            } catch (Exception e) {
                valido = false; 
                System.out.println("Algo salio mal, por favor asegurese de ingresar un entero");
                System.out.println("");
            }
        }while(!valido );
        
        return opcion;
    }
}

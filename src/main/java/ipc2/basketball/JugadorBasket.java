package ipc2.basketball;

import ipc2.practicagitipc2.Jugador;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class JugadorBasket extends Jugador{
    
    private Random random; 
    private Scanner scanner; 
    private int punteo;
    
    private JugadorBasket adversario; 
    
    /**
     * Genera una instancia del jugador.
     **/
    public JugadorBasket(int numJugador){
        random = new Random();
        scanner = new Scanner(System.in);
        punteo = 0; 
        
        System.out.println("Ingrese su nombre, jugador " + numJugador);
        nombre = scanner.nextLine();
    }
    
    /**
     * Un turno es un evento en el que el jugador decide que tipo de tiro realizar.
     * Llama a la funcion lanzamiento en base a una probabilidad.
     **/
    public void lanzamiento (){
        
        int opcion;
        int punteo; 
        int probabilidad; 
        
        System.out.println("\nLanzamiento de: " + nombre);
        System.out.println("-    Ingrese el tipo de lanzamiento que desea realizar    -");
        System.out.println("1. - - - - - - -  Salto largo | 3 puntos | probabilidad 65%");
        System.out.println("2. - - - - - - -  Salto corto | 2 puntos | probabilidad 80%");
        
        opcion = leerOpcion(); 
        
        switch (opcion ) {
            case 1:   // Salto largo
                punteo = 3;
                probabilidad = 65; 
                break;
            default:  // Salto corto
                punteo = 2; 
                probabilidad = 80;
        }
        
        //Si falla el tiro dejar CERO puntos, pero aún se debe comprobar si el adversario comete falta
        if(!probabilidad(probabilidad)){
            punteo = 0; 
        }
        
        adversario.defensa(punteo);
        
    }
    
    /**
     * Realiza una defensa con la posibilidad de parar el lanzamiento o provocar una falta.
     * @param punteoTiro; entero correspondiente a los puntos del tipo de lanzamiento que realizo el adversario.
     **/
    public void defensa(int punteoLanzamiento){
        
       int opcion;
       int probabilidadFalta;
       int probabilidadReduccion; 
       
       System.out.println("\nDefensa de " + nombre);
       System.out.println("-           Ingrese la defensa que desea realizar            -");
       System.out.println("1. - - - - - - - - Cuerpo a cuerpo | reduccion 15% | falta 35%");
       System.out.println("2. - - - - - - - - Fuerte          | reduccion 30% | falta 65%");
       
       opcion = leerOpcion(); 
       
       if(opcion == 1){
           probabilidadFalta = 35;
           probabilidadReduccion = 15; 
       }else{
           probabilidadFalta = 65;
           probabilidadReduccion = 30;
       }
       
       //Primero evaluar si fue falta
       if(probabilidad(probabilidadFalta)){
           System.out.println(nombre + " HA COMETIDO UNA FALTA");
           System.out.println("TIRO LIBRE EN FAVOR DE " + adversario.getNombre());
           adversario.recibirPunteo(recibirFalta());
       }else{
           //Si no fue, evaluar si bloqueo el tiro 
           if(probabilidad(probabilidadReduccion)){
               System.out.println(nombre + " HA BLOQUEADO EL LANZAMIENTO DE " + adversario.getNombre());
           }else{
               System.out.println(nombre + " NO HA BLOQUEADO EL LANZAMIENTO DE " + adversario.getNombre());
               adversario.recibirPunteo(punteoLanzamiento);
           }
       }
        
    }
    
    public int recibirFalta(){
        if(probabilidad(90)){
            System.out.println(adversario.getNombre() + " HA ANOTADO EL TIRO LIBRE, SE HA LLEVADO 2 PUNTOS");
            return 2;
        }
        System.out.println(adversario.getNombre() + " HA FALLADO EL TIRO LIBRE");
        return 0; 
 
    }
    
    public void recibirPunteo(int punteo){
        if(punteo != 0){
            System.out.println(nombre + " HA ENCESTADO SU LANZAMIENTO");            
            System.out.println(nombre + " HA RECIBIDO " + punteo + " PUNTOS");
            this.punteo += punteo;
        }else{
             System.out.println(nombre + " HA FALLADO SU LANZAMIENTO");  
        }
          
    }
    
    /**
     * Devuelve un booleano que indica si la acción que se deseó realizar es posible en base a una probabilidad.
     * @param probabilidad: entero (int) que indica la probabilidad de que un evento suceda.
     * @return booleano que indica si el evento sucede o no.
     **/
    private boolean probabilidad(int probabilidad){
        
        return  random.nextInt(100) <= probabilidad;
        
    }
    
    /**
     * Devuelve una lectura de opcion como NUMERO ENTERO.
     * @return entero con opcion entre 1 y 2. 
     **/
    private int leerOpcion(){
        int opcion = 0; 
        boolean valido = false; 
        do{
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                valido = true; 
            } catch (Exception e) {
                //Repite el ingreso de la opcion
                System.out.println("Algo salio mal, asegurese de ingresar un numero entero.");
                valido = false; 
            }
            
        }while(!valido);
        return opcion; 
    }

    public void setAdversario(JugadorBasket adversario) {
        this.adversario = adversario;
    }

    
    public int getPunteo() {
        return punteo;
    }
}

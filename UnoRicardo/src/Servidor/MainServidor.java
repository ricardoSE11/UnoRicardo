/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Comun.IGame;
import Utils.Carta;
import Utils.Game;
import Utils.Jugador;import java.net.InetAddress;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class MainServidor implements java.io.Serializable 
{
    public static void main(String[] args) 
    {
        try
        {
            IGame juego = new Game();
            Registry myRegistry = LocateRegistry.createRegistry(9500);
            myRegistry.rebind("Juegito", juego);
            
            System.out.println("Servidor ON en: "+ InetAddress.getLocalHost().getHostAddress());
            
            int opt;
            do
            {
                System.out.println("Digite una opción: ");
                System.out.println("1. Información de Jugadores");
                System.out.println("2. Empezar juego");
                System.out.println("3. Terminar juego");
                System.out.println("4. Salir del menú");
                Scanner opcion = new Scanner(System.in);
                opt = opcion.nextInt();
                System.out.println("La opción fue: " + opt);
                if (opt == 1)
                {
                    //juego.setTurn(8);
                   for(Jugador currPlayer: juego.getJugadores())
                   {
                       System.out.println(currPlayer.toString());
                   }
                } 
                
                else if (opt == 2) 
                {
                    if (juego.isGameOn())
                    {
                        System.out.println("+----------------------------------------------------------+");
                        System.out.println("|           El juego ya empezó                             |"); 
                        System.out.println("+----------------------------------------------------------+");
                    }
                    
                    else if (juego.getJugadores().size() >= 2)
                    {
                        System.out.println("+----------------------------------------------------------+");
                        System.out.println("|            Juego iniciado                                |");
                        System.out.println("+----------------------------------------------------------+");
                        juego.startGame();
                    }

                    else  //(juego.getJugadores().size() < 2)
                        System.out.println("+----------------------------------------------------------+");
                        System.out.println("|        No hay suficientes jugadores                      |");
                        System.out.println("+----------------------------------------------------------+");
                }
                
                else if (opt == 3)
                {
                    juego.endGame();
                }
                

            } while (opt != 4);

        }
        
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private static void gui() throws RemoteException
    {

    }
    
    private static void autenticarse() throws RemoteException
    {
        System.out.println("Estoy autenticándome");
    }
    
}//End of class

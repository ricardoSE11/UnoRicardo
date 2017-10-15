/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Comun.IGame;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Game extends UnicastRemoteObject implements IGame , IObservable
{
    //------------- Atributes -------------
    private ArrayList<IObservador> observadores; //jugadores
    //private ArrayList<Jugador> players;
    private boolean gameOn;
    //private CardGenerator cardGenerator;
    //private ArrayList<Card> drawPile;
    //private ArrayList<Card> discardPile;
    private int turn; //will be assigned with matching IDs

    public Game() throws RemoteException
    {
        this.observadores = new ArrayList<>();
        this.gameOn = true;
        this.turn = 0;
    }

 
    
   public void añadirObservador(IObservador o)
   {
       observadores.add(o);
   }
   
   @Override
   public String enviarPipo(Pipo pipo) throws Exception 
   {
       //El print va para el Server, el return para el Cliente
       System.out.println(pipo.piposo.atributillo);
       return pipo.nombre;
   }

    @Override
    public int sumarATurno() throws Exception 
    {
        System.out.println("El cliente le está sumando a turno ");
        turn ++;
        notificar();
        return turn;
    }

    @Override
    public void notificar() {
         //for each
         for(IObservador o:observadores)
         {
             o.update();
         }
    }

    
}


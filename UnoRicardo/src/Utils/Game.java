/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Comun.IGame;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Game extends UnicastRemoteObject implements IGame , IObservable , Serializable
{
    //------------- Atributes -------------
    private ArrayList<IObservador> observadores; //jugadores
    private ArrayList<Jugador> players;
    private boolean gameOn;
    private GeneradorDeCartas generadorDeCartas;
    private ArrayList<Carta> drawPile;
    private ArrayList<Carta> discardPile;
    private int turn; //will be assigned with matching IDs

    public Game() throws RemoteException
    { 
        this.observadores = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gameOn = true;
        this.generadorDeCartas = new GeneradorDeCartas();
        this.drawPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
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

    //Utilizar este método, dentro de otro método que lo necesite. (Con el código adecuado)
    @Override
    public void notificar() {
         //for each
         for(IObservador o:observadores)
         {
             o.update();
         }
    }

    @Override
    public int getTurn() throws Exception {
        return this.turn;
    }

    @Override
    public ArrayList<IObservador> getObservadores() throws Exception {
       return this.observadores;
    }

    @Override
    public ArrayList<Jugador> getJugadores() throws Exception {
        return this.players;
    }

    
}


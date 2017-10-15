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


public class Game extends UnicastRemoteObject implements IGame
{
    //------------- Atributes -------------
    //public ArrayList<Jugador> players;
    public boolean gameOn;
    //public CardGenerator cardGenerator;
    //public ArrayList<Card> drawPile;
    //public ArrayList<Card> discardPile;
    public int turn; //will be assigned with matching IDs

   public Game() throws Exception
   {
       this.gameOn = true;
       this.turn = 0;
   }
    
    
   @Override
   public String enviarPipo(Pipo pipo) throws Exception 
   {
       //El print va para el Server, el return para el Cliente
       System.out.println(pipo.piposo.atributillo);
       return pipo.nombre;
   }

    
}


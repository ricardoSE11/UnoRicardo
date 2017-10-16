/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import Utils.Carta;
import Utils.IObservador;
import Utils.Jugador;
import Utils.Pipo;
import java.rmi.Remote;
import java.util.ArrayList;


public interface IGame extends Remote
{
    public String enviarPipo(Pipo pipo)throws Exception;
    
    public int sumarATurno()throws Exception;
    
    public void añadirObservador(IObservador o)throws Exception;
    
    public int getTurn()throws Exception;
    
    public ArrayList<IObservador> getObservadores ()throws Exception;
    
    public ArrayList<Jugador> getJugadores() throws Exception;
    
    public void añadirJugador(Jugador j) throws Exception;
    
    public void shuffleCards(ArrayList<Carta> deck)throws Exception;
    
    public void inicializarDrawPile()throws Exception;
    
    public void dealCardsToPlayer(Jugador j)throws Exception;
    
    public void dealCardsToAllPlayers()throws Exception;

}

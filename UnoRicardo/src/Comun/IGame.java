/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import Utils.Carta;
import Utils.IObservador;
import Utils.Jugador;
import java.rmi.Remote;
import java.util.ArrayList;


public interface IGame extends Remote
{
    
    public int sumarATurno()throws Exception;
    
    public void añadirObservador(IObservador o)throws Exception;
    
    public int getTurn()throws Exception;
    
    public ArrayList<IObservador> getObservadores ()throws Exception;
    
    public ArrayList<Jugador> getJugadores() throws Exception;
    
    public void añadirJugador(Jugador j) throws Exception;
    
    public void shuffleCards()throws Exception;
    
    public void initializeDrawPile()throws Exception;
    
    public void dealCardsToPlayer(Jugador j)throws Exception;
    
    public void dealCardsToAllPlayers()throws Exception;
    
    public ArrayList<Carta> getDrawPile()throws Exception;
    
    public ArrayList<Carta> getDiscardPile()throws Exception;
    
    public boolean isGameOn()throws Exception;
    
    public ArrayList<Carta> drawACard(int playerID , int amountOfCards)throws Exception;
    
    public void initializeDiscardPile()throws Exception;
    
    public boolean isPlayValid(Carta cardToPlay)throws Exception;
    
    public boolean placeCardOnDiscardPile(Carta playedCard)throws Exception;
    
    public void startGame()throws Exception;
    
    public void endGame()throws Exception;
    
    public void setTurn(int turno)throws Exception;
    
    public void getNexTurn()throws Exception;
    
    public void setJugadores(ArrayList<Jugador> jugadores) throws Exception;
    
    public void reversa()throws Exception;
    
    public void removeCardFromPlayer(int playerID , int cardIndex) throws Exception;
    
    public int getNextTurn(int currentNumber) throws Exception;
    
    public boolean callUNO(int playerID)throws Exception;
    
    public boolean getEndGame()throws Exception;

}

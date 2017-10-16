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
        this.gameOn = false;
        this.generadorDeCartas = new GeneradorDeCartas();
        this.drawPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.turn = 0; //Debe empezar en 1 porque el primer ID va a ser 1
    }


   public void añadirObservador(IObservador o)
   {
       System.out.println("Agregando al observador:" + o.toString());
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
        System.out.println("Estamos notificando a los observadores");
         //for each
         for(IObservador o:observadores)
         {
             o.hasToStartGUIS();
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

    @Override
    public void añadirJugador(Jugador j) throws Exception {
        int nuevoID = players.size() + 1;
        j.setId(nuevoID);
        System.out.println("Estamos añadiendo al jugador:" + j.getName() + "con el ID: " + nuevoID);
        notificar();
        this.players.add(j);
    }

    @Override
    public void shuffleCards() throws Exception {
        int largo = this.drawPile.size();
        for (int i = 0 ; i < largo ; i++)
        {
            int nuevaPosicion = i + (int)(Math.random() * (largo - i));
            //Intercambiamos la posición de dos cartas
            Carta cartaActual = this.drawPile.get(i);
            Carta cartaTemporal = this.drawPile.get(nuevaPosicion);
            this.drawPile.set(nuevaPosicion, cartaActual);
            this.drawPile.set(i, cartaTemporal);
        }
       
    }
    
    @Override
    public void initializeDrawPile() throws Exception {
        System.out.println("Estamos inicializando el DrawPile con: " + players.size() + "jugadores");
         this.drawPile = generadorDeCartas.generateBiggerDeck(players.size());
    }
    
    //Antes de usar este método hay que inicializar el deck del cual se va a repartir
    @Override
    public void dealCardsToPlayer(Jugador j) throws Exception {
        for (int i = 0 ; i < 7 ; i++)
        {
            ArrayList<Carta> manoDeJugador = j.getHand();
            Carta cartaActual = drawPile.get(i);
            //Agregamos la carta a la mano del jugador y la eliminamos del maso
            manoDeJugador.add(cartaActual);
            drawPile.remove(cartaActual);
        }
    }

    @Override
    public void dealCardsToAllPlayers() throws Exception {
        int cantidadJugadores = players.size();
        System.out.println("Estamos repartiendo cartas a:" + cantidadJugadores + "jugadores");
        for (int i = 0 ; i < cantidadJugadores ; i++)
        {
            dealCardsToPlayer(players.get(i));
        }
    }

    @Override
    public ArrayList<Carta> getDrawPile() throws Exception {
        return this.drawPile;
    }

    @Override
    public ArrayList<Carta> getDiscardPile() throws Exception {
        return this.discardPile;
    }

    @Override
    public boolean isGameOn() throws Exception {
        return this.gameOn;
    }

    @Override
    public ArrayList<Carta> drawACard(Jugador j, int amountOfCards) throws Exception {
        System.out.println("El jugador: " + j.getName() + "está agarrando " + amountOfCards + " cartas." );
        ArrayList<Carta> drawedCards = new ArrayList<>();
        ArrayList<Carta> playerHand = j.getHand();
        for (int i = 0; i < amountOfCards ; i++)
        {
            Carta cardToDraw = drawPile.get(0);
            playerHand.add(cardToDraw);
            drawedCards.add(cardToDraw);
            drawPile.remove(cardToDraw);
        }
        return drawedCards;
    }

    //El DrawPile debe ser inicializado antes de usar este método
    @Override
    public void initializeDiscardPile() throws Exception {
        int largo = drawPile.size();
        for (int i = 0; i < largo ; i++)
        {
            Carta firstCard = drawPile.get(i);
            if (!firstCard.getTipo().equals(Tipo.TRAMPA))
            {
                discardPile.add(firstCard);
                drawPile.remove(firstCard);
                break;
            }
        }

    }

    @Override
    public boolean isPlayValid(Carta cardToPlay) throws Exception {
        int lastCardIndex = discardPile.size() - 1;
        Carta cardToCompareWith = discardPile.get(lastCardIndex);
        
        //Color
        if (cardToPlay.getColor().equals(cardToCompareWith.getColor()))
            return true;
        
        //Símbolo
        else if (cardToPlay.getNombre().equals(cardToCompareWith.getNombre()))
            return true;
        
        //Si es un comodín
        else if (cardToPlay.getColor().equals(Color.NEGRO))
            return true;
        
        return false;
    }

    // ----------------------------Pendiente-----------------------------------
    @Override
    public boolean placeCardOnDiscardPile(Carta playedCard) throws Exception {
        if (isPlayValid(playedCard))
        {
            System.out.println("Se jugó la carta: " + playedCard.getNombre().toString()  + " " + playedCard.getColor().toString());
            discardPile.add(playedCard);
            return true;
        }
        
        else
        {
            System.out.println("No se puede jugar la carta: " + playedCard.getNombre().toString()  + " " + playedCard.getColor().toString());
            return false;
        }
    }


    


    
}


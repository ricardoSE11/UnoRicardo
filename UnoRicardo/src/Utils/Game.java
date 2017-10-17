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

public class Game extends UnicastRemoteObject implements IGame, IObservable, Serializable {

    //------------- Atributes -------------
    private ArrayList<IObservador> observadores; //jugadores
    private ArrayList<Jugador> players;
    private boolean gameOn;
    private GeneradorDeCartas generadorDeCartas;
    private ArrayList<Carta> drawPile;
    private ArrayList<Carta> discardPile;
    private int primerTurno;
    private int ultimoTurno;
    private int turn; //will be assigned with matching IDs
    private boolean adelante; //Quiere decir que los turnos van del menor al mayor

    public Game() throws RemoteException {
        this.observadores = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gameOn = false;
        this.generadorDeCartas = new GeneradorDeCartas();
        this.drawPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.primerTurno = 1;
        this.ultimoTurno = players.size();
        this.turn = 1; //Debe empezar en 1 porque el primer ID va a ser 1
        this.adelante = true;
    }

    public void añadirObservador(IObservador o) {
        System.out.println("Agregando al observador:" + o.toString());
        observadores.add(o);
    }

    @Override
    public String enviarPipo(Pipo pipo) throws Exception {
        //El print va para el Server, el return para el Cliente
        System.out.println(pipo.piposo.atributillo);
        return pipo.nombre;
    }

    @Override
    public int sumarATurno() throws Exception {
        System.out.println("El cliente le está sumando a turno ");
        turn++;
        notificar();
        return turn;
    }

    //Utilizar este método, dentro de otro método que lo necesite. (Con el código adecuado)
    @Override
    public void notificar() {
        //System.out.println("Estamos notificando a los observadores");
        //for each
        for (IObservador o : observadores) {
            o.update();
        }
    }

    @Override
    public int getTurn() throws Exception {
        notificar();
        return this.turn;
    }

    @Override
    public ArrayList<IObservador> getObservadores() throws Exception {
        return this.observadores;
    }

    @Override
    public ArrayList<Jugador> getJugadores() throws Exception {
        notificar();
        return this.players;
    }

    @Override
    public void añadirJugador(Jugador j) throws Exception {
        notificar();
        int nuevoID = players.size() + 1;
        j.setId(nuevoID);
        System.out.println("Estamos añadiendo al jugador: " + j.getName() + " con el ID: " + nuevoID);
        notificar();
        this.players.add(j);
    }

    @Override
    public void shuffleCards() throws Exception {
        notificar();
        int largo = this.drawPile.size();
        for (int i = 0; i < largo; i++) {
            int nuevaPosicion = i + (int) (Math.random() * (largo - i));
            //Intercambiamos la posición de dos cartas
            Carta cartaActual = this.drawPile.get(i);
            Carta cartaTemporal = this.drawPile.get(nuevaPosicion);
            this.drawPile.set(nuevaPosicion, cartaActual);
            this.drawPile.set(i, cartaTemporal);
        }

    }

    @Override
    public void initializeDrawPile() throws Exception {
        notificar();
        System.out.println("Estamos inicializando el DrawPile con: " + players.size() + " jugadores");
        this.drawPile = generadorDeCartas.generateBiggerDeck(players.size());
    }

    //Antes de usar este método hay que inicializar el deck del cual se va a repartir
    @Override
    public void dealCardsToPlayer(Jugador j) throws Exception {
        notificar();
        for (int i = 0; i < 7; i++) {
            ArrayList<Carta> manoDeJugador = j.getHand();
            Carta cartaActual = drawPile.get(i);
            //Agregamos la carta a la mano del jugador y la eliminamos del maso
            manoDeJugador.add(cartaActual);
            drawPile.remove(cartaActual);
        }
    }

    @Override
    public void dealCardsToAllPlayers() throws Exception {
        notificar();
        int cantidadJugadores = players.size();
        System.out.println("Estamos repartiendo cartas a: " + cantidadJugadores + " jugadores");
        for (int i = 0; i < cantidadJugadores; i++) {
            dealCardsToPlayer(players.get(i));
        }
    }

    @Override
    public ArrayList<Carta> getDrawPile() throws Exception {
        notificar();
        return this.drawPile;
    }

    @Override
    public ArrayList<Carta> getDiscardPile() throws Exception {
        notificar();
        return this.discardPile;
    }

    @Override
    public boolean isGameOn() throws Exception {
        notificar();
        return this.gameOn;
    }

    @Override
    public ArrayList<Carta> drawACard(int playerID, int amountOfCards) throws Exception {
        notificar();
        Jugador j = players.get(playerID);
        System.out.println("+-------------------------------------------------------------------------- +");
        System.out.println("|El jugador: " + j.getName() + " está agarrando " + amountOfCards + " cartas.|");
        System.out.println("+-------------------------------------------------------------------------- +");
        ArrayList<Carta> drawedCards = new ArrayList<>();
        ArrayList<Carta> playerHand = j.getHand();
        for (int i = 0; i < amountOfCards; i++) {
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
        notificar();
        int largo = drawPile.size();
        for (int i = 0; i < largo; i++) {
            Carta firstCard = drawPile.get(i);
            if (!firstCard.getTipo().equals(Tipo.TRAMPA)) {
                discardPile.add(firstCard);
                drawPile.remove(firstCard);
                break;
            }
        }

    }

    @Override
    public boolean isPlayValid(Carta cardToPlay) throws Exception {
        notificar();
        int lastCardIndex = discardPile.size() - 1;
        Carta cardToCompareWith = discardPile.get(lastCardIndex);

        //Color
        if (cardToPlay.getColor().equals(cardToCompareWith.getColor())) {
            return true;
        } //Símbolo
        else if (cardToPlay.getNombre().equals(cardToCompareWith.getNombre())) {
            return true;
        } //Si es un comodín
        else if (cardToPlay.getColor().equals(Color.NEGRO)) {
            return true;
        }

        return false;
    }

    // ----------------------------Pendiente-----------------------------------
    @Override
    public boolean placeCardOnDiscardPile(Carta playedCard) throws Exception {
        notificar();
        if (isPlayValid(playedCard)) {
            Tipo currentTipo = null;
            switch (currentTipo) {
                case TRAMPA:
                    if (playedCard.getNombre().equals(Nombre.SALTA)) {
                    }

                    if (playedCard.getNombre().equals(Nombre.REVERSA)) {
                    }

                    if (playedCard.getNombre().equals(Nombre.TOMADOS)) {
                    }

                    if (playedCard.getNombre().equals(Nombre.COMODIN4)) {
                    }

                    if (playedCard.getNombre().equals(Nombre.COMODIN)) {
                    }

                case NUMERAL:
                    discardPile.add(playedCard);
                    return true;
            }
            System.out.println("Se jugó la carta: " + playedCard.getNombre().toString() + " " + playedCard.getColor().toString());
            
        }
        
        else 
        {
            System.out.println("No se puede jugar la carta: " + playedCard.getNombre().toString() + " " + playedCard.getColor().toString());
            return false;
        }
        return false;
    }

    @Override
    public void startGame() throws Exception {
        notificar();
        initializeDrawPile();
        shuffleCards();
        dealCardsToAllPlayers();
        initializeDiscardPile();
        this.turn = 1;
        this.ultimoTurno = players.size();

    }

    @Override
    public void endGame() throws Exception {
        notificar();
        this.gameOn = false;
    }

    //Método de prueba
    @Override
    public void setTurn(int turno) throws Exception {
        notificar();
        this.turn = turno;
    }

    @Override
    public void getNexTurn() throws Exception {
        if (adelante == true) {
            if (turn + 1 > ultimoTurno) {
                turn = primerTurno;
            } else {
                turn += 1;
            }

        } else {
            if (turn - 1 == 0) {
                turn = ultimoTurno;
            } else {
                turn -= 1;
            }
        }

        notificar();
        System.out.println("El turno quedó en el valor: " + turn);

    }

    @Override
    public void reversa() throws Exception {
        notificar();
        adelante = false;
    }

    @Override
    public void setJugadores(ArrayList<Jugador> jugadores) throws Exception {
        this.players = jugadores;
    }

    @Override
    public void removeCardFromPlayer(int playerID, int cardIndex) throws Exception {
        Jugador selectedPlayer = this.players.get(playerID);
        Carta cardToRemove = selectedPlayer.getHand().get(cardIndex);
        selectedPlayer.getHand().remove(cardIndex);
    }

}

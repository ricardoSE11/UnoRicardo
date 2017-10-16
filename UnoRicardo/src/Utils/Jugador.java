
package Utils;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;


public class Jugador implements IObservador, Serializable 
{
    private String ip;
    private int id;
    private String name;
    private ArrayList<Carta> hand;
    private boolean turn;
    private boolean hasOnecard;

    public Jugador(String nombre, String ipDeJugador)
    {
        this.ip = ipDeJugador;
        int id = 0; //Cambiar este valor
        this.name = nombre;
        this.hand = new ArrayList<>();
        this.turn = false;
        this.hasOnecard = false;   
    }
    
    public String getName()
    {
        return this.name;
    }

    public String getIP() {
        return ip;
    }

    public void setIP(String IP) {
        this.ip = IP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Carta> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Carta> hand) {
        this.hand = hand;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isHasOnecard() {
        return hasOnecard;
    }

    public void setHasOnecard(boolean hasOnecard) {
        this.hasOnecard = hasOnecard;
    }
    
    
    
    @Override
    public void update() {
        //acción a realizar después de que se juegue una carta o algo así
        System.out.println("EL JUEGO ESTÁ HACIENDO CAMBIOS");
    }
}

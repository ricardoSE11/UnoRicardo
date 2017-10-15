
package Utils;

import java.io.Serializable;
import java.util.ArrayList;


public class Jugador implements IObservador, Serializable 
{
    private String IP;
    private int id;
    private String name;
    //private ArrayList<Card> hand;
    private boolean turn;
    private boolean hasOnecard;

    public Jugador()
    {
    }
    
    @Override
    public void update() {
        //acción a realizar después de que se juegue una carta o algo así
        System.out.println("EL JUEGO HA CAMBIADO");
    }
}

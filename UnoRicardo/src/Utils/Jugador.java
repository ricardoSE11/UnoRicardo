
package Utils;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;


public class Jugador implements IObservador, Serializable 
{
    private String IP;
    private int id;
    private String name;
    private ArrayList<Carta> hand;
    private boolean turn;
    private boolean hasOnecard;

    public Jugador(String nombre)
    {
        this.name = nombre;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public void update() {
        //acción a realizar después de que se juegue una carta o algo así
        System.out.println("EL JUEGO ESTÁ HACIENDO CAMBIOS");
    }
}

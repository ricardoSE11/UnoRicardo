
package Utils;

import java.io.Serializable;


public class Carta implements Serializable
{
    private Color color;
    private Tipo tipo;
    private Nombre nombre;
    

    public Carta(Color color, Tipo tipo, Nombre nombre) 
    {
        this.color = color;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

  
}

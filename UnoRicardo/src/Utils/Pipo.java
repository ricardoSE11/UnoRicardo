/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.Serializable;

public class Pipo implements Serializable {
    String nombre;
    int id;
    Piposo piposo;

    public Pipo(String nombre, int id, Piposo piposo) {
        this.nombre = nombre;
        this.id = id;
        this.piposo = piposo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Piposo getPiposo() {
        return piposo;
    }

    public void setPiposo(Piposo piposo) {
        this.piposo = piposo;
    }


}

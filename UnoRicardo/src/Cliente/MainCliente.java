/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Comun.IGame;
import Utils.Jugador;
import Utils.Pipo;
import Utils.Piposo;
import Views.MainWindow;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author rshum
 */
public class MainCliente {
    
    public static void main(String[] args) 
    {
        Jugador jugador = new Jugador("Paquito");
        System.out.println("Nombre: " + jugador.getName());
        try 
        {
            Registry miRegistro = LocateRegistry.getRegistry("200.200.10.36" , 9500);
            IGame juego = (IGame)miRegistro.lookup("Juegito");
            
            //Sección de pruebas
            juego.añadirObservador(jugador);
            System.out.println("Si sirve, esto debería dar 1 + 1 = "  +juego.enviarPipo(new Pipo("Nombre del Pipo", 2 , new Piposo("El atributillo de Piposo"))));
            System.out.println("Si esto funciona, tengo una noción de cómo usar el patrón: " + juego.sumarATurno());
            System.out.println("Esto debería servir: " + juego.getTurn());
            System.out.println(juego.getObservadores().get(0).toString());
            
            MainWindow mw = new MainWindow(juego);
            mw.setVisible(true);
            
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

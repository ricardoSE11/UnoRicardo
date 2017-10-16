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
import Views.PlayWindow;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author rshum
 */
public class MainCliente {
    
    public static void main(String[] args) 
    {
        try 
        {
            //ip "200.200.10.36"
            String ip = InetAddress.getLocalHost().getHostAddress();
            Registry miRegistro = LocateRegistry.getRegistry(ip , 9500);
            IGame juego = (IGame)miRegistro.lookup("Juegito");
            
            //Sección de pruebas
              //-------o-------\\
            //Termina sección de pruebas
            
            MainWindow mw = new MainWindow(juego);
            mw.setVisible(true);
            
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

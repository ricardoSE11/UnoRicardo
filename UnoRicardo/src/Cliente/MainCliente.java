/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Comun.IGame;
import Views.MainWindow;
import Views.ServerIPDialog;

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

            ServerIPDialog ipDialog=new ServerIPDialog();//Crea el dialog
            ipDialog.pack();//lo carga

            ipDialog.setVisible(true);//Lo muestra
            String serverIP= ipDialog.getIp();//Obtiene el ip digitado
            Registry miRegistro = LocateRegistry.getRegistry(serverIP , 9500);
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

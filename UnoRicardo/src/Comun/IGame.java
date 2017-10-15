/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun;

import Utils.Pipo;
import java.rmi.Remote;


public interface IGame extends Remote
{
    public String enviarPipo(Pipo pipo)throws Exception;
    
    
    
    
}

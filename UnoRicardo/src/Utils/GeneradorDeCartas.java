/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;

/**
 *
 * @author rshum
 */
public class GeneradorDeCartas {
    
   public GeneradorDeCartas()
   {
       
   }
   
   public ArrayList<Carta> generateRedCards()
   {
       ArrayList<Carta> deck;
       deck = new ArrayList<>();
       
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.CERO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.NUEVE));
       deck.add(new Carta(Color.ROJO, Tipo.NUMERAL, Nombre.NUEVE));
       
       deck.add(new Carta(Color.ROJO, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.ROJO, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.ROJO, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.ROJO, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.ROJO, Tipo.TRAMPA, Nombre.REVERSA));
       deck.add(new Carta(Color.ROJO, Tipo.TRAMPA, Nombre.REVERSA));
       
       return deck;
   }
    
   public ArrayList<Carta> generateBlueCards()
   {
       ArrayList<Carta> deck;
       deck = new ArrayList<>();
       
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.CERO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.NUEVE));
       deck.add(new Carta(Color.AZUL, Tipo.NUMERAL, Nombre.NUEVE));
       
       deck.add(new Carta(Color.AZUL, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.AZUL, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.AZUL, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.AZUL, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.AZUL, Tipo.TRAMPA, Nombre.REVERSA));
       deck.add(new Carta(Color.AZUL, Tipo.TRAMPA, Nombre.REVERSA));
       
       return deck;
   }
   
   public ArrayList<Carta> generateGreenCards()
   {
       ArrayList<Carta> deck;
       deck = new ArrayList<>();
       
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.CERO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.NUEVE));
       deck.add(new Carta(Color.VERDE, Tipo.NUMERAL, Nombre.NUEVE));
       
       deck.add(new Carta(Color.VERDE, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.VERDE, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.VERDE, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.VERDE, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.VERDE, Tipo.TRAMPA, Nombre.REVERSA));
       deck.add(new Carta(Color.VERDE, Tipo.TRAMPA, Nombre.REVERSA));
       
       return deck;
   }
   
   
   
}//End of class


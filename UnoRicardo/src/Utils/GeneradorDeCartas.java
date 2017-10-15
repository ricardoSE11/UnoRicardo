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
   
   public ArrayList<Carta> generateDeck()
   {
       ArrayList<Carta> deckBasico = new ArrayList<>();
       for (int i = 0 ; i < 25 ; i++)
       {
           deckBasico.add(generateRedCards().get(i));
           deckBasico.add(generateBlueCards().get(i));
           deckBasico.add(generateGreenCards().get(i));
           deckBasico.add(generateYellowCards().get(i));
       }
       
       for (int j = 0 ; j < 8 ; j++)
       {
           deckBasico.add(generateWildCards().get(j));
       }
       
       return deckBasico;
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
   
   public ArrayList<Carta> generateYellowCards()
   {
       ArrayList<Carta> deck;
       deck = new ArrayList<>();
       
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.CERO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.UNO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.DOS));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.TRES));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.CUATRO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.CINCO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.SEIS));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.SIETE));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.OCHO));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.NUEVE));
       deck.add(new Carta(Color.AMARILLO, Tipo.NUMERAL, Nombre.NUEVE));
       
       deck.add(new Carta(Color.AMARILLO, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.AMARILLO, Tipo.TRAMPA, Nombre.SALTA));
       deck.add(new Carta(Color.AMARILLO, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.AMARILLO, Tipo.TRAMPA, Nombre.TOMADOS));
       deck.add(new Carta(Color.AMARILLO, Tipo.TRAMPA, Nombre.REVERSA));
       deck.add(new Carta(Color.AMARILLO, Tipo.TRAMPA, Nombre.REVERSA));
       
       return deck;
   }
   
   public ArrayList<Carta> generateWildCards()
   {
       ArrayList<Carta> deckOfWilds;
       deckOfWilds = new ArrayList<>();
       
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN4));
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN4));
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN4));
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN4));
       
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN));
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN));
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN));
       deckOfWilds.add(new Carta(Color.NEGRO, Tipo.TRAMPA, Nombre.COMODIN));
       
       return deckOfWilds;
   }
   
}//End of class


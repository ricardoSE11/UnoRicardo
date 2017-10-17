/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Utils.Game;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Utils.Jugador;
import Comun.IGame;
import Utils.Carta;
import Utils.IObservador;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;


public class PlayWindow extends javax.swing.JFrame implements IObservador, Serializable {
    IGame game;
    Jugador jugador;
    private List<JButton> botonesDeCartas ; //lista de Botones
    private int indice;
    private int cartaEscogida;
    String ip;


    // -------------------Constructor---------------------------
    public PlayWindow(IGame g , Jugador j, String ip) throws Exception
    {
        initComponents();//SUMAMENTE IMPORTANTE
        this.botonesDeCartas = new ArrayList<>();
        this.jugador = j;
        this.game = g;
        this.ip = ip;
        

    }


    // --------------------------- Methods ---------------------------
    public void placeGraphicCard(String nameOfImage)
    {
        update();
        JButton botonDeCarta = new JButton();
        botonDeCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Resources/"+nameOfImage+".png")));
        this.cardsDisplayPanel.add(botonDeCarta);
        this.botonesDeCartas.add(botonDeCarta);
        
        
        botonDeCarta.addActionListener(new ActionListener() 
        {
            
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                cartaEscogida = botonesDeCartas.indexOf(botonDeCarta);
                //Si = 0, No = otra cosa >.<
                int yesOrNo = JOptionPane.showConfirmDialog(null, "¿Desea jugar esta carta?" ,
                        "Confirmación de jugada", JOptionPane.YES_NO_OPTION );

                if (yesOrNo == 0)
                {
                    //Aquí debe ir el método de jugar del jugador respectivo.

                    boolean wasPlayed;
                    update();
                    try 
                    {
                        int id = jugador.getId() - 1;
                        Jugador player = game.getJugadores().get(id);
                        
                        Carta playedCard = player.playCarta(cartaEscogida);
                        System.out.println("CARTA SELECCIONADA: " + playedCard.getNombre() + " COLOR: " + playedCard.getColor());
                        System.out.println("En botones de carta es: " + cartaEscogida);
                        System.out.println("En cardsDisplayPanel es: " + cardsDisplayPanel.getComponent(cartaEscogida).getX());
                        
                        wasPlayed = game.placeCardOnDiscardPile(playedCard);//Si fue posicionada en DiscardPile
                        if (wasPlayed)
                        {
                            
                            cardsDisplayPanel.remove(cartaEscogida);
                            botonesDeCartas.remove(cartaEscogida);
                            game.removeCardFromPlayer(id, cartaEscogida);
                            
                            game.getNexTurn();
                        }
                        
                        else
                        {
                            update();
                            System.out.println("El jugador: " + jugador.getName() + " intentó  la carta: " + playedCard.getNombre() + " " + playedCard.getColor());
                            JOptionPane.showMessageDialog(null, "Jugada inválida.");
                        }
                    } 
                    
                    catch (Exception ex) 
                    {
                        Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    
                }
                update();
            }
        });
        
        indice++ ;
        this.cardsDisplayPanel.updateUI();
    }
        
    public void placeOneCard(Carta c)
    {
        String nombreImagen = c.getNombre().toString() + c.getColor().toString();
   
        placeGraphicCard(nombreImagen.toLowerCase());
    }
    
    public void placePlayerCards(Jugador j)
    {
        int largo = j.getHand().size();
        for (int i = 0; i < largo ; i++)
        {
            Carta currentCard = j.getHand().get(i);
            placeOneCard(currentCard);
        }
    }
    
    public String getCardString(Carta c)
    {
        String nombreImagen = c.getNombre().toString() + c.getColor().toString();
        return (nombreImagen.toLowerCase());
    }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        cardsDisplay = new javax.swing.JScrollPane();
        cardsDisplayPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnStartGame = new javax.swing.JButton();
        btnSetDiscardPile = new javax.swing.JButton();
        btnCantCartas = new javax.swing.JButton();
        txfCantCartas = new javax.swing.JTextField();
        drawAndDiscardPanel = new javax.swing.JPanel();
        btnDrawPile = new javax.swing.JButton();
        lblDiscardPile = new javax.swing.JLabel();
        serverPanel = new javax.swing.JPanel();
        txfGameTurn = new javax.swing.JTextField();
        serverList = new java.awt.List();
        btnCantidadJugadores = new javax.swing.JButton();
        btnSeePlayerID = new javax.swing.JButton();
        btnGameTurn = new javax.swing.JButton();
        callUNOPanel = new javax.swing.JPanel();
        btnCallUNO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelFondo.setBackground(new java.awt.Color(204, 0, 0));
        panelFondo.setForeground(new java.awt.Color(204, 0, 51));

        cardsDisplayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardsDisplayPanelMouseClicked(evt);
            }
        });
        cardsDisplayPanel.setLayout(new java.awt.GridLayout(0, 7));
        cardsDisplay.setViewportView(cardsDisplayPanel);

        btnStartGame.setText("Ver cartas");
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        btnSetDiscardPile.setText("Actualizar Discard Pile");
        btnSetDiscardPile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetDiscardPileActionPerformed(evt);
            }
        });

        btnCantCartas.setText("Cantidad de Cartas");
        btnCantCartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantCartasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetDiscardPile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCantCartas)
                    .addComponent(txfCantCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txfCantCartas))
                    .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSetDiscardPile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCantCartas))
                .addGap(12, 12, 12))
        );

        btnDrawPile.setIcon(new javax.swing.ImageIcon("f:\\Users\\rshum\\Downloads\\Images\\dorso.png")); // NOI18N
        btnDrawPile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawPileActionPerformed(evt);
            }
        });

        lblDiscardPile.setBackground(new java.awt.Color(153, 51, 255));

        javax.swing.GroupLayout drawAndDiscardPanelLayout = new javax.swing.GroupLayout(drawAndDiscardPanel);
        drawAndDiscardPanel.setLayout(drawAndDiscardPanelLayout);
        drawAndDiscardPanelLayout.setHorizontalGroup(
            drawAndDiscardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drawAndDiscardPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblDiscardPile, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnDrawPile, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        drawAndDiscardPanelLayout.setVerticalGroup(
            drawAndDiscardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drawAndDiscardPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(drawAndDiscardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDrawPile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiscardPile, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        serverPanel.setBackground(new java.awt.Color(102, 102, 102));

        serverList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverListActionPerformed(evt);
            }
        });

        btnCantidadJugadores.setText("Cantidad de Jugadores");
        btnCantidadJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadJugadoresActionPerformed(evt);
            }
        });

        btnSeePlayerID.setText("Player ID");
        btnSeePlayerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePlayerIDActionPerformed(evt);
            }
        });

        btnGameTurn.setText("Turno");
        btnGameTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameTurnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout serverPanelLayout = new javax.swing.GroupLayout(serverPanel);
        serverPanel.setLayout(serverPanelLayout);
        serverPanelLayout.setHorizontalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serverPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(serverList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(serverPanelLayout.createSequentialGroup()
                        .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeePlayerID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGameTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCantidadJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfGameTurn, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        serverPanelLayout.setVerticalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serverPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serverList, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfGameTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGameTurn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCantidadJugadores)
                    .addComponent(btnSeePlayerID))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnCallUNO.setIcon(new javax.swing.ImageIcon("f:\\Users\\rshum\\Desktop\\ImagenesUNO\\UNO.png")); // NOI18N
        btnCallUNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallUNOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout callUNOPanelLayout = new javax.swing.GroupLayout(callUNOPanel);
        callUNOPanel.setLayout(callUNOPanelLayout);
        callUNOPanelLayout.setHorizontalGroup(
            callUNOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(callUNOPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnCallUNO, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        callUNOPanelLayout.setVerticalGroup(
            callUNOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCallUNO, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawAndDiscardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(serverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(callUNOPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(drawAndDiscardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(cardsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(serverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(callUNOPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Aquí se desactiva el botón de UNO. PROGRAMAR, POSTERIORMENTE, ADECUADAMENTE.
    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed

        btnStartGame.setEnabled(false);
        update();
        int id = jugador.getId() - 1;
        try 
        {
            Jugador player = game.getJugadores().get(id);
            placePlayerCards(player);
        } 
        
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnStartGameActionPerformed

    private void cardsDisplayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardsDisplayPanelMouseClicked

    }//GEN-LAST:event_cardsDisplayPanelMouseClicked

    private void btnDrawPileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawPileActionPerformed

        update();
        int id = jugador.getId() - 1; //Este jugador no es el que está jugando

        try 
        {
            Jugador player = game.getJugadores().get(id);
            ArrayList<Carta> drawedCards = game.drawACard(id, 1);
            int largo = drawedCards.size();
            for (int i = 0 ; i < largo ; i++)
            {
                
                placeOneCard(drawedCards.get(i));
            }
        } 
        
        catch (Exception ex)
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        update();
    }//GEN-LAST:event_btnDrawPileActionPerformed

    private void serverListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverListActionPerformed

    private void btnCantidadJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadJugadoresActionPerformed

        update();
        int numDePrueba;
        try 
        {
            numDePrueba = game.getJugadores().size();
            String stringDePrueba = Integer.toString(numDePrueba);
            serverList.add(stringDePrueba);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        update();
    }//GEN-LAST:event_btnCantidadJugadoresActionPerformed

    private void btnSeePlayerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePlayerIDActionPerformed

        update();
        int id = jugador.getId() - 1;
        int realID = id + 1;
        try 
        {
            Jugador player = game.getJugadores().get(id);
            //int amountOfCards = player.getHand().size();
            serverList.add(Integer.toString(realID));
            //serverList.removeAll();
        } 
        
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSeePlayerIDActionPerformed

    private void btnCallUNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallUNOActionPerformed

        update();
    }//GEN-LAST:event_btnCallUNOActionPerformed

    private void btnSetDiscardPileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetDiscardPileActionPerformed

        update();
        //Hace visible la última carta que esta en la DiscardPile
        int lastCardIndex = 0;
        try 
        {   
            lastCardIndex = game.getDiscardPile().size() - 1;
            Carta lastCard = game.getDiscardPile().get(lastCardIndex);
            String imgString = getCardString(lastCard);
            lblDiscardPile.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Resources/" + imgString + ".png")));
        } 
        
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSetDiscardPileActionPerformed

    private void btnGameTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameTurnActionPerformed

        update();
        int turnoActual = 0;
        try 
        {
            turnoActual = game.getTurn();
        } 
        
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String turno = Integer.toString(turnoActual);
        txfGameTurn.setText(turno);
        update();
    }//GEN-LAST:event_btnGameTurnActionPerformed

    private void btnCantCartasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantCartasActionPerformed

        update();
        int id = jugador.getId() - 1;
        Jugador player;
        try 
        {
            player = game.getJugadores().get(id);
            int cantCartas = player.getHand().size();
            txfCantCartas.setText(Integer.toString(cantCartas));        
            update();
        }
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_btnCantCartasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCallUNO;
    private javax.swing.JButton btnCantCartas;
    private javax.swing.JButton btnCantidadJugadores;
    private javax.swing.JButton btnDrawPile;
    private javax.swing.JButton btnGameTurn;
    private javax.swing.JButton btnSeePlayerID;
    private javax.swing.JButton btnSetDiscardPile;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JPanel callUNOPanel;
    private javax.swing.JScrollPane cardsDisplay;
    private javax.swing.JPanel cardsDisplayPanel;
    private javax.swing.JPanel drawAndDiscardPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDiscardPile;
    private javax.swing.JPanel panelFondo;
    private java.awt.List serverList;
    private javax.swing.JPanel serverPanel;
    private javax.swing.JTextField txfCantCartas;
    private javax.swing.JTextField txfGameTurn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() 
    {
        int id = jugador.getId() - 1;
        Jugador player;

        Registry miRegistro;
        
        try 
        {
            player = game.getJugadores().get(id);
            int cantCartas = player.getHand().size();
            if (cantCartas == 1)
            {
                btnCallUNO.setEnabled(true);
            }
            
            else
            {
                btnCallUNO.setEnabled(true);
            }
            
            if (game.getTurn() != jugador.getId()) 
            {
                for (JButton boton : botonesDeCartas) 
                {
                    boton.setEnabled(false);
                }
            }
            
            else
            {
                for (JButton boton : botonesDeCartas) 
                {
                    boton.setEnabled(true);
                }
            }
            
            miRegistro = LocateRegistry.getRegistry(ip , 9500);
            IGame juego = (IGame)miRegistro.lookup("Juegito");

            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(PlayWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}

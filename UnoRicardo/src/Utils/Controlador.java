
package Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controlador implements ActionListener
{
    Game game;

    public Controlador(Game game) 
    {
        this.game = game;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try 
        {
            game.sumarATurno();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

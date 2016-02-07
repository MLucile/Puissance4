import javax.swing.*;
import java.awt.event.*;

/**
 * Created by MLucile on 05/02/2016.
 */

public class ControlMouse extends Control implements ActionListener
{
    JButton[][] tabFond = vue.getTabFond();
    ImageIcon[] cartes = vue.getCartes();
    private int auJoueur = 1;
    private int limite;

    public ControlMouse(Model model, Vue vue)
    {
        super(model, vue);
        vue.setMouseControler(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        //Couleur du joueur
        for(int i=0; i<tabFond.length; i++)
        {
            for(int j=0; j<tabFond[i].length; j++)
            {
                if(e.getSource() == tabFond[i][j])
                {
                    if(auJoueur == 1)
                    {
                        if(i+1<tabFond.length)
                        {
                            limite = i;
                            while(limite+1<tabFond.length && tabFond[limite+1][j].getIcon() == cartes[0])
                            {
                                tabFond[limite][j] = new JButton(cartes[0]);
                                tabFond[limite+1][j] = new JButton(cartes[1]);
                                limite++;
                            }
                        }
                        else tabFond[i][j] = new JButton(cartes[1]);
                        auJoueur = 2;
                    }
                    else if(auJoueur == 2)
                    {
                        if(i+1<tabFond.length)
                        {
                            limite = i;
                            while(limite+1<tabFond.length && tabFond[limite+1][j].getIcon() == cartes[0])
                            {
                                tabFond[limite][j] = new JButton(cartes[0]);
                                tabFond[limite+1][j] = new JButton(cartes[2]);
                                limite++;
                            }
                        }
                        else tabFond[i][j] = new JButton(cartes[2]);
                        auJoueur = 1;
                    }
                }
            }
        }

        //déterminer s'il y a victoire ou pas


        vue.setTabFond(tabFond);
        vue.repaint();
        vue.creerWidget();
        vue.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.*;
/**
 * Created by MLucile on 04/02/2016.
 */
public class ControlMenu extends Control implements ActionListener
{
    public ControlMenu(Model model, Vue vue)
    {
        super(model, vue);
        vue.setMenuControler(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        //Nouvelle partie
        if(e.getSource() == vue.getFichierNouvellePartie())
        {
            vue.dispose();
            vue.repaint();
            vue.creerWidget();
            vue.setVisible(true);
        }
        //quitter
        else if(e.getSource() == vue.getFichierQuitter())
        {
            vue.dispose();
        }
        //aide
        else if(e.getSource() == vue.getAbout())
        {
            JOptionPane.showMessageDialog(vue, "Ce programme a été développé par Marie-Lucile");
        }
    }
}

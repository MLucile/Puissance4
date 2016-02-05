import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by MLucile on 03/02/2016.
 */
public class Vue extends JFrame
{
    /**
     * Déclaration des variables
     */
    private int i, j;

    //menu
    private JMenuBar menu;
    private JMenu fichier;
    private JMenuItem fichierNouvellePartie;
    private JMenuItem fichierQuitter;
    private JMenuItem about;

    //éléments
    private ImageIcon fond;
    private JButton[][] tabFond;
    private JPanel grille;


    /**
     * Constructeur de la vue
     */
    public Vue(Model model)
    {
        initAttributs();
        creerWidget();

        setSize(560,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initialise les variables d'instance
     */
    public void initAttributs()
    {
        fond = new ImageIcon(getClass().getResource("Images/jetonNeutre.png"));
        tabFond = new JButton[6][7];
        for(i=0; i<tabFond.length; i++)
        {
            for(j=0; j<tabFond[i].length; j++)
            {
                tabFond[i][j] = new JButton(fond);
            }
        }

        menu = new JMenuBar();
        fichier = new JMenu("Fichier");
        fichierNouvellePartie = new JMenuItem("Nouvelle partie");
        fichier.add(fichierNouvellePartie);
        fichierQuitter = new JMenuItem("Quitter");
        fichier.add(fichierQuitter);
        about = new JMenuItem("A propos");
        menu.add(fichier);
        menu.add(about);
    }

    /**
     * Ajoute les différents éléments au visuel
     */
    public void creerWidget()
    {
        grille = new JPanel(new GridLayout(6,7));
        for(i=0; i<tabFond.length; i++)
        {
            for(j=0; j<tabFond[i].length; j++)
            {
                grille.add(tabFond[i][j]);
            }
        }

        setContentPane(grille);
        setJMenuBar(menu);
    }

    public JMenuItem getFichierNouvellePartie(){
        return fichierNouvellePartie;
    }
    public JMenuItem getFichierQuitter(){
        return fichierQuitter;
    }
    public JMenuItem getAbout()
    {
        return about;
    }

    public void setMenuControler(ActionListener listener)
    {
        fichierNouvellePartie.addActionListener(listener);
        fichierQuitter.addActionListener(listener);
        about.addActionListener(listener);
    }

    public void setMouseControler(MouseListener listener)
    {
        for(i=0; i<tabFond.length; i++)
        {
            for(j=0; j<tabFond[i].length; j++)
            {
                tabFond[i][j].addMouseListener(listener);
            }
        }
    }
}

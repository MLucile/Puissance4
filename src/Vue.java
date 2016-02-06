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

    //Cartes qui vont servire au jeu
    private ImageIcon[] cartes =
            {
                    new ImageIcon(getClass().getResource("Images/jetonNeutre.png")),
                    new ImageIcon(getClass().getResource("Images/jetonJaune.png")),
                    new ImageIcon(getClass().getResource("Images/jetonOrange.png"))
            };


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
        tabFond = new JButton[6][7];
        for(i=0; i<tabFond.length; i++)
        {
            for(j=0; j<tabFond[i].length; j++)
            {
                tabFond[i][j] = new JButton(cartes[0]);
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
    public JButton[][] getTabFond(){ return tabFond; }
    public ImageIcon[] getCartes(){ return cartes; }

    public void setMenuControler(ActionListener listener)
    {
        fichierNouvellePartie.addActionListener(listener);
        fichierQuitter.addActionListener(listener);
        about.addActionListener(listener);
    }

    public void setTabFond(JButton[][] tabFond){ this.tabFond = tabFond; }

    public void setMouseControler(ActionListener listener)
    {
        for(i=0; i<tabFond.length; i++)
        {
            for(j=0; j<tabFond[i].length; j++)
            {
                tabFond[i][j].addActionListener(listener);
            }
        }
    }
}

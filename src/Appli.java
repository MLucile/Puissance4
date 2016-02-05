import javax.swing.*;
/**
 * Created by MLucile on 03/02/2016.
 */
public class Appli
{
    public static void main (String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Model model = new Model();
                ControlGroup controler = new ControlGroup(model);
            }
        });
    }
}

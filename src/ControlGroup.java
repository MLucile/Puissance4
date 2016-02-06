/**
 * Created by MLucile on 04/02/2016.
 */
public class ControlGroup
{
    private Model model;
    private Vue vue;
    public ControlMenu controlMenu;
    public ControlMouse controlMouse;

    public ControlGroup(Model model)
    {
        this.model = model;
        vue = new Vue(model);
        controlMenu = new ControlMenu(model,vue);
        controlMouse = new ControlMouse(model,vue);

    }

}

package frc.robot;

// Imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants;

import java.util.HashMap;

public class OI
{
    //Declare Joystick map
    HashMap<String, Joystick> JoyMap;
    HashMap<String, JoystickButton> buttons;

    public OI()
    {
        //Initialize Joystick map
        JoyMap = new HashMap<>();
        buttons = new HashMap<>();

        switch (Constants.controls)
        {
            case XBOX:
            JoyMap.put("Xbox", new Joystick(Constants.XBOX));
            break;

            case JOYSTICKS:
            JoyMap.put("JoyL", new Joystick(Constants.JOYL));
            JoyMap.put("JoyR", new Joystick(Constants.JOYR));
            break;

            default:
            System.out.println("No Control Configuration Selected");
            break;
        }
        

        //Subscribe buttons
    }

    public Joystick getController(String controller){
        return JoyMap.get(controller);
    }

    public void addButton(String name, String joy, int num)
    {
        buttons.put(name, new JoystickButton(JoyMap.get(joy), num));
    }
}
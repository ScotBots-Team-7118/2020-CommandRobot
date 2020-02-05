package frc.robot;

// Imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants;
import frc.robot.gyro.Gyroscope;

import java.util.HashMap;

public class OI
{
    //Declare Joystick map
    HashMap<String, Joystick> joyMap;
    HashMap<String, JoystickButton> buttons;

    public Gyroscope gyro;

    public OI()
    {
        gyro = new Gyroscope();

        //Initialize Joystick map
        joyMap = new HashMap<>();
        buttons = new HashMap<>();

        switch (Constants.controls)
        {
            case XBOX:
            joyMap.put("Xbox", new Joystick(Constants.XBOX));
            break;

            case JOYSTICKS:
            joyMap.put("JoyL", new Joystick(Constants.JOYL));
            joyMap.put("JoyR", new Joystick(Constants.JOYR));
            break;

            default:
            System.out.println("No Control Configuration Selected");
            break;
        }

        //Subscribe buttons
    }

    public Joystick getController(String controller){
        return joyMap.get(controller);
    }

    public void addButton(String name, String joy, int num)
    {
        buttons.put(name, new JoystickButton(joyMap.get(joy), num));
    }

    public JoystickButton getButton(String name)
    {
        return buttons.get(name);
    }
}
package frc.robot;

//imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import java.util.HashMap;

import frc.robot.Constants;

public class OI {
    //Declare Joystick map
    HashMap<String, Joystick> JoyMap;
    HashMap<String, JoystickButton> buttons;

    public OI()
    {
        //Initialize Joystick map
        JoyMap = new HashMap<>();
        buttons = new HashMap<>();

        JoyMap.put("JoyL", new Joystick(Constants.JOYL));
        JoyMap.put("JoyR", new Joystick(Constants.JOYR));
        JoyMap.put("Xbox", new Joystick(Constants.XBOX));

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
package frc.robot;

/* Imports */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants;

import java.util.HashMap;

/**
 * Framework for the operator interface for the robot.
 * 
 * Contains necessary sensors and manual control objects (i.e. joysticks).
 */
public class OI
{
    /* Class Variable Declaration */
    HashMap<String, Joystick> joyMap;
    HashMap<String, JoystickButton> buttons;
    

    /**
     * Constructs the Operator Interface.
     */
    public OI()
    {
        /* Class Variable Instantiation */
        

        joyMap = new HashMap<>();
        buttons = new HashMap<>();

        // joyMap.put("TurC", new Joystick(Constants.TURC));

        // Set up the controls configuration as dictated in Constants
        switch (Constants.controls)
        {
            case XBOX:
            joyMap.put("Xbox", new Joystick(Constants.p_XBOX));
            break;

            case JOYSTICKS:
            joyMap.put("JoyL", new Joystick(Constants.p_JOYL));
            joyMap.put("JoyR", new Joystick(Constants.p_JOYR));
            break;

            case DUALDRIVERS:
            joyMap.put("Left", new Joystick(Constants.p_DUALDRIVERS[0]));
            joyMap.put("Right", new Joystick(Constants.p_DUALDRIVERS[1]));
            joyMap.put("Xbox", new Joystick(Constants.p_DUALDRIVERS[2]));
            break;

            default:
            System.out.println("No Control Configuration Selected");
            break;
        }
    }

    /**
     * @param name of a joystick in the OI.
     * @return A desired Joystick object from the OI.
     */
    public Joystick getController(String name)
    {
        return joyMap.get(name);
    }

    /**
     * Add a particular button to the operator interface.
     * Although these buttons could technically be accessed using the joystick object(s),
     * this implementation makes it easier for the developers to understand
     * the functionality of each button and allows for smoother implementation
     * of configureButtonBindings() in RobotContainer.
     * 
     * @param name of the button.
     * @param joystick that the button belongs to.
     * @param number assigned to the button by the controller in the Driver Station.
     */
    public void addButton(String name, String joystick, int number)
    {
        buttons.put(name, new JoystickButton(joyMap.get(joystick), number));
    }

    /**
     * @param name of a joystick button in the OI.
     * @return A desired JoystickButton object from the OI.
     */
    public JoystickButton getButton(String name)
    {
        return buttons.get(name);
    }
}
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

    //Declare Controllers
    public Joystick JoyL = null;
    public Joystick JoyR = null;
    public XboxController XBOX = null;

    //declare Joy buttons
    JoystickButton Rbtn1, Rbtn2, Rbtn3, Rbtn4, Rbtn5, Rbtn6, Rbtn7, Rbtn8,
                   Lbtn1, Lbtn2, Lbtn3, Lbtn4, Lbtn5, Lbtn6, Lbtn7, Lbtn8  = null;
    
    //declare Xbox buttons
    JoystickButton btnA, btnX, btnY, btnB = null; 

    public OI(){
        //Initialize Joystick map
        JoyMap = new HashMap<>();
        JoyMap.put("JoyL", JoyL);
        JoyMap.put("JoyR", JoyR);

        //Initialize controllers
        JoyL = new Joystick(Constants.JOYL);
        JoyR = new Joystick(Constants.JOYR);
        XBOX = new XboxController(Constants.XBOX);

        //Joystick Button maps
        Rbtn1 = new JoystickButton(JoyR, 1);
        Rbtn2 = new JoystickButton(JoyR, 2);
        Rbtn3 = new JoystickButton(JoyR, 3);
        Rbtn4 = new JoystickButton(JoyR, 4);
        Rbtn5 = new JoystickButton(JoyR, 5);
        Rbtn6 = new JoystickButton(JoyR, 6);
        Rbtn7 = new JoystickButton(JoyR, 7);
        Rbtn8 = new JoystickButton(JoyR, 8);

        Lbtn1 = new JoystickButton(JoyL, 1);
        Lbtn2 = new JoystickButton(JoyL, 2);
        Lbtn3 = new JoystickButton(JoyL, 3);
        Lbtn4 = new JoystickButton(JoyL, 4);
        Lbtn5 = new JoystickButton(JoyL, 5);
        Lbtn6 = new JoystickButton(JoyL, 6);
        Lbtn7 = new JoystickButton(JoyL, 7);
        Lbtn8 = new JoystickButton(JoyL, 8);

        btnA = new JoystickButton(XBOX, 1);
        btnB = new JoystickButton(XBOX, 2);
        btnX = new JoystickButton(XBOX, 3);
        btnY = new JoystickButton(XBOX, 4);

        //Subscribe buttons
    }

    public HashMap<String, Joystick> getJoy(){
        return JoyMap;
    }

    public XboxController getXbox(){
        return XBOX;
    }
}
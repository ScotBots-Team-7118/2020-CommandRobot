package frc.robot.commands.startgame;

//Imports
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.Constants;
import frc.robot.commands.teleop.*;

public class TeleopGroup extends ParallelCommandGroup{

    public TeleopGroup(){
        
        //Choose control scheme
        ChooseControl(Constants.D_CONTROLS);
    }

    /**
     * Types of controls
     */
    public enum ControlType{
        XBOX,
        JOYSTICK
    }
    ControlType controlType;

    /**
     * Decide controls to use.
     */
    public void ChooseControl(int type){
        if(type == 0){
            controlType = ControlType.JOYSTICK;
        }else if(type == 1){
            controlType = ControlType.XBOX;
        }else{
            controlType = ControlType.JOYSTICK;
        }

        switch(controlType){
            case XBOX:
                addCommands(new TeleXboxDrive());
                break;
            case JOYSTICK:
                addCommands(new TeleJoyDrive());
                break;
        }
    }
}
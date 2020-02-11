package frc.robot.commands.startgame;

/* Imports */
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.Constants;
import frc.robot.commands.macros.MacroRunShooter;
import frc.robot.commands.teleop.*;

/**
 * CommandGroup for scheduling and executing commands in teleop.
 */
public class TeleopGroup extends ParallelCommandGroup
{
    /* TODO: Finish implementing me! */
    // Add functionality for this year's controls configuration
    // List & schedule the commands to be run in teleop

    /**
     * Constructs a new TeleopGroup.
     */
    public TeleopGroup()
    {
        setControls(Constants.controls);
    }

    /**
     * Configure the teleop commands based on the chosen controls configuration.
     */
    public void setControls(Constants.ControlsConfig type)
    {
        switch (type)
        {
            case XBOX:
                // addCommands(new TeleXboxDrive());
                addCommands(new MacroRunShooter());
                break;
            
            case JOYSTICKS:
                addCommands(new TeleJoyDrive());
                break;
            
            default:
                System.out.println("No control set selected.");
                break;
        }
    }
}
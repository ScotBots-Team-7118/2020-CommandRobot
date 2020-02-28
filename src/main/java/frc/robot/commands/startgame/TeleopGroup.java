package frc.robot.commands.startgame;

/* Imports */
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.commands.teleop.*;
import frc.robot.subsystems.DriveTrain;

/**
 * CommandGroup for scheduling and executing commands in teleop.
 */
public class TeleopGroup extends ParallelCommandGroup
{
    // Add functionality for this year's controls configuration
    // List & schedule the commands to be run in teleop

    /**
     * Constructs a new TeleopGroup.
     * @param d
     * @param oi
     */
    public TeleopGroup(DriveTrain d, OI oi)
    {
        setControls(d, oi,Constants.controls);
    }

    /**
     * Configure the teleop commands based on the chosen controls configuration.
     * @param d
     * @param oi
     * @param type
     */
    public void setControls(DriveTrain d, OI oi,Constants.ControlsConfig type)
    {
        switch (type)
        {
            case XBOX:
                // addCommands(new TeleXboxDrive());
                addCommands(new TeleXboxDrive(d,oi));
                break;
            
            case JOYSTICKS:
                addCommands(new TeleJoyDrive(d, oi));
                break;

            case DUALDRIVERS:
                addCommands(new TeleJoyDrive(d, oi));
                break;
            
            default:
                System.out.println("No controls configuration selected.");
                break;
        }
    }
}
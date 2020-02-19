package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.Constants;

/**
 * The command group for the center autonomous program.
 * In this scenario, the robot is placed directly
 * in front of the power port.
 */
public class AutoCenterGroup extends SequentialCommandGroup
{
    /* TODO: Finish implementing me! */

    /* Instance Variable Declaration */


    /**
     * Constructs a new AutoCenterGroup command group.
     */
    public AutoCenterGroup()
    {
        // Place robot directly in front of the target zone facing it
        // Shoot from four feet behind the initiation line 
        addCommands(new AutoDriveStraight(Constants.AUTO_CENTER_DIST));
        addCommands(new AutoShoot());
        
    }
}
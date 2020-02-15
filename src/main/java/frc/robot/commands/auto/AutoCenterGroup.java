package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.Constants;

/**
 * The command group for the center autonomous program.
 */
public class AutoCenterGroup extends SequentialCommandGroup
{
    /* TODO: Implement me! */

    /* Instance Variable Declaration */


    /**
     * Constructs a new AutoCenterGroup command group.
     */
    public AutoCenterGroup()
    {
         //For robot placed directly in front of power port
         //Robot will shoot from the initiation line, and then reverse four feet
        addCommands(new AutoShoot());
        addCommands(new AutoDriveStraight(Constants.AUTO_CENTER_DIST));
    }
}
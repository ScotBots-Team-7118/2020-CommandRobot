package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.commands.macros.MacroAim;
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
         // Shoot from the initiation line, and then reverse four feet (a given distance)
        addCommands(new MacroAim());
        addCommands(new AutoShoot());
        addCommands(new AutoDriveStraight(Constants.AUTO_CENTER_DIST[1]));
    }
}
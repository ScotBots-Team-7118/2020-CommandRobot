package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.commands.macros.MacroAim;
import frc.robot.Constants;

/**
 * The command group for the right-side autonomous program.
 * In this scenario, the robot is placed against the side
 * of the playing area closest to the target zone.
 */
public class AutoRightGroup extends SequentialCommandGroup
{
    /* TODO: Finish implementing me! */

    /* Instance Variable Declaration */
    

    /**
     * Constructs a new AutoRightGroup command group.
     */
    public AutoRightGroup()
    {
        // Place the robot on wall facing in toward the field 
        // Robot will shoot from four feet behind initiation line, facing it
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST[0]));
        addCommands(new AutoTurn(Constants.AUTO_RIGHT_ANGLE));
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST[1]));
        addCommands(new MacroAim(true));//Aims shooter
        addCommands(new AutoShoot());
    }
}
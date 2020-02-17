package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.autocommands.*;


/**
 * The command group for the left-side autonomous program.
 * In this scenario, the robot is placed directly in front
 * of the opponent's loading bay.
 */
public class AutoLeftGroup extends SequentialCommandGroup
{
    /* TODO: Finish implementing me! */

    /* Instance Variable Declaration */
    

    /**
     * Constructs a new AutoLeftGroup command group.
     */
    public AutoLeftGroup()
    {
        // Robot will shoot from four feet behind the initiation line, facing the target
        addCommands(new AutoDriveStraight(Constants.AUTO_LEFT_DIST[0]));
        addCommands(new AutoTurn(Constants.AUTO_LEFT_ANGLE[0]));
        addCommands(new AutoDriveStraight(Constants.AUTO_LEFT_DIST[1]));
        addCommands(new AutoTurn(Constants.AUTO_LEFT_ANGLE[1]));
        addCommands(new AutoShoot());
    }
}
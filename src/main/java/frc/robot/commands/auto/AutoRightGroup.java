package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.Constants;

/**
 * The command group for the right-side autonomous program.
 */
public class AutoRightGroup extends SequentialCommandGroup
{
    /* TODO: Implement me! */

    /* Instance Variable Declaration */
    

    /**
     * Constructs a new AutoRightGroup command group.
     */
    public AutoRightGroup()
    {
        //For a robot placed against the side of the playing area closest to the target zone
        //robot will shoot from four feet behind initiation line, facing it
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST_1));
        addCommands(new AutoTurn(Constants.AUTO_RIGHT_ANG_1));
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST_2));
        addCommands(new AutoTurn(Constants.AUTO_RIGHT_ANG_2));
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST_3));
        addCommands(new AutoTurn(Constants.AUTO_RIGHT_ANG_3));
        addCommands(new AutoShoot());
    }
}
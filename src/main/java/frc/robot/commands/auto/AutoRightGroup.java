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
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST_1));
        addCommands(new AutoTurn(Constants.AUTO_RIGHT_ANG_1));
        addCommands(new AutoDriveStraight(Constants.AUTO_RIGHT_DIST_2));
        addCommands(new AutoTurn(Constants.AUTO_RIGHT_ANG_2));
        addCommands(new AutoShoot());
    }
}
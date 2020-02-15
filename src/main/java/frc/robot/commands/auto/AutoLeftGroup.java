package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.autocommands.*;


/**
 * The command group for the left-side autonomous program.
 */
public class AutoLeftGroup extends SequentialCommandGroup
{
    /* TODO: Implement me! */

    /* Instance Variable Declaration */
    

    /**
     * Constructs a new AutoLeftGroup command group.
     */
    public AutoLeftGroup()
    {
        addCommands(new AutoDriveStraight(Constants.AUTO_LEFT_DIST_1));
        addCommands(new AutoTurn(Constants.AUTO_LEFT_ANG_1));
        addCommands(new AutoDriveStraight(Constants.AUTO_LEFT_DIST_2));
        addCommands(new AutoTurn(Constants.AUTO_LEFT_ANG_2));
        addCommands(new AutoShoot());
    }
}
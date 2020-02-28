package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.commands.macros.MacroRotateTurret;

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
        addCommands(new AutoDriveStraight(Constants.AUTO_LEFT_DIST));
        addCommands(new MacroRotateTurret(Constants.AUTO_LEFT_TURRET_ANGLE)); //Rotate turret to general position so that vision can align it 
        addCommands(new AutoShoot());
    }
}
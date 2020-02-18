package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.commands.macros.MacroAim;



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
        // Place the robot in line with the opponents loading bay, facing away from the target
        // Robot will shoot from four feet behind the initiation line, facing the target
        addCommands(new AutoDriveStraight(Constants.AUTO_LEFT_DIST));
        addCommands(new MacroAim(true)); //Aims shooter
        addCommands(new AutoShoot());
    }
}
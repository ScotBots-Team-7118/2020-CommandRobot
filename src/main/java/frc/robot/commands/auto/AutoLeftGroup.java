package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.commands.macros.MacroRotateTurret;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

/**
 * The command group for the left-side autonomous program.
 * In this scenario, the robot is placed directly in front
 * of the opponent's loading bay.
 */
public class AutoLeftGroup extends SequentialCommandGroup
{

    /**
     * Constructs a new AutoLeftGroup command group.
     * @param d
     * @param t
     * @param id
     * @param s
     */
    public AutoLeftGroup(DriveTrain d, Turret t, Indexer id, Shooter s)
    {
        addCommands(new AutoDriveStraight(d, Constants.AUTO_LEFT_DIST));
        addCommands(new MacroRotateTurret(t, Constants.AUTO_LEFT_TURRET_ANGLE)); //Rotate turret to general position so that vision can align it 
        addCommands(new AutoShoot(id,s,t));
    }
}
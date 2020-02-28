package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.Constants;

/**
 * The command group for the center autonomous program.
 * In this scenario, the robot is placed directly
 * in front of the power port.
 */
public class AutoCenterGroup extends SequentialCommandGroup
{

    /**
     * Constructs a new AutoCenterGroup command group.
     * @param d
     * @param id
     * @param s
     * @param t
     */
    public AutoCenterGroup(DriveTrain d, Indexer id, Shooter s, Turret t)
    {
        // Place robot directly in front of the target zone facing target
        // Shoot from four feet behind the initiation line 
        addCommands(new AutoDriveStraight(d,Constants.AUTO_CENTER_DIST));
        addCommands(new AutoShoot(id, s, t));
        
    }
}
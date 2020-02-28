package frc.robot.commands.auto;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.autocommands.*;
import frc.robot.Constants;
import frc.robot.commands.macros.MacroRotateTurret;
import frc.robot.gyro.Gyroscope;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

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
    public AutoRightGroup(DriveTrain d, Turret t, Indexer id , Shooter s, Gyroscope g)
    {
        // Robot will shoot from four feet behind initiation line, facing it
        addCommands(new AutoDriveStraight(d,Constants.AUTO_RIGHT_DIST[0]));
        addCommands(new AutoTurn(d,Constants.AUTO_RIGHT_ANGLE, g));
        addCommands(new AutoDriveStraight(d,Constants.AUTO_RIGHT_DIST[1]));
        addCommands(new MacroRotateTurret(t,Constants.AUTO_RIGHT_TURRET_ANGLE));
        addCommands(new AutoShoot(id,s,t));
    }
}
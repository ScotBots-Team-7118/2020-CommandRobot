package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.macros.*;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

/**
 * Command to run the shooter autonomously.
 * 
 * Requires the Shooter subsystem.
 */
public class AutoShoot extends SequentialCommandGroup
{

    /**
     * Constructs a new AutoShooter command with a Shooter requirement.
     * @param id
     * @param s
     * @param t
     */
    public AutoShoot(Indexer id, Shooter s, Turret t)
    {
     addCommands(new MacroAim(t,true));  
     addCommands(new MacroRunShooter(s,true));
     addCommands(new MacroFire(id, 3));
    }
}
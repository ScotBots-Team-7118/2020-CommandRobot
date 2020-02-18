package frc.robot.commands.auto.autocommands;

/* Imports */
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.macros.*;

/**
 * Command to run the shooter autonomously.
 * 
 * Requires the Shooter subsystem.
 */
public class AutoShoot extends SequentialCommandGroup
{

    /**
     * Constructs a new AutoShooter command with a Shooter requirement.
     */
    public AutoShoot()
    {
     addCommands(new MacroAim(true));  
     addCommands(new MacroRunShooter(true));
     addCommands(new MacroFire(3));
    }
}
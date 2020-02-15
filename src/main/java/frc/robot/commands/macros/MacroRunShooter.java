package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Shooter;

/**
 * Command to run the shooter to shoot power cells out of the robot.
 * 
 * Requires the Shooter subsystem.
 */
public class MacroRunShooter extends CommandBase
{
    /* Instance Variable Declaration */
    Shooter _shooter;

    /**
     * Constructs a new MacroRunShooter command with a Shooter requirement.
     */
    public MacroRunShooter()
    {
        _shooter = RobotContainer.s_Shooter;
        addRequirements(_shooter);
    }

    @Override
    public void execute()
    {
        // TODO: Finish implementing me!
        // Shouldn't shoot if the indexer is empty.
        // TODO: Nathaniel, if this needs to be negative to run the shooter out, we should just invert the shooter talon.
        _shooter.set(Constants.SHOOTER_SPEED);
    }
}
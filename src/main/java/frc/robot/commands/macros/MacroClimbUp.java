package frc.robot.commands.macros;

// Imports
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Climber;

/**
 * Command for the robot to climb up.
 * 
 * Requires the Climber subsystem.
 */
public class MacroClimbUp extends CommandBase
{
    /* TODO: Untested Code */

    /* Instance Variable Declaration */
    Climber _climber;

    /**
     * Constructs a new MacroClimbUp command with a Climber requirement.
     */
    public MacroClimbUp(Climber c)
    {
        _climber = c;
        addRequirements(_climber);
    }

    @Override
    public void execute()
    {
        _climber.set(Constants.CLIMBER_VELOCITY_U);
    }
}
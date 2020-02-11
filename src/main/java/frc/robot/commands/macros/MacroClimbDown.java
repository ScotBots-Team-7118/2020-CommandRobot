package frc.robot.commands.macros;

/* Imports */
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.*;
import frc.robot.subsystems.Climber;

/**
 * Command for the robot to climb down.
 * 
 * Requires the Climber subsystem.
 */
public class MacroClimbDown extends CommandBase
{
    /* TODO: Untested Code */

    /* Instance Variable Declaration */
    Climber _climber;

    /**
     * Constructs a new MacroClimbDown command with a Climber requirement.
     */
    public MacroClimbDown()
    {
        _climber = RobotContainer.s_Climber;
        addRequirements(_climber);
    }

    @Override
    public void execute()
    {
        _climber.update(Constants.CLIMBER_VELOCITY_D);
    }
}